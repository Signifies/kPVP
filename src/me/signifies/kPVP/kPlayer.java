package me.signifies.kPVP;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


import java.util.UUID;

public class kPlayer implements Listener {

    //private kPVP instance; //TODO might not need this tbh

    Player player;
    Configuration configuration;
    public kPlayer(Player player, Configuration file) {

        this.player = player;
        this.configuration = file;
    }

    public Player getPlayer(){
        return player;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public UUID getUUID ()
    {
       return getPlayer().getUniqueId();
    }
}
