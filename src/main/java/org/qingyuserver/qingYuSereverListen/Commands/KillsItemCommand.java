package org.qingyuserver.qingYuSereverListen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.jetbrains.annotations.NotNull;

public class KillsItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("killsitem")) {
            int count = 0;
            for (org.bukkit.World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getEntities()) {
                    if (entity instanceof Item) {
                        entity.remove();
                        count++;
                    }
                }
            }

            sender.sendMessage("§a成功清除 " + count + " 个掉落物！");
            return true;
        }
        return false;
    }
}
