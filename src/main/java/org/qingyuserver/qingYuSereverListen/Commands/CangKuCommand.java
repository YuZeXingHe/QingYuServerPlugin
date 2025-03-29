package org.qingyuserver.qingYuSereverListen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CangKuCommand implements CommandExecutor {
    private Map<String, Inventory> playerWarehouses = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("ck")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String warehouseName = player.getName() + "的临时仓库";
                Inventory warehouse = getOrCreateWarehouse(player.getName(), warehouseName);
                player.openInventory(warehouse);
                return true;
            } else {
                sender.sendMessage("只有玩家可以使用此指令！");
            }
        }
        return false;
    }

    private Inventory getOrCreateWarehouse(String playerName, String warehouseName) {
        if (playerWarehouses.containsKey(playerName)) {
            return playerWarehouses.get(playerName);
        } else {
            Inventory warehouse = Bukkit.createInventory(null, 6 * 9, warehouseName);
            playerWarehouses.put(playerName, warehouse);
            return warehouse;
        }
    }
}
