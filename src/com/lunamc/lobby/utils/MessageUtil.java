package com.lunamc.lobby.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class MessageUtil {

    public static void message(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
