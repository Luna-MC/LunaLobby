package com.lunamc.lobby.menu;

import com.lunamc.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Menu implements Listener {

    private static List<Menu> menus = new ArrayList<>();
    private Map<Integer, ClickListener> listeners = new HashMap<>();
    private Inventory inventory;

    public Menu(int row, String name) {
        inventory = Bukkit.createInventory(null, row * 9, ChatColor.translateAlternateColorCodes('&', name));

        Bukkit.getPluginManager().registerEvents(this, Lobby.getInstance());

        menus.add(this);
    }

    public static <T extends Menu> Inventory getInventory(Class<T> clazz) {
        for (Menu menu : menus)
            if (menu.getClass().equals(clazz))
                return menu.inventory;

        return null;
    }

    protected void set(int slot, ItemStack item, ClickListener listener) {
        inventory.setItem(slot, item);
        listeners.put(slot, listener);
    }

    protected void set(int x, int y, ItemStack item, ClickListener listener) {
        set(x - 1 + (y - 1) * 9, item, listener);
    }

    protected void fill(ItemStack item) {
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack slot = inventory.getItem(i);

            if (slot == null || slot.getType() == Material.AIR)
                inventory.setItem(i, item);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (inventory.equals(event.getClickedInventory())) {
            if (event.getWhoClicked() instanceof Player player) {
                ClickListener listener = listeners.get(event.getSlot());

                if (listener != null)
                    listener.onClick(player);

                event.setCancelled(true);
            }
        }
    }

}
