package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerOpenChest implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.hasBlock()) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType() == Material.CHEST) {
                BlockState state = block.getState();
                if (state instanceof Chest) {
                    Chest chest = (Chest) state;
                    String location = chest.getLocation().toString();
                    Bukkit.getLogger().info("玩家" + player.getName() + "打开了箱子，位置：" + location);
                }
            }
        }
    }
}
