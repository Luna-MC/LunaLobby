package com.lunamc.lobby;

import com.lunamc.lobby.commands.CommandBuild;
import com.lunamc.lobby.gadget.gadgets.CosmeticsGadget;
import com.lunamc.lobby.gadget.gadgets.ServerSelectorGadget;
import com.lunamc.lobby.gadget.gadgets.TagsGadget;
import com.lunamc.lobby.listeners.AsyncPlayerChatListener;
import com.lunamc.lobby.listeners.PlayerInteractListener;
import com.lunamc.lobby.listeners.build.BlockBreakListener;
import com.lunamc.lobby.listeners.build.BlockPlaceListener;
import com.lunamc.lobby.listeners.health.EntityDamageListener;
import com.lunamc.lobby.listeners.health.FoodLevelChangeListener;
import com.lunamc.lobby.listeners.inventory.InventoryClickListener;
import com.lunamc.lobby.listeners.inventory.PlayerSwapHandItemsListener;
import com.lunamc.lobby.listeners.login.PlayerJoinListener;
import com.lunamc.lobby.listeners.login.PlayerQuitListener;
import com.lunamc.lobby.listeners.login.PlayerSpawnLocationListener;
import com.lunamc.lobby.listeners.projectile.ProjectileHitListener;
import com.lunamc.lobby.menu.menus.ServerSelectorMenu;
import com.lunamc.lobby.vault.Vault;
import com.lunamc.lobby.vault.api.DummyAPI;
import com.lunamc.lobby.vault.api.LuckPermsAPI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    private static Lobby instance;
    private static Vault vault;

    public static Lobby getInstance() { return instance; }

    public static Vault getVault() { return vault; }

    @Override
    public void onEnable() {
        PluginManager manager = getServer().getPluginManager();

        instance = this;
        vault = manager.isPluginEnabled("LuckPerms") ? new LuckPermsAPI() : new DummyAPI();

        saveDefaultConfig();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        manager.registerEvents(new BlockBreakListener(), this);
        manager.registerEvents(new BlockPlaceListener(), this);
        manager.registerEvents(new EntityDamageListener(), this);
        manager.registerEvents(new FoodLevelChangeListener(), this);
        manager.registerEvents(new InventoryClickListener(), this);
        manager.registerEvents(new PlayerSwapHandItemsListener(), this);
        manager.registerEvents(new PlayerJoinListener(), this);
        manager.registerEvents(new PlayerQuitListener(), this);
        manager.registerEvents(new PlayerSpawnLocationListener(), this);
        manager.registerEvents(new ProjectileHitListener(), this);
        manager.registerEvents(new AsyncPlayerChatListener(), this);
        manager.registerEvents(new PlayerInteractListener(), this);

        new ServerSelectorMenu();

        new CosmeticsGadget();
        new ServerSelectorGadget();
        new TagsGadget();

        getCommand("build").setExecutor(new CommandBuild());
    }

}
