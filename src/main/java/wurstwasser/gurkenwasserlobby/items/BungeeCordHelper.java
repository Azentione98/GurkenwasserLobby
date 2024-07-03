package wurstwasser.gurkenwasserlobby.items;

import org.bukkit.entity.Player;
import wurstwasser.gurkenwasserlobby.startup.GurkenwasserLobby;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BungeeCordHelper {
    public static void sendPlayerToServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.sendPluginMessage(GurkenwasserLobby.getInstance(), "BungeeCord", byteArrayOutputStream.toByteArray());
    }
}

