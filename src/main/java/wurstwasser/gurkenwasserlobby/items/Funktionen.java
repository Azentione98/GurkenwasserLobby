package wurstwasser.gurkenwasserlobby.items;

import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

public class Funktionen
{
    public static void navigatorFill() {
        ItemStack Glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta GlassMeta = Glass.getItemMeta();
        GlassMeta.setDisplayName("§r§k◌");
        Glass.setItemMeta(GlassMeta);

        ItemStack Server = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta ServerMeta = Server.getItemMeta();
        ServerMeta.setDisplayName("§r§l§6SERVER");
        Server.setItemMeta(ServerMeta);

        ItemStack Soon = new ItemStack(Material.RED_WOOL);
        ItemMeta SoonMeta = Soon.getItemMeta();
        SoonMeta.setDisplayName("§r§l§cSOON");
        Soon.setItemMeta(SoonMeta);

        GurkenwasserLobby.CompassInventory.setItem(0, Glass);
        GurkenwasserLobby.CompassInventory.setItem(1, Glass);
        GurkenwasserLobby.CompassInventory.setItem(2, Glass);
        GurkenwasserLobby.CompassInventory.setItem(3, Glass);
        GurkenwasserLobby.CompassInventory.setItem(4, Glass);
        GurkenwasserLobby.CompassInventory.setItem(5, Glass);
        GurkenwasserLobby.CompassInventory.setItem(6, Glass);
        GurkenwasserLobby.CompassInventory.setItem(7, Glass);
        GurkenwasserLobby.CompassInventory.setItem(8, Glass);

        GurkenwasserLobby.CompassInventory.setItem(9, Glass);
        GurkenwasserLobby.CompassInventory.setItem(10, Soon);
        GurkenwasserLobby.CompassInventory.setItem(11, Glass);
        GurkenwasserLobby.CompassInventory.setItem(12, Glass);
        GurkenwasserLobby.CompassInventory.setItem(13, Server);
        GurkenwasserLobby.CompassInventory.setItem(14, Glass);
        GurkenwasserLobby.CompassInventory.setItem(15, Glass);
        GurkenwasserLobby.CompassInventory.setItem(16, Soon);
        GurkenwasserLobby.CompassInventory.setItem(17, Glass);

        GurkenwasserLobby.CompassInventory.setItem(18, Glass);
        GurkenwasserLobby.CompassInventory.setItem(19, Glass);
        GurkenwasserLobby.CompassInventory.setItem(20, Glass);
        GurkenwasserLobby.CompassInventory.setItem(21, Glass);
        GurkenwasserLobby.CompassInventory.setItem(22, Glass);
        GurkenwasserLobby.CompassInventory.setItem(23, Glass);
        GurkenwasserLobby.CompassInventory.setItem(24, Glass);
        GurkenwasserLobby.CompassInventory.setItem(25, Glass);
        GurkenwasserLobby.CompassInventory.setItem(26, Glass);


    }
}
