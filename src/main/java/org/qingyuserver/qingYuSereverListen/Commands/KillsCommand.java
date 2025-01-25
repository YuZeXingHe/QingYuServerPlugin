package org.qingyuserver.qingYuSereverListen.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KillsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("kills")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                player.setHealth(0);
                player.sendMessage("§a哎呀，你行不行啊细狗，怎么还想不开自杀了呢？§r");
                return true;
            }
            else {
                commandSender.sendMessage("该指令只能由玩家使用！");
                return true;
            }
        }
        return false;
    }
}
