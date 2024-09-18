package com.lunamc.lobby.vault.api;

import com.lunamc.lobby.vault.Vault;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.entity.Player;

public final class LuckPermsAPI implements Vault {

    private static final UserManager manager = LuckPermsProvider.get().getUserManager();

    private User getUser(Player player) {
        return manager.loadUser(player.getUniqueId()).join();
    }

    private CachedMetaData getMetadata(Player player) {
        return getUser(player).getCachedData().getMetaData();
    }

    @Override
    public String getPrefix(Player player) {
        String prefix = getMetadata(player).getPrefix();

        return prefix == null ? "" : prefix;
    }

    @Override
    public String getSuffix(Player player) {
        String suffix = getMetadata(player).getSuffix();

        return suffix == null ? "" : suffix;
    }

}
