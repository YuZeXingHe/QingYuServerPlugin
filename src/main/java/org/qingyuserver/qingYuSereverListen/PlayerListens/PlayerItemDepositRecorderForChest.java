package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PlayerItemDepositRecorderForChest implements Listener {
    private final Map<Location, ItemStack[]> chestInventoryMap = new HashMap<>();
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();
        Block block = Bukkit.getWorld(event.getView().getTopInventory().getLocation().getWorld().getName())
                .getBlockAt(event.getView().getTopInventory().getLocation());
        if (block.getType() == Material.CHEST) {
            Chest chest = (Chest) block.getState();
            Location chestLocation = chest.getLocation();
            chestInventoryMap.put(chestLocation, chest.getInventory().getContents().clone());
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        Block block = Bukkit.getWorld(event.getView().getTopInventory().getLocation().getWorld().getName())
                .getBlockAt(event.getView().getTopInventory().getLocation());
        if (block.getType() == Material.CHEST) {
            Chest chest = (Chest) block.getState();
            Location chestLocation = chest.getLocation();
            if (chestInventoryMap.containsKey(chestLocation)) {
                ItemStack[] initialContents = chestInventoryMap.get(chestLocation);
                ItemStack[] currentContents = chest.getInventory().getContents();
                Player player = (Player) event.getPlayer();

                for (int i = 0; i < initialContents.length; i++) {
                    ItemStack initialItem = initialContents[i];
                    ItemStack currentItem = currentContents[i];
                    if ((initialItem == null && currentItem != null) || (initialItem != null && currentItem != null && initialItem.getAmount() < currentItem.getAmount())) {
                        int depositedAmount = (currentItem != null ? currentItem.getAmount() : 0) - (initialItem != null ? initialItem.getAmount() : 0);
                        Bukkit.getLogger().info(player.getName() +
                                "向箱子(" + chestLocation.getBlockX() +
                                "，" + chestLocation.getBlockY() +
                                "，" + chestLocation.getBlockZ() +
                                ")中存入了" + depositedAmount +
                                "个" + currentItem.getType().name());
                    }
                }
                chestInventoryMap.remove(chestLocation);
            }
        }
    }
}
