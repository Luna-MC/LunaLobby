package com.lunamc.lobby.listeners.inventory;

import com.lunamc.lobby.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public final class PlayerSwapHandItemsListener implements Listener {

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        if (!User.getUser(event.getPlayer()).getBuild())
            event.setCancelled(true);
    }

}
