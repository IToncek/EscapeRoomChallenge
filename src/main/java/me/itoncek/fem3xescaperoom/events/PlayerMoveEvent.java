package me.itoncek.fem3xescaperoom.events;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static me.itoncek.fem3xescaperoom.Fem3xEscapeRoom.log;
import static me.itoncek.fem3xescaperoom.util.MapBuilder.fill;
import static me.itoncek.fem3xescaperoom.util.util.*;

public class PlayerMoveEvent implements Listener {

    public static Fem3xEscapeRoom plugin;

    public PlayerMoveEvent(Fem3xEscapeRoom pl) {
        plugin = pl;
        log.info("Move events loaded...");
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(org.bukkit.event.player.PlayerMoveEvent event) {
        event.getPlayer().sendActionBar(Component.text(Objects.requireNonNull(event.getPlayer().getTargetBlock(10)).getLocation().getBlockX() + ", " + Objects.requireNonNull(event.getPlayer().getTargetBlock(10)).getLocation().getBlockY() + ", " + Objects.requireNonNull(event.getPlayer().getTargetBlock(10)).getLocation().getBlockZ()));
        switch(Fem3xEscapeRoom.stage) {
            case 0:
                if(event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.NETHERITE_BLOCK)) {
                    if(! event.getPlayer().getInventory().contains(Material.GOLDEN_CARROT)) {
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT));
                        event.getPlayer().sendTitle(" ", ChatColor.GREEN + "Here's a carrot for you :)");
                    }
                } else if(event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.GOLD_BLOCK)) {
                    World world = event.getPlayer().getWorld();
                    fill(new Location(world, 25, -61, 6),new Location(world, 29, -61, 10), Material.BEDROCK);
                    fill(new Location(world, 24, - 60, 6), new Location(world, 24, - 56, 10), Material.BEDROCK);
                    Fem3xEscapeRoom.stage++;
                    setGamemode(GameMode.SURVIVAL);
                    giveItem(new ItemStack(Material.STONE_PICKAXE,1));
                }
                break;
            case 1:
                if(new Location(event.getPlayer().getWorld(), 50, -60, 8).getBlock().getType().equals(Material.BEACON)){
                    Fem3xEscapeRoom.stage++;
                    fill(new Location(event.getPlayer().getWorld(), 53, -60, 6),new Location(event.getTo().getWorld(), 53, -56, 10), Material.BEDROCK);
                }
                if(event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
                    if(! event.getPlayer().getInventory().contains(Material.BEACON)) {
                        event.getPlayer().sendTitle(ChatColor.DARK_RED + "ಠ_ಠ", ChatColor.DARK_RED + "Something is missing here...");
                        sendActionbar(Component.text(ChatColor.GOLD.toString() + ChatColor.BOLD + "Objective: " + ChatColor.RESET + ChatColor.GOLD + "Find a Beacon"));
                    }
                }
                break;
            case 2:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Fem3xEscapeRoom.stage);
        }
    }
}
