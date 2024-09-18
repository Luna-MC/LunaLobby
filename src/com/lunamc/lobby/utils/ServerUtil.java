package com.lunamc.lobby.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.lunamc.lobby.Lobby;
import org.bukkit.entity.Player;

public final class ServerUtil {

    public static void sendTo(Player player, String serverName) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(serverName);

        player.sendPluginMessage(Lobby.getInstance(), "BungeeCord", output.toByteArray());
    }

}
