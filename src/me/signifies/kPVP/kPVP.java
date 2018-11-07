package me.signifies.kPVP;

import arenamanagement.ArenaManager;
import files.PVPConfig;
import files.StatisticsFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import utilities.PVPUtils;

public class kPVP extends JavaPlugin{

    public PluginDescriptionFile pdfFile = this.getDescription();

    public static boolean DEBUG = true;
    PVPUtils util = new PVPUtils();
    PVPConfig conf = new PVPConfig(this);
    StatisticsFile stat = new StatisticsFile(this);
    private ArenaManager arena;
    public void onEnable() {

        config();
        arena = new ArenaManager(this);
        arena.serialise();
        Bukkit.getServer().getPluginManager().registerEvents(new Events(),this);
    }

    public void onDisable() {
        arena.deserialise();
    }


    void config() {
        conf.saveDefaultPVPConfig();
        conf.savePVPConfig();
        stat.saveDefaultStatConfig();
        stat.saveStatConfig();
    }


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {

        if(!(sender instanceof Player))
        {
            if(cmd.getName().equalsIgnoreCase("kadmin"))
            {
                if(args.length < 1)
                {
                    switch (args[0].toLowerCase())
                    {

                        case "pex":
                            util.executePexsetup();
                            break;


                    }
                }
            }
        }
        return true;

    }

    public PVPConfig getConf(){
        return conf;
    }

    public ArenaManager getManager(){
        return arena;
    }
}
