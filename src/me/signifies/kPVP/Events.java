package me.signifies.kPVP;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Signifies on 10/3/2018 - 20:12.
 */
public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){

    }

    @EventHandler
    public void worldBreak(BlockBreakEvent event){

    }

    @EventHandler
    public void worldPlace(BlockPlaceEvent event){

    }




}
