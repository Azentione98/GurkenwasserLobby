package wurstwasser.gurkenwasserlobby.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

public class DropListener implements Listener
{
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (e.getPlayer().getWorld().getName().equals(GurkenwasserLobby.worldName)) {

            ItemStack item = e.getItemDrop().getItemStack();

            if (item.hasItemMeta()) {
                if (item.getItemMeta().getDisplayName().equals(" §2⬥ " + "§8[" + "§6Navigator" + "§8]" + " §2⬥ ")) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
