package me.itoncek.fem3xescaperoom;

import me.itoncek.fem3xescaperoom.commands.StartCommand;
import me.itoncek.fem3xescaperoom.commands.yesCommand;
import me.itoncek.fem3xescaperoom.events.PlayerClickEvent;
import me.itoncek.fem3xescaperoom.events.PlayerEatEvent;
import me.itoncek.fem3xescaperoom.events.PlayerMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;

public final class Fem3xEscapeRoom extends JavaPlugin {
    public static Logger log;
    public static FileConfiguration config;
    public static HashMap<Integer, Location> stages;
    public static int stage;
    @Override
    public void onEnable() {
        log = getBukkitLogger();
        log.info("Escape room driver loading...");
        log.info("Saving config...");
        saveDefaultConfig();
        log.info("Config saved...");
        log.info("Loading config...");
        config = getConfig();
        log.info("Config loaded...");
        log.info("Loading last stage...");
        stage = config.getInt("stage");
        stages = importHashMap(new HashMap<>());
        log.info("Last stage loaded...");
        log.info("Registering events...");
        registerEvents(this);
        log.info("Events registered...");
        log.info("Registering commands...");
        registerCommands(this);
        log.info("Commands registered...");
        log.info("Server is ready");
    }


    public static Logger getBukkitLogger(){
        return Bukkit.getLogger();
    }

    public static HashMap<Integer, Location> importHashMap(HashMap<Integer, Location> map){
        map.put(0, new Location(Bukkit.getWorld("world"), 8.5, - 60, 8.5));
        map.put(1, new Location(Bukkit.getWorld("world"), 26.5, - 60, 8.5, -90, 0));
        return map;
    }

    public static void registerEvents(Fem3xEscapeRoom plugin) {
        log.info("Registering click events...");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerClickEvent(plugin), plugin);
        log.info("Registering eat events...");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerEatEvent(plugin), plugin);
        log.info("Registering move events...");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerMoveEvent(plugin), plugin);
    }

    public static void registerCommands(Fem3xEscapeRoom plugin) {
        log.info("Registering start command...");
        Objects.requireNonNull(plugin.getCommand("start")).setExecutor(new StartCommand(plugin));
        log.info("Registering yes command...");
        Objects.requireNonNull(plugin.getCommand("yes")).setExecutor(new yesCommand(plugin));
    }

    @Override
    public void onDisable() {
        config.set("stage", stage);
        log.info("Escape room driver shutting down...");
    }
}