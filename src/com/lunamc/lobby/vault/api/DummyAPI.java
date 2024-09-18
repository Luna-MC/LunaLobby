package com.lunamc.lobby.vault.api;

import com.lunamc.lobby.vault.Vault;
import org.bukkit.entity.Player;

public final class DummyAPI implements Vault {

    @Override
    public String getPrefix(Player player) {
        return player.isOp() ? "&8[&cAdmin&8]&c " : "&8[&7Member&8]&7 ";
    }

    @Override
    public String getSuffix(Player player) { return ""; }

    @Override
    public void setSuffix(Player player, String suffix) {}

}
