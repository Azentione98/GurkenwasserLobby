package wurstwasser.gurkenwasserlobby.listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import wurstwasser.gurkenwasserlobby.messages.messages;

public class Join implements Listener

{
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        if (!e.getPlayer().hasPermission("admin.join"))
        {
            e.setJoinMessage("");
        } else {
            e.setJoinMessage(messages.PREFIX + e.getPlayer().getName() + " ist nun da!");
        }
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().setAllowFlight(true);
    }
}
