package org.qingyuserver.qingYuSereverListen;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.qingyuserver.qingYuSereverListen.Commands.*;
import org.qingyuserver.qingYuSereverListen.PlayerListens.*;
import org.qingyuserver.qingYuSereverListen.ServerListens.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class QingYuSereverListen extends JavaPlugin implements Listener {
    private boolean placeholderEnabled;
    private PlaceholderExpansions placeholderExpansions;
    private final Map<UUID, Inventory> playerWarehouses = new HashMap<>();

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            placeholderEnabled = true;
        }
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerConsumes(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitGames(), this);
        getServer().getPluginManager().registerEvents(new PlayerOpenChest(), this);
        getServer().getPluginManager().registerEvents(new PlayerBreakBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillEntity(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerBucketEmpty(), this);
        getServer().getPluginManager().registerEvents(new PlayerEntityDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinGames(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathGames(this), this);
        this.getCommand("ck").setExecutor(new CangKuCommand());
        this.getCommand("kills").setExecutor(new KillsCommand());
        this.getCommand("clears").setExecutor(new ClearsCommand());
        this.getCommand("ranking").setExecutor(new RankingCommand());
        this.getCommand("killsitem").setExecutor(new KillsItemCommand());
        this.getCommand("ranking").setTabCompleter(new RankingCommand());
        placeholderExpansions = new PlaceholderExpansions(this);
        placeholderExpansions.register();
        getLogger().info("轻语服务器插件加载成功！");
        getLogger().info("插件加载成功，如遇到错误，请在群内联系服务器管理员！");
    }

    @Override
    public void onDisable() {
        placeholderExpansions.unregister();
        getLogger().info("插件卸载成功，如遇到错误，请在群内联系服务器管理员！");
    }

    public boolean isplaceholderEnabled() {
        return placeholderEnabled;
    }
}
