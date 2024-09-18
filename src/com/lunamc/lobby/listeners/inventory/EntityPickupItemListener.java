package com.lunamc.lobby.listeners.inventory;

import com.lunamc.lobby.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public final class EntityPickupItemListener implements Listener {

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        event.setCancelled(true);

        if (event.getEntity() instanceof Player player)
            if (User.getUser(player).getBuild())
                event.setCancelled(false);
    }

}
