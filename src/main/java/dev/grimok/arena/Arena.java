package dev.grimok.arena;

import dev.grimok.GameState;
import dev.grimok.config.ConfigManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Arena {

    private int id;
    private Location spawn;
    private List<UUID> players;

    private GameState state;

    public Arena(int id, Location spawn){
        this.id = id;
        this.spawn = spawn;

        this.state = GameState.WAITING;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player.getUniqueId());
        player.teleport(spawn);
    }

    public void removePlayer(Player player){
        players.remove(player.getUniqueId());
        player.teleport(ConfigManager.getLobby());
    }

    public List<UUID> getPlayers(){
        return players;
    }

    public void setPlayers(List<UUID> uuids){
        this.players = uuids;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
