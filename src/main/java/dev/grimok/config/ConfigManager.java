package dev.grimok.config;

import dev.grimok.core.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class ConfigManager {

    private static FileConfiguration configuration;

    public static void setupConfig(SkyWars skyWars){
        ConfigManager.configuration = skyWars.getConfig();
        skyWars.saveDefaultConfig();
    }

    public static int getMinPlayers(){
        return configuration.getInt("min-players");
    }

    public static int getCountdown(){
        return configuration.getInt("countdown");
    }

    public static Location getLobby(){
        return new Location(Bukkit.getWorld(Objects.requireNonNull(configuration.getString("lobby.world"))),
                configuration.getDouble("lobby.x"),
                configuration.getDouble("lobby.y"),
                configuration.getDouble("lobby.z"),
                (float) configuration.getDouble("lobby.pitch"),
                (float) configuration.getDouble("lobby.yaw"));
    }

}
