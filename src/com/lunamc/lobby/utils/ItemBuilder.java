package com.lunamc.lobby.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public final class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();

        meta.addItemFlags(ItemFlag.values());
    }

    public ItemBuilder name(String name) {
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        return this;
    }

    public ItemBuilder lore(String... array) {
        return lore(List.of(array));
    }

    public ItemBuilder lore(List<String> list) {
        List<String> clone = new ArrayList<>();

        for (String line : list)
            clone.add(ChatColor.translateAlternateColorCodes('&', line));

        meta.setLore(clone);
        return this;
    }

    public ItemBuilder enchant(Enchantment enchantment, int level) {
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder enchant() {
        return enchant(Enchantment.DURABILITY, 1);
    }

    public ItemBuilder unbreakable() {
        meta.setUnbreakable(true);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

}
