package com.lunamc.lobby.listeners.inventory;

import com.lunamc.lobby.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player player)
            if (!User.getUser(player).getBuild())
                event.setCancelled(true);
    }

}
