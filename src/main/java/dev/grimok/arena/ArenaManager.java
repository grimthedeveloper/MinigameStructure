package dev.grimok.arena;

import dev.grimok.core.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/*
    We will generate every arenas in this class
 */
public class ArenaManager {

    private static List<Arena> arenas = new ArrayList<>();

    public ArenaManager(SkyWars skyWars){
        FileConfiguration fileConfiguration = skyWars.getConfig();
        for (String a : fileConfiguration.getConfigurationSection("arenas").getKeys(false)){
            arenas.add(new Arena(Integer.parseInt(a),new Location(Bukkit.getWorld(fileConfiguration.getString(a+".world")),
                    fileConfiguration.getDouble(a+".x"),
                    fileConfiguration.getDouble(a+".y"),
                    fileConfiguration.getDouble(a+".z"),
                    (float) fileConfiguration.getDouble(a+".pitch"),
                    (float) fileConfiguration.getDouble(a+".yaw"))));
        }

    }

    public List<Arena> getArenas(){
        return arenas;
    }

    public void reloadArenas(SkyWars skyWars){

        arenas.clear();

        FileConfiguration fileConfiguration = skyWars.getConfig();
        for (String a : fileConfiguration.getConfigurationSection("arenas").getKeys(false)){
            arenas.add(new Arena(Integer.parseInt(a),new Location(Bukkit.getWorld(fileConfiguration.getString(a+".world")),
                    fileConfiguration.getDouble(a+".x"),
                    fileConfiguration.getDouble(a+".y"),
                    fileConfiguration.getDouble(a+".z"),
                    (float) fileConfiguration.getDouble(a+".pitch"),
                    (float) fileConfiguration.getDouble(a+".yaw"))));
        }
    }

    public Arena getArena(Player player){
        for (Arena arena : arenas){
            if (arena.getPlayers().contains(player.getUniqueId())){
                return arena;
            }
        }
        return null;
    }

    public Arena getArena(int id){
        for (Arena arena : arenas){
            if (arena.getId() == id){
                return arena;
            }
        }
        return null;
    }




}
