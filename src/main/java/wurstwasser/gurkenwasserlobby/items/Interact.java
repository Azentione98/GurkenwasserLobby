package wurstwasser.gurkenwasserlobby.items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

public class Interact implements Listener {
    private static final String NAVIGATOR_NAME = " §2⬥ " + "§8[" + "§6Navigator" + "§8]" + " §2⬥ ";

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItem();

        if (item != null && item.hasItemMeta()) {
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null && itemMeta.getDisplayName() != null && itemMeta.getDisplayName().equals(NAVIGATOR_NAME)) {
                p.openInventory(GurkenwasserLobby.CompassInventory);
                e.setCancelled(true);
            }
        }
    }
}