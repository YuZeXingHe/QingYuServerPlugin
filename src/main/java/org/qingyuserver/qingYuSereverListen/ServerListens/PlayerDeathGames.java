package org.qingyuserver.qingYuSereverListen.ServerListens;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathGames implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        String playerDeathMessage = "玩家：" + player.getName() + "给自己玩死了，大家快笑他！";
        event.setDeathMessage(playerDeathMessage);
    }
}
