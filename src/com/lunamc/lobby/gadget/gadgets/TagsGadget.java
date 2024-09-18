package com.lunamc.lobby.gadget.gadgets;

import com.lunamc.lobby.gadget.Gadget;
import com.lunamc.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class TagsGadget extends Gadget {

    public TagsGadget() {
        super(7, new ItemBuilder(Material.NAME_TAG).name("&aTags&7 (Click)").build());
    }

    protected void onClick(Player player) {
        player.sendMessage("//todo: tags gui");
    }

}
