package org.qingyuserver.qingYuSereverListen;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PlaceholderExpansions extends PlaceholderExpansion {
    private final QingYuSereverListen plugin;
    private final Random random = new Random();

    public PlaceholderExpansions(QingYuSereverListen plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "QingYuSereverListen";
    }

    @Override
    public @NotNull String getAuthor() {
        return "YuZeXingHe";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        if ("luck".equalsIgnoreCase(params)) {
            return Integer.toString(onRandomLuckNumber());
        }
        return null;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if ("luck".equalsIgnoreCase(params)) {
            return Integer.toString(onRandomLuckNumber());
        }
        return null;
    }

    private int onRandomLuckNumber() {
        return random.nextInt(100) + 1;
    }
}
