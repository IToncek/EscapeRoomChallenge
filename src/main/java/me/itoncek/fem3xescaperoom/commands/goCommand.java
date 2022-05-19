package me.itoncek.fem3xescaperoom.commands;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.itoncek.fem3xescaperoom.util.MapBuilder.stage3;

public class goCommand implements CommandExecutor {
    public static Fem3xEscapeRoom plugin;

    public goCommand(Fem3xEscapeRoom pl) {
        plugin = pl;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        assert sender instanceof Player;
        if(Fem3xEscapeRoom.stage == 2 ) {
            stage3(((Player) sender).getWorld());
            return true;
        } else {
            sender.sendMessage(ChatColor.DARK_RED +"You can't use that now! Current stage is: " + Fem3xEscapeRoom.stage);
            return false;
        }
    }
}
