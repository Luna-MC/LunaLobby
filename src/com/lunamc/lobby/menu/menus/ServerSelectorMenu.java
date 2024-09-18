package com.lunamc.lobby.menu.menus;

import com.lunamc.lobby.menu.Menu;
import com.lunamc.lobby.utils.ItemBuilder;
import com.lunamc.lobby.utils.MessageUtil;
import com.lunamc.lobby.utils.ServerUtil;
import org.bukkit.Material;

public final class ServerSelectorMenu extends Menu {

    public ServerSelectorMenu() {
        super(3, "Server Selector");

        set(
                2, 2,
                new ItemBuilder(Material.DIAMOND_BLOCK).name("&3&lCreative").lore("&7Click to join Creative").build(),
                (player) -> ServerUtil.sendTo(player, "creative")
        );

        set(
                4, 2,
                new ItemBuilder(Material.IRON_PICKAXE).name("&3&lSurvival").lore("&7Click to join Survival").build(),
                (player) -> ServerUtil.sendTo(player, "survival")
        );

        set(
                6, 2,
                new ItemBuilder(Material.BARRIER).name("&cComing soon").build(),
                (player) -> MessageUtil.message(player, "&3&l»&c Coming soon")
        );

        set(
                8, 2,
                new ItemBuilder(Material.BARRIER).name("&cComing soon").build(),
                (player) -> MessageUtil.message(player, "&3&l»&c Coming soon")
        );
    }

}
