package wurstwasser.gurkenwasserlobby.startup;

import org.bukkit.Bukkit;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import wurstwasser.gurkenwasserlobby.commands.*;
import wurstwasser.gurkenwasserlobby.items.*;
import wurstwasser.gurkenwasserlobby.listener.*;


public final class GurkenwasserLobby extends JavaPlugin {
    public static String worldName = "world";
    public static Inventory CompassInventory = Bukkit.createInventory(null, InventoryType.CHEST, " §2⬥ " + "§8[" + "§6Navigator" + "§8]" + " §2⬥ ");
    private static GurkenwasserLobby instance;
    private LobbyManager lobbyManager;

    @Override
    public void onEnable() {

        instance = this;
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getLogger().info("GurkenwasserLobby Plugin wird aktiviert");

        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new noDMG(), this);
        Bukkit.getPluginManager().registerEvents(new noRain(), this);
        Bukkit.getPluginManager().registerEvents(new noHunger(), this);
        Bukkit.getPluginManager().registerEvents(new DropListener(), this);
        Bukkit.getPluginManager().registerEvents(new Interact(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
        Funktionen.navigatorFill();

        this.lobbyManager = new LobbyManager(this);

        // Welt laden
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            getLogger().info("Welt " + worldName + " ist nicht geladen, versuche zu laden...");
            world = Bukkit.createWorld(new org.bukkit.WorldCreator(worldName));
        }

        if (world != null) {
            // PvP deaktivieren und Zeit setzen
            world.setPVP(false);
            world.setTime(6000);

            // Gamerules setzen
            world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
            world.setGameRule(GameRule.RANDOM_TICK_SPEED, 0);
            world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            world.setGameRule(GameRule.DO_FIRE_TICK, false);
            world.setGameRule(GameRule.MOB_GRIEFING, false);

            getLogger().info("Einstellungen für die Welt " + worldName + " wurden erfolgreich gesetzt.");
        } else {
            getLogger().severe("Welt " + worldName + " konnte nicht gefunden oder erstellt werden.");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("GurkenwasserLobby Plugin wird deaktiviert");
    }

    public static GurkenwasserLobby getInstance() {
        return instance;
    }
}















