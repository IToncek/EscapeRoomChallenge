package me.itoncek.fem3xescaperoom.commands;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class yesCommand implements CommandExecutor {
    public static Fem3xEscapeRoom plugin;

    public yesCommand(Fem3xEscapeRoom pl) {
        plugin = pl;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(Fem3xEscapeRoom.stage == 3 ) {
            return true;
        } else {
            sender.sendMessage(ChatColor.DARK_RED +"You can't use that now!");
            return false;
        }
    }
}
