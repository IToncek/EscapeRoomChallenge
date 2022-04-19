package me.itoncek.fem3xescaperoom.commands;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import me.itoncek.fem3xescaperoom.util.MapBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static me.itoncek.fem3xescaperoom.Fem3xEscapeRoom.log;
import static me.itoncek.fem3xescaperoom.util.util.sendActionbar;

public class StartCommand implements CommandExecutor {
    public static Fem3xEscapeRoom plugin;

    public StartCommand(Fem3xEscapeRoom pl) {
        plugin = pl;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        MapBuilder.fill(new Location(Bukkit.getWorld("world"), 8, - 60, 8), new Location(Bukkit.getWorld("world"), 8, - 59, 8), Material.AIR);
        for(Player p : Bukkit.getOnlinePlayers()) {
            //p.teleportAsync(new Location(Bukkit.getWorld("world"), 8.5, - 60, 8.5));
        }
        //sendTitle(Title.builder()
                //.title(ChatColor.GOLD + "Building the map, please wait")
                //.build());
        Objects.requireNonNull(Bukkit.getWorld("world")).setDifficulty(Difficulty.PEACEFUL);
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.DO_MOB_LOOT, false);
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.MOB_GRIEFING, false);
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(GameRule.MAX_ENTITY_CRAMMING, - 1);
        Objects.requireNonNull(Bukkit.getWorld("world")).setDifficulty(Difficulty.HARD);

        MapBuilder.fill(new Location(Bukkit.getWorld("world"), 8, - 60, 8), new Location(Bukkit.getWorld("world"), 8, - 59, 8), Material.AIR);
        for(Player p : Bukkit.getOnlinePlayers()) {
            //p.teleportAsync(new Location(Bukkit.getWorld("world"), 8.5, - 60, 8.5));
        }

        log.info("Loading map...");
        MapBuilder.buildMap(plugin, Bukkit.getWorld("world"));
        log.info("Map loaded...");

        MapBuilder.fill(new Location(Bukkit.getWorld("world"), 8, - 60, 8), new Location(Bukkit.getWorld("world"), 8, - 59, 8), Material.AIR);
        for(Player p : Bukkit.getOnlinePlayers()) {
            //p.teleportAsync(new Location(Bukkit.getWorld("world"), 8.5, - 60, 8.5));
            //p.setGameMode(GameMode.ADVENTURE);
        }
        int i=0;
        for(Entity e : Bukkit.getWorld("world").getEntities()) {
            if (!(e instanceof Player)){
                e.remove();
                i++;
                sendActionbar(Component.text(ChatColor.DARK_RED + "Removed " + i + " entities."));
            }
        }
        sendActionbar(Component.text(ChatColor.GREEN + "Map succesfully loaded"));
        return true;
    }
}
