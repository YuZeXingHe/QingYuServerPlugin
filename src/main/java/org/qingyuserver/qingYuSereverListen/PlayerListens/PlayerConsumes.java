package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerConsumes implements Listener {
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        String playerName = event.getPlayer().getName();
        ItemStack consumedItem = event.getItem();
        Material itemType = consumedItem.getType();
        Bukkit.getLogger().info(playerName + "食用了：" + itemType);
    }
}
