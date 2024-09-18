package com.lunamc.lobby.listeners.projectile;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public final class ProjectileHitListener implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (projectile.getShooter() instanceof Player player) {
            Location playerLocation = player.getLocation();
            Location targetLocation = projectile.getLocation().clone();

            targetLocation.setYaw(playerLocation.getYaw());
            targetLocation.setPitch(playerLocation.getPitch());

            player.teleport(targetLocation);
        }

        projectile.remove();
    }

}
