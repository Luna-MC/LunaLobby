package com.lunamc.lobby.gadget.gadgets;

import com.lunamc.lobby.gadget.Gadget;
import com.lunamc.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class CosmeticsGadget extends Gadget {

    public CosmeticsGadget() {
        super(8, new ItemBuilder(Material.CHEST).name("&aCosmetics&7 (Click)").build());
    }

    protected void onClick(Player player) {
        player.sendMessage("//todo: cosmetics gui");
    }

}
