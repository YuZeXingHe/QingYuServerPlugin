package org.qingyuserver.qingYuSereverListen.PlayerListens;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerKillEntity implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity) {
            Player killer = event.getEntity().getKiller();
            if (killer != null) {
                String entityType = entity.getType().toString();
                Bukkit.getLogger().info("玩家" + killer.getName() + "，击杀了" + entityType);
            }
        }
    }
}
