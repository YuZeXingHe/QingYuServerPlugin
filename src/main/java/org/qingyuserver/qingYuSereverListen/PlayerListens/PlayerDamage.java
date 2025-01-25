package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            double damage = event.getDamage();
            Bukkit.getLogger().info("玩家" + player.getName() + "，受到了" + damage + "点伤害。");
        }
    }
}
