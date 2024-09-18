package com.lunamc.lobby;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class User {

    private static Map<Player, User> users = new HashMap<>();
    private Player player;
    private boolean build;

    private User(Player player) {
        this.player = player;
        this.build = false;
    }

    public static Collection<User> getUsers() { return users.values(); }

    public static User getUser(Player player) { return users.computeIfAbsent(player, User::new); }

    public static void remove(Player player) { users.remove(player); }

    public void message(String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void displayHeaderFooter() {
        int ping = player.spigot().getPing();

        player.setPlayerListHeaderFooter(
                ChatColor.translateAlternateColorCodes('&',
                        "&3&l\nLUNAMC" +
                                "\n&7Ping: &3" + ping + "ms\n"
                ),
                ChatColor.translateAlternateColorCodes('&',
                        "&7\nVisit our store at &3/store" +
                                "\n&7Join our discord at &3/discord" +
                                "\n\n&3play.luna-mc.com\n"
                )
        );
    }

    public void displayActionbar() {
        player.sendActionBar(
                ChatColor.translateAlternateColorCodes('&', "&3&lplay.luna-mc.com")
        );
    }

    public boolean getBuild() { return build; }

    public void setBuild(boolean build) { this.build = build; }

}
