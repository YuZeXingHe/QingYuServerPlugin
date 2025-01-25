package org.qingyuserver.qingYuSereverListen.ServerListens;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitGames implements Listener {
    @EventHandler
    public void onPlayerQuitGame(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String playerQuitMessage = player.isOp() ? "管理员：§4" + player.getName() + "§r离开了服务器" : "玩家：" + player.getName() + "离开了服务器";
        event.setQuitMessage(playerQuitMessage);
    }
}
