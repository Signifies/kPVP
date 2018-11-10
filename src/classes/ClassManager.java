package classes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Signifies on 10/3/2018 - 19:10.
 */
public class ClassManager implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]){

        if(args.length < 1){
            //if(user.HasPermission()) //TODO not sure which type of permission system I want to implement... Probably standard perms.
        }else {
            switch (args[0].toLowerCase()) {

                case "enable":
                    break;
                case "disable":
                    break;
                case "timeduseage":
                    break;
                case "list":
                    break;


                    default:
                        //usage.
            }
        }

        return true;
    }


}
