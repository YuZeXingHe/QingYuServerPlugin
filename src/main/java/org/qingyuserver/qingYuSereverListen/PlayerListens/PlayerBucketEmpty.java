package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class PlayerBucketEmpty implements Listener {
    @EventHandler
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
        Player player = event.getPlayer();
        Block blockClicked = event.getBlockClicked();
        String blockLocation = "X：" + blockClicked.getX() + "，Y：" + blockClicked.getY() + "，Z：" + blockClicked.getZ();
        Material bucketType = event.getBucket();
        if (bucketType == Material.WATER_BUCKET) {
            Bukkit.getLogger().info("玩家：" + player.getName() + "倒下了一桶水，位置：" + blockLocation);
        }
        else if (bucketType == Material.LAVA_BUCKET) {
            Bukkit.getLogger().info("玩家：" + player.getName() + "倒下了一桶岩浆，位置：" + blockLocation);
        }
    }
}
