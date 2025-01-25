package org.qingyuserver.qingYuSereverListen.ServerListens;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinGames implements Listener {
    @EventHandler
    public void onPlayerJoinGame(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerJoinMessage = player.isOp() ? "欢迎管理员：§4" + player.getName() + "§r加入服务器！" : "欢迎：" + player.getName() + "加入服务器";
        event.setJoinMessage(playerJoinMessage);
    }
}
