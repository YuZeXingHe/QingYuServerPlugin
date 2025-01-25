package org.qingyuserver.qingYuSereverListen.ServerListens;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PlayerKickGames implements Listener {
    @EventHandler
    public void onPlayerKickGame(PlayerKickEvent event) {
        Player player = event.getPlayer();
        String kickReason = event.getReason();
        String playerKickMessage = "§4玩家：" + player.getName() + "被踢出了服务器，原因如下：" + kickReason + "§r";
        event.setLeaveMessage(playerKickMessage);
    }
}
