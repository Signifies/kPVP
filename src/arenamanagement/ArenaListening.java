package arenamanagement;

import me.signifies.kPVP.kPVP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Signifies on 10/10/2018 - 23:38.
 */
public class ArenaListening implements Listener {

    private kPVP instance;
    ArenaManager arenaManager;
    public ArenaListening(kPVP value){
        this.instance = value;
        arenaManager = instance.getManager();
    }

    @EventHandler
    public void join(PlayerJoinEvent event){
        Player p = event.getPlayer();
        Arena arena = arenaManager.getArena("kPVP");
        if(arena == null) return;
        if(arena.getPlayers().size() <3 ){
            arena.getPlayers().add(p.getUniqueId());
        }
    }



}
