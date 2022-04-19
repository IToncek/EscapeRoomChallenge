package me.itoncek.fem3xescaperoom.events;

import me.itoncek.fem3xescaperoom.Fem3xEscapeRoom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import static me.itoncek.fem3xescaperoom.util.DoorManager.openDoor;
import static me.itoncek.fem3xescaperoom.Fem3xEscapeRoom.log;

public class PlayerEatEvent implements Listener {

    public static Fem3xEscapeRoom plugin;

    public PlayerEatEvent(Fem3xEscapeRoom pl) {
        plugin=pl;
        log.info("Eat events loaded...");
    }

    @EventHandler
    public void onPlayerInteract(PlayerItemConsumeEvent event) {
        log.info("Eated a carrot!");
        switch(Fem3xEscapeRoom.stage){
            case 0:
                openDoor();
                event.getPlayer().setSaturation(20f);
                event.getPlayer().setFoodLevel(20);
                break;
            case 1:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Fem3xEscapeRoom.stage);
        }
    }
}
