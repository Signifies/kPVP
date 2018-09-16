package me.signifies.kPVP;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class kPlayer implements Listener {

    //private kPVP instance; //TODO might not need this tbh

    Player player;
    Configuration configuration;

    HashMap<UUID,UUID> duels = new HashMap<>();

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

    public HashMap<UUID, UUID> getDuels() {
        return duels;
    }

    public void initiateDuel(UUID one, UUID two) {
        duels.put(one,two);
    }

    public void cancelDuel(UUID one, UUID two) {
        duels.remove(one,two);
    }

    public boolean isInDuel (UUID one, UUID two) {
        return getDuels().containsKey(one) && getDuels().containsValue(two);
    }

    public Inventory getinv ()
    {
        return getPlayer().getInventory();
    }






}
