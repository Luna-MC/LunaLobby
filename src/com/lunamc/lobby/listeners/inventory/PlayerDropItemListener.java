package com.lunamc.lobby.listeners.inventory;

import com.lunamc.lobby.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public final class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (!User.getUser(event.getPlayer()).getBuild())
            event.setCancelled(true);
    }

}
