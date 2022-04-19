package me.itoncek.fem3xescaperoom.util;

import com.destroystokyo.paper.Title;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class util {
    public static void sendTitle(Title title) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendTitle(title);
        }
    }

    public static void sendMessage(String title) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(title);
        }
    }

    public static void playsound(Sound sound) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), sound, 999f, 1f);
        }
    }

    public static void sendActionbar(Component message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendActionBar(message);
        }
    }

    public static void teleport(Location loc) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.teleportAsync(loc);
        }
    }

    public static void setGamemode(GameMode gamemode) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.setGameMode(gamemode);
        }
    }

    public static void giveItem(ItemStack stack) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.getInventory().addItem(stack);
        }
    }
}
