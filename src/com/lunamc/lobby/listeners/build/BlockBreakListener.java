package com.lunamc.lobby.listeners.build;

import com.lunamc.lobby.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!User.getUser(event.getPlayer()).getBuild())
            event.setCancelled(true);
    }

}
