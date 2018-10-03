package me.signifies.kPVP;

import files.PVPConfig;
import files.StatisticsFile;
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
    public void onEnable() {
        config();

    }

    public void onDisable() {

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

}
