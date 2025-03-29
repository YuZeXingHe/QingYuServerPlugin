package org.qingyuserver.qingYuSereverListen.ServerListens;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.qingyuserver.qingYuSereverListen.QingYuSereverListen;
import org.qingyuserver.qingYuSereverListen.TextUtils;

public class PlayerJoinGames implements Listener {
    private final QingYuSereverListen plugin;

    public PlayerJoinGames(QingYuSereverListen plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinGame(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerJoinMessage = player.isOp() ? "欢迎管理员：§4" + player.getName() + "§r加入服务器！" : "欢迎：" + player.getName() + "加入服务器";
        event.setJoinMessage(playerJoinMessage);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1.0f, 2.0f);
        }

        if (plugin.isplaceholderEnabled()) {
            player.setPlayerListName(
                    TextUtils.parseColor(PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%" + player.getName() + "%luckperms_suffix%"))
            );
            player.setPlayerListHeader("§b轻语生存服：玩家列表§r");
            player.setPlayerListFooter(
                    TextUtils.parseColor("§a您的幸运值：" + PlaceholderAPI.setPlaceholders(player, "%QingYuSereverListen_luck%§r"))
            );
        }
    }
}
