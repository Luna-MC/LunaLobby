package com.lunamc.lobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public final class PlayerStatisticIncrementListener implements Listener {

    @EventHandler
    public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {
        event.setCancelled(true);
    }

}
