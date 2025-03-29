package org.qingyuserver.qingYuSereverListen.ServerListens;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1.0f, 2.0f);
        }
    }
}
