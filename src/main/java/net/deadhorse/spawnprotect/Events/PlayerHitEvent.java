package net.deadhorse.spawnprotect.Events;

import net.deadhorse.spawnprotect.SpawnProtect;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerHitEvent implements Listener {
    private SpawnProtect plugin;
    public PlayerHitEvent(SpawnProtect plugin) {
        this.plugin=plugin;
    }

    @EventHandler
    public void onAttack(EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            for (String worldName : plugin.getConfig().getStringList("list")) {
                if (e.getEntity().getWorld().getName().equalsIgnoreCase(worldName)) {
                    Player player = (Player) e.getEntity();

                    e.setDamage(0);


                }
            }
        }
    }
  @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            for (String worldName : plugin.getConfig().getStringList("list")) {
                if (e.getEntity().getWorld().getName().equalsIgnoreCase(worldName)) {
                    Player player = (Player) e.getEntity();
                    World world = player.getWorld();
                    world.spawnParticle(Particle.ASH, player.getLocation().add(0, 1, 0), 100, .5, .5, .5);

                }
            }
        }
    }


}
