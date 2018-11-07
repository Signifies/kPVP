package sql;

import org.bukkit.OfflinePlayer;

import java.util.UUID;

/**
 * Created by Signifies on 11/7/2018 - 00:13.
 */
public class AccountData {

    private OfflinePlayer player;
    private UUID uuid;
    private String name;
    private int kills,deaths;
    private double kdr;

    public AccountData(OfflinePlayer player, UUID id, String name, int kills, int deaths, double kdr){
        this.player =player;
        this.uuid = id;
        this.name = name;
        this.kills = kills;
        this.deaths = deaths;
        this.kdr = kdr;
    }

    public UUID getID(){
        return uuid;
    }

    public String name(){
        return name;
    }

    public OfflinePlayer getPlayer(){
        return player;
    }

    public int getKills(){
        return kills;
    }

    public int getDeaths(){
        return deaths;
    }

    public double getKDR(){
        return kdr;
    }

    public void setID(UUID id) {
        this.uuid =id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(OfflinePlayer player) {
        this.player = player;
    }

    public void setKills(int kills){
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setKDR(double kdr) {
        this.kdr = kdr;
    }
}
