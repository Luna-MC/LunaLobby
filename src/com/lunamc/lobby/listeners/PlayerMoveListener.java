package com.lunamc.lobby.listeners;

import com.lunamc.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public final class PlayerMoveListener implements Listener {

    private final Location location;
    private final int radius;

    public PlayerMoveListener() {
        Configuration config = Lobby.getInstance().getConfig();

        location = new Location(
                Bukkit.getWorld(config.getString("spawn.world")),
                config.getDouble("spawn.x"),
                config.getDouble("spawn.y"),
                config.getDouble("spawn.z"),
                (float) config.getDouble("spawn.yaw"),
                (float) config.getDouble("spawn.pitch")
        );
        radius = config.getInt("spawn.radius");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location to = event.getTo();
        Location from = event.getFrom();

        if (to.distance(location) > radius)
            event.setCancelled(true);

        if (to.getY() < 0 || from.distance(location) > radius)
            event.getPlayer().teleport(location);
    }

}
