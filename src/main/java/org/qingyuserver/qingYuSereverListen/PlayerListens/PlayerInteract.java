package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();
        if ((action == Action.RIGHT_CLICK_BLOCK) && (block.getType() == Material.LEVER || block.getType() == Material.STONE_BUTTON || block.getType() == Material.OAK_BUTTON)) {
            Location location = block.getLocation();
            String blockType = block.getType().name();
            Bukkit.getLogger().info(player.getName() + "操作了" + blockType + "，位置：(" + location.getBlockX() + "，" + location.getBlockY() + "，" + location.getBlockZ() + ")");
        }
    }
}
