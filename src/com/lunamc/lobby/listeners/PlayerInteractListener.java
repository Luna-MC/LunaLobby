package com.lunamc.lobby.listeners;

import com.lunamc.lobby.User;
import com.lunamc.lobby.gadget.Gadget;
import com.lunamc.lobby.utils.LazyUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!User.getUser(player).getBuild())
            event.setCancelled(true);

        if (LazyUtil.anyEquals(event.getAction(), Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK))
            Gadget.call(player, event.getItem());
    }

}
