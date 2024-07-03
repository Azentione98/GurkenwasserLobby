package wurstwasser.gurkenwasserlobby.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

public class JoinEvent implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getName().equals(GurkenwasserLobby.worldName)) {
            ItemStack Compass = new ItemStack(Material.COMPASS);
            ItemMeta CompassMeta = Compass.getItemMeta();
            CompassMeta.setDisplayName(" §2⬥ " + "§8[" + "§6Navigator" + "§8]" + " §2⬥ ");
            Compass.setItemMeta(CompassMeta);
            p.getInventory().setItem(4, Compass);
        }
    }
}

