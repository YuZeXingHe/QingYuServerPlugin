package org.qingyuserver.qingYuSereverListen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class RankingCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("ranking")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("death")) {
                if (sender instanceof Player) {
                    sendDeathRanking((Player) sender);
                }
                else {
                    sender.sendMessage("该指令只能由玩家执行！");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("ranking") && args.length == 1) {
            List<String> suggestions = new ArrayList<>();
            suggestions.add("death");
            return suggestions;
        }
        return List.of();
    }

    private void sendDeathRanking(Player player) {
        List<PlayerData> playerDataList = new ArrayList<>();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            int deathCount = onlinePlayer.getStatistic(Statistic.DEATHS);
            playerDataList.add(new PlayerData(onlinePlayer.getUniqueId(), deathCount));
        }

        playerDataList.sort(Comparator.comparingInt(PlayerData::getDeathCount).reversed());

        player.sendMessage(ChatColor.AQUA + "死亡次数排行榜：");
        int rank = 1;
        for (PlayerData data : playerDataList) {
            UUID playerId = data.getPlayerId();
            int deathCount = data.getDeathCount();
            String playerName = Bukkit.getOfflinePlayer(playerId).getName();
            player.sendMessage(ChatColor.YELLOW + "#" + rank + " - " + playerName + ": " + deathCount + " 次死亡");
            rank++;
        }
    }

    private static class PlayerData {
        private final UUID playerId;
        private final int deathCount;

        public PlayerData(UUID playerId, int deathCount) {
            this.playerId = playerId;
            this.deathCount = deathCount;
        }

        public UUID getPlayerId() {
            return playerId;
        }

        public int getDeathCount() {
            return deathCount;
        }
    }
}
