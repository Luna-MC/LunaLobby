package com.lunamc.lobby.listeners.login;

import com.lunamc.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public final class PlayerSpawnLocationListener implements Listener {

    private final Location location;

    public PlayerSpawnLocationListener() {
        Configuration config = Lobby.getInstance().getConfig();

        location = new Location(
                Bukkit.getWorld(config.getString("spawn.world")),
                config.getDouble("spawn.x"),
                config.getDouble("spawn.y"),
                config.getDouble("spawn.z"),
                (float) config.getDouble("spawn.yaw"),
                (float) config.getDouble("spawn.pitch")
        );
    }

    @EventHandler
    public void onPlayerSpawnLocation(PlayerSpawnLocationEvent event) {
        event.setSpawnLocation(location);
    }

}
