package arenamanagement;

import arenamanagement.Arena;
import me.signifies.kPVP.kPVP;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ArenaManager {


    private kPVP instance;
    private FileConfiguration config;
    private Set<Arena> arenaList;

    public ArenaManager(kPVP value){
        this.instance = value;
        config = instance.getConf().getPVPConfig();
        this.arenaList = new HashSet<>();
    }

    public void serialise() {
        ConfigurationSection sec = config.getConfigurationSection("Arena");
        if(sec == null) return;
        sec.getKeys(false).forEach(s -> arenaList.add(new Arena(s,(Location)config.get("Arena."+s+".location"), (Location)config.get("Arena."+s+".location-a"), (Location)config.get("Arena."+s+".location-b"))));
    }

    public void deserialise(){
        arenaList.forEach(arena -> config.set("Arena."+arena.getName()+".location",arena.getLoc()));
        arenaList.forEach(arena -> config.set("Arena."+arena.getName()+".location-a",arena.getLocA()));
        arenaList.forEach(arena -> config.set("Arena."+arena.getName()+".location-b",arena.getLocB()));
        instance.getConf().savePVPConfig();
    }

    public Arena getArena(Player player) {
        UUID uuid = player.getUniqueId();
        return arenaList.stream().filter(arena -> arena.getPlayers().contains(uuid)).findFirst().orElse(null);
    }

    public Arena getArena(String key) {
        return arenaList.stream().filter(arena -> arena.getName().equals(key)).findFirst().orElse(null);
    }


    public Set<Arena> getArenaList() {
        return arenaList;
    }

}
