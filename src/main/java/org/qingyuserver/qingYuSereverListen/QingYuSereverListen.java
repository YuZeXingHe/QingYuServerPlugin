package org.qingyuserver.qingYuSereverListen;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.qingyuserver.qingYuSereverListen.Commands.KillsCommand;
import org.qingyuserver.qingYuSereverListen.PlayerListens.*;
import org.qingyuserver.qingYuSereverListen.ServerListens.PlayerDeathGames;
import org.qingyuserver.qingYuSereverListen.ServerListens.PlayerJoinGames;
import org.qingyuserver.qingYuSereverListen.ServerListens.PlayerKickGames;
import org.qingyuserver.qingYuSereverListen.ServerListens.PlayerQuitGames;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class QingYuSereverListen extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, this::updateScoreboard, 0, 20);
        getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerConsumes(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinGames(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitGames(), this);
        getServer().getPluginManager().registerEvents(new PlayerKickGames(), this);
        getServer().getPluginManager().registerEvents(new PlayerOpenChest(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathGames(), this);
        getServer().getPluginManager().registerEvents(new PlayerBreakBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillEntity(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerBucketEmpty(), this);
        getServer().getPluginManager().registerEvents(new PlayerEntityDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerItemTakeRecorderForChest(), this);
        getServer().getPluginManager().registerEvents(new PlayerItemDepositRecorderForChest(), this);
        this.getCommand("kills").setExecutor(new KillsCommand());
        getLogger().info("轻语服务器插件加载成功！");
        getLogger().info("插件加载成功，如遇到错误，请在群内联系服务器管理员！");
    }

    @Override
    public void onDisable() {
        getLogger().info("插件卸载成功，如遇到错误，请在群内联系服务器管理员！");
    }

    private void updateScoreboard() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            updatePlayerScoreboard(player);
        }
    }

    private void updatePlayerScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.getObjective("info");
        if (objective == null) {
            objective = scoreboard.registerNewObjective("info", "dummy", "Minecraft轻语生存服");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        double[] tps = Bukkit.getServer().getTPS();
        double tpsValue = tps[0];

        objective.getScore("Java版支持：§b开启§r").setScore(6);
        objective.getScore("基岩版支持：§b开启§r").setScore(5);
        objective.getScore("特性：§bJava Edition§r").setScore(4);
        objective.getScore("时间：§b" + formattedTime + "§r").setScore(3);
        objective.getScore("服务器TPS：§b" + String.format("%.1f", tpsValue) + "§r").setScore(2);
        objective.getScore("服务器版本：§b1.4.0§r").setScore(1);
        objective.getScore("游戏版本：§b1.21.1§r").setScore(0);

        player.setScoreboard(scoreboard);
    }
}
