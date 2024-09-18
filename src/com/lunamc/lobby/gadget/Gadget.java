package com.lunamc.lobby.gadget;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class Gadget {

    private static List<Gadget> gadgets = new ArrayList<>();
    private ItemStack item;
    private int slot;

    public Gadget(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;

        gadgets.add(this);
    }

    public static List<Gadget> getGadgets() { return gadgets; }

    public static void call(Player player, ItemStack item) {
        for (Gadget gadget : gadgets) {
            if (gadget.item.isSimilar(item)) {
                gadget.onClick(player);
                return;
            }
        }
    }

    public ItemStack getItem() { return item; }

    public int getSlot() { return slot; }

    protected abstract void onClick(Player player);

}
