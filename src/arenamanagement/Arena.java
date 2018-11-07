package arenamanagement;

import me.signifies.kPVP.kPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Signifies on 10/10/2018 - 21:01.
 */
public class Arena {

    private String name;
    private Location location,locA,locB;
    private Set<UUID> players;

    public Arena(String name, Location location){
        this.name = name;
        this.location = location;
        this.players  = new HashSet<>();
    }

    public Arena(String name, Location lobby, Location A, Location B){
        this.name = name;
        this.location = lobby;
        this.locA = A;
        this.locB = B;
        this.players = new HashSet<>();
    }

    public String getName(){
        return name;
    }
    public Location getLoc(){
        return location;
    }

    public Location getLocA() {
        return locA;
    }

    public Location getLocB(){
        return locB;
    }

    public Set<UUID> getPlayers(){
        return players;
    }


}
