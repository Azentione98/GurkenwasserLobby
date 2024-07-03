package wurstwasser.gurkenwasserlobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import wurstwasser.gurkenwasserlobby.messages.messages;

public class LobbyManager implements CommandExecutor, Listener {

    private final JavaPlugin plugin;
    private Location lobbyLocation;

    public LobbyManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("setlobby").setExecutor(this);
        this.plugin.getCommand("lobby").setExecutor(this);
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
        loadLobbyLocation();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (lobbyLocation != null) {
            player.teleport(lobbyLocation);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(messages.PREFIX+ "This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("setlobby")) {
            if (!player.hasPermission("gurkenwasserlobby.setlobby")) {
                player.sendMessage("You don't have permission to use this command.");
                return true;
            }
            setLobbyLocation(player.getLocation());
            player.sendMessage(messages.PREFIX+ "Lobby location set!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("lobby")) {
            if (lobbyLocation == null) {
                player.sendMessage(messages.PREFIX+"Lobby location is not set.");
                return true;
            }
            player.teleport(lobbyLocation);
            return true;
        }

        return false;
    }

    private void setLobbyLocation(Location location) {
        this.lobbyLocation = location;
        saveLobbyLocation();
    }

    private void saveLobbyLocation() {
        FileConfiguration config = plugin.getConfig();
        config.set("lobby.world", lobbyLocation.getWorld().getName());
        config.set("lobby.x", lobbyLocation.getX());
        config.set("lobby.y", lobbyLocation.getY());
        config.set("lobby.z", lobbyLocation.getZ());
        config.set("lobby.yaw", lobbyLocation.getYaw());
        config.set("lobby.pitch", lobbyLocation.getPitch());
        plugin.saveConfig();
    }

    private void loadLobbyLocation() {
        FileConfiguration config = plugin.getConfig();
        if (config.contains("lobby.world")) {
            String worldName = config.getString("lobby.world");
            double x = config.getDouble("lobby.x");
            double y = config.getDouble("lobby.y");
            double z = config.getDouble("lobby.z");
            float yaw = (float) config.getDouble("lobby.yaw");
            float pitch = (float) config.getDouble("lobby.pitch");
            lobbyLocation = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
        }
    }
}
