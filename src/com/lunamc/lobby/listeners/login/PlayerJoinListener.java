package com.lunamc.lobby.listeners.login;

import com.lunamc.lobby.Lobby;
import com.lunamc.lobby.gadget.Gadget;
import com.lunamc.lobby.vault.Vault;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

public final class PlayerJoinListener implements Listener {

    private static final Vault vault = Lobby.getVault();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String displayName = ChatColor.translateAlternateColorCodes('&',
                vault.getPrefix(player) + player.getName() + vault.getSuffix(player)
        );

        player.setAllowFlight(true);
        player.setDisplayName(displayName);
        player.setPlayerListName(displayName);

        PlayerInventory inventory = player.getInventory();
        inventory.setHeldItemSlot(4);

        for (Gadget gadget : Gadget.getGadgets())
            inventory.setItem(gadget.getSlot(), gadget.getItem());

        player.updateInventory();
    }

}
