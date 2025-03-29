package org.qingyuserver.qingYuSereverListen.ServerListens;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerDeathGames implements Listener {
    private final JavaPlugin plugin;
    private final List<String> taunts = new ArrayList<>();
    private final Random random = new Random();

    public PlayerDeathGames(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 1.0F);
        }
        plugin.getLogger().warning("没有可用的嘲讽消息，使用默认消息。");
        String playerDeathMessage = "§b玩家：" + player.getName() + "给自己玩死了。大家快笑他！你行不行啊细狗，我拿脚玩都比你好！§r";
        event.setDeathMessage(playerDeathMessage);
    }
}
