package me.itoncek.fem3xescaperoom.util;

import com.destroystokyo.paper.Title;
import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;

import static me.itoncek.fem3xescaperoom.Fem3xEscapeRoom.log;
import static me.itoncek.fem3xescaperoom.util.util.sendTitle;

public class DoorManager {
    public static void openDoor() {
        log.info("Opening door!");
        switch(Fem3xEscapeRoom.stage) {
            case 0:
                MapBuilder.fill(new Location(Bukkit.getWorld("world"), 24, - 60, 6), new Location(Bukkit.getWorld("world"), 24, - 56, 10), Material.AIR);
                sendTitle(Title.builder()
                        .title(ChatColor.GREEN + "Stage 1 ☑")
                        .subtitle(ChatColor.GREEN + "Continue to the next room")
                        .build());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Fem3xEscapeRoom.stage);
        }
    }
}