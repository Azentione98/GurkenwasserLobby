package wurstwasser.gurkenwasserlobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

public class noHunger implements Listener
{
    @EventHandler
    public void onHunger(FoodLevelChangeEvent e){
        if (e.getEntity() instanceof Player && e.getEntity().getWorld().getName().equals(GurkenwasserLobby.worldName)) {
            e.setCancelled(true);
            ((Player)e.getEntity()).setFoodLevel(20);
        }
    }

}
