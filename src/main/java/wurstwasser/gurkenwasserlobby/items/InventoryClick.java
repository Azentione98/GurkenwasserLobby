package wurstwasser.gurkenwasserlobby.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import wurstwasser.gurkenwasserlobby.messages.messages;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;



public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Prüfen, ob das Inventar das gewünschte ist
        if (event.getView().getTitle().equals(" §2⬥ §8[§6Navigator§8] §2⬥ ")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || !clickedItem.hasItemMeta()) {
                return;
            }

            ItemMeta meta = clickedItem.getItemMeta();
            if (meta == null || meta.getDisplayName() == null) {
                return;
            }

            String displayName = ChatColor.stripColor(meta.getDisplayName());

            switch (displayName) {
                case "SERVER":
                    BungeeCordHelper.sendPlayerToServer(player, "server2");
                    break;
                case "◌":
                    //player.performCommand("");
                    break;
                case "SOON":
                    player.sendMessage(messages.PREFIX + "Comming Soon!");
                    break;
            }

            player.closeInventory();
        } else {
            // Hier verhindern wir, dass der Kompass im Inventar verschoben wird
            ItemStack currentItem = event.getCurrentItem();
            if (currentItem != null && currentItem.hasItemMeta()) {
                ItemMeta itemMeta = currentItem.getItemMeta();
                if (itemMeta != null && itemMeta.getDisplayName() != null && itemMeta.getDisplayName().equals(" §2⬥ §8[§6Navigator§8] §2⬥ ")) {
                    Player player = (Player) event.getWhoClicked();
                    player.openInventory(GurkenwasserLobby.CompassInventory); // Öffnet das Navigator-Menü
                    event.setCancelled(true);
                }
            }
        }
    }
}




