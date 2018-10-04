package files;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.UUID;

public class ArenaManager {

    private int id;
    private boolean physicalArenaModification;
    private boolean gameInitiated;
    private ArrayList<UUID> inGame;
    private Location spawnLoc1;
    private Location spawnLoc2;

    public ArenaManager(int id,boolean modifyArena, boolean gameStart, Location a, Location b){
        this.id = id;
        physicalArenaModification = modifyArena;
        gameInitiated = gameStart;
        spawnLoc1 = a;
        spawnLoc2 = b;
    }
}
