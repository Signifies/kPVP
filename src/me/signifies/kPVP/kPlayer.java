package me.signifies.kPVP;

import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class kPlayer implements Listener {

    //private kPVP instance; //TODO might not need this tbh

    private Player player;
    private String name;
    private UUID uuid;
    private ItemStack[] contents, armor;
    private Location location;

    Configuration configuration;

    HashMap<UUID,UUID> duels = new HashMap<>();

    public kPlayer(Player player, Configuration file) {

        this.player = player;
        this.configuration = file;
    }

    public kPlayer(Player p)
    {
        this.name = p.getName();
        uuid = p.getUniqueId();
        contents = p.getInventory().getContents();
        armor = p.getInventory().getArmorContents();
        location = p.getLocation();
    }

    public Player getPlayer(){
        return player;
    }

    public Inventory getinv ()
    {
        return getPlayer().getInventory();
    }

    public boolean iskPlayer(Player p){
        return name.equalsIgnoreCase(p.getName());
    }

}

/*
*  public UUID getUUID ()
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

    public boolean isInDuel (UUID one, UUID two) throws NullPointerException {
        return two.equals(duels.get(one)) || one.equals(duels.get(two));
    }*/