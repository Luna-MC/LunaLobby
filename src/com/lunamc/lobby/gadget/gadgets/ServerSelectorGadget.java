package com.lunamc.lobby.gadget.gadgets;

import com.lunamc.lobby.gadget.Gadget;
import com.lunamc.lobby.menu.Menu;
import com.lunamc.lobby.menu.menus.ServerSelectorMenu;
import com.lunamc.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class ServerSelectorGadget extends Gadget {

    public ServerSelectorGadget() {
        super(4, new ItemBuilder(Material.COMPASS).name("&aServer Selector&7 (Click)").build());
    }

    protected void onClick(Player player) {
        player.openInventory(Menu.getInventory(ServerSelectorMenu.class));
    }

}
