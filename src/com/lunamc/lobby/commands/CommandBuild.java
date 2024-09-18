package com.lunamc.lobby.commands;

import com.lunamc.lobby.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class CommandBuild implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            User user = User.getUser(player);
            boolean build = !user.getBuild();

            user.setBuild(build);

            if (build)
                user.message("&3»&7 You can now build.");
            else
                user.message("&3»&7 You can no longer build.");
        } else
            sender.sendMessage("Only players can use this command.");

        return true;
    }

}
