package me.itoncek.fem3xescaperoom.events;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static me.itoncek.fem3xescaperoom.Fem3xEscapeRoom.log;

public class PlayerClickEvent implements Listener {

    public static Fem3xEscapeRoom plugin;

    public PlayerClickEvent(Fem3xEscapeRoom pl) {
        plugin=pl;
        log.info("Click events loaded...");
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        switch(Fem3xEscapeRoom.stage){
            case 0:
                if(event.getItem() != null) {
                    if(event.getItem().getType().equals(Material.GOLDEN_CARROT)) {
                        event.getPlayer().setSaturation(0f);
                        event.getPlayer().setFoodLevel(0);
                    }
                }
                break;
            case 1:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Fem3xEscapeRoom.stage);
        }
    }
}
