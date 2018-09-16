package me.signifies.kPVP;

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

    public void onEnable() {


    }

    public void onDisable() {

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
