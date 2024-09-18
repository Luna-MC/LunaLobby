package com.lunamc.lobby.listeners;

import com.lunamc.lobby.Lobby;
import com.lunamc.lobby.vault.Vault;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public final class AsyncPlayerChatListener implements Listener {

    private static final Vault vault = Lobby.getVault();

    @EventHandler
    public void AsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String displayName = ChatColor.translateAlternateColorCodes('&',
                vault.getPrefix(player) + player.getName() + vault.getSuffix(player)
        );

        player.setDisplayName(displayName);
        player.setPlayerListName(displayName);

        event.setFormat("%s§8 » §f%s");
    }

}
