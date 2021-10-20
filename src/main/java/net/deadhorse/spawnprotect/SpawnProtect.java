package net.deadhorse.spawnprotect;

import net.deadhorse.spawnprotect.Events.PlayerHitEvent;
import net.deadhorse.spawnprotect.Events.SpawnResetListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnProtect extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new SpawnResetListener(this),this);
        getServer().getPluginManager().registerEvents(new PlayerHitEvent(this),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
