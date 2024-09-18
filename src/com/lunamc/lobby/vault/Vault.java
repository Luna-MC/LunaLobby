package com.lunamc.lobby.vault;

import org.bukkit.entity.Player;

public interface Vault {

    String getPrefix(Player player);

    String getSuffix(Player player);

    void setSuffix(Player player, String suffix);

}
