package dev.grimok.core;

import dev.grimok.arena.ArenaManager;
import dev.grimok.config.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.util.logging.Level;

public final class SkyWars extends JavaPlugin {

    private ArenaManager arenaManager;
    @Override
    public void onEnable() {

        getLogger().log(Level.INFO, ChatColor.GOLD + "This is the lite version of SnowSkyWars. The project is still on development.");
        ConfigManager.setupConfig(this);

        arenaManager = new ArenaManager(this);
    }

    public ArenaManager getArenaManager() {return arenaManager;}

}
