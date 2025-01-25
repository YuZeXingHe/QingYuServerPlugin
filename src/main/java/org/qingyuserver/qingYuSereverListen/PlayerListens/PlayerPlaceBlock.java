package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlock implements Listener {
    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlockPlaced();
        String blockLocation = "X：" + block.getX() + "，Y：" + block.getY() + "，Z：" + block.getZ();
        Bukkit.getLogger().info("玩家：" + player.getName() + "放置了: " + block);
    }
}
