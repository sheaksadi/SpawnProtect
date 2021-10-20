package net.deadhorse.spawnprotect.Events;

import net.deadhorse.spawnprotect.SpawnProtect;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SpawnResetListener implements Listener {

    private SpawnProtect plugin;

    public SpawnResetListener(SpawnProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player player= e.getPlayer();
        //this looks better
        if (player.getLocation().getBlockY()<0 || isFar(player)){

            World world = e.getPlayer().getWorld();
            for (String worldName :plugin.getConfig().getStringList("list")){
                if (world.getName().equalsIgnoreCase(worldName)){

                    player.teleport(world.getSpawnLocation());

                }
            }


    }


    }

    private boolean isFar (Player player){
        return (player.getLocation().getBlockX()<-100||player.getLocation().getBlockX()>260|| player.getLocation().getBlockZ()<-100||player.getLocation().getBlockZ()>100)&& !player.hasPermission("spawnprotect.bypass");
    }



}
