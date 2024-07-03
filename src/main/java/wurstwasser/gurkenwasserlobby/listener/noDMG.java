package wurstwasser.gurkenwasserlobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

public class noDMG implements Listener {

    @EventHandler(priority = org.bukkit.event.EventPriority.HIGH)
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && e.getEntity().getWorld().getName().equals(GurkenwasserLobby.worldName)) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setCancelled(true);
            }
        }
    }
}
