package com.lunamc.lobby.listeners.build;

import com.lunamc.lobby.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlaceListener(BlockPlaceEvent event) {
        if (!User.getUser(event.getPlayer()).getBuild())
            event.setCancelled(true);
    }

}
