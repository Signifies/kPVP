package utilities;

import me.signifies.kPVP.kPVP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class PVPUtils {

    private static String name= "&b[kPVP]&r";

    String author = "9c5dd792-dcb3-443b-ac6c-605903231eb2";
    public static String  defaultResponse ="Unknown command. Type \"/help\" for help.";

    public boolean checkAuthor(UUID uuid)
    {
        return uuid.toString().equals(author);
    }

    public void displayAuthInfo(Player p)
    {
        if(checkAuthor(p.getUniqueId()))
        {
            p.sendMessage(color("&a&l&oHello, &7"+ p.getUniqueId().toString() +"\n &aThis server is using ") + getPrefix());
        }
    }

    /**
     * Gets the set plugin prefix.
     *
     * @return
     */
    public static String getPrefix()
    {
        return name;
    }

    /**
     * Method that handles all the color formatting
     *
     * @param message
     * @return
     */
    public static String color(String message) {
        String msg =  message;
//        msg = msg.replace("&", "§");

        msg = msg.replace("{prefix}",getPrefix());
        return ChatColor.translateAlternateColorCodes('&',msg);
    }

    public String msg(String configPath, boolean removeColor, String[] values)
    {
        String result = configPath;
        if(result !=null)
        {
            if(removeColor)
            {
                result = color(result);
            }
            for(int k=0; k < values.length; k++)
            {
                String replaced = (values[k] != null) ? values[k] : "NULL";
                result = result.replace("{"+ k +"}",replaced);
            }
            return removeColor ? result : color(result);
        }
        //Debug.log(Debug.pluginLog()+"Error finding a message!",1);
        return null;
    }



    public String permissionResponse(boolean def, String response)
    {
        return def ? defaultResponse : msg(response);
    }


    public String msg(String path, String... replaced)
    {
        return msg(path,false,replaced);
    }

    public String msg(String path)
    {
        return msg(path,false,new String[0]);
    }

    public String check(boolean value, String name)
    {
        return  value ? name +ChatColor.GREEN +" [Enabled]"  : name + ChatColor.DARK_RED+" [Disabled]";
    }

    public void sendText(List<String> text, CommandSender sender)
    {
        for(String txt: text)
        {
            txt = txt.replace("{player}",sender.getName());
            sender.sendMessage(color(txt));
        }
    }

    public static void sendText(List<String> text, CommandSender sender, String s)
    {
        int amt = Bukkit.getServer().getOnlinePlayers().size();

        int max = Bukkit.getServer().getMaxPlayers();

        for(String txt: text)
        {
            txt = txt.replace("{online_players}", ""+amt);
            txt = txt.replace("{max_players}", ""+max);
            txt = txt.replace("{player}",sender.getName());
            //txt = txt.replace("{staff}",getStaff(s));
            txt =txt.replace("{time}",getStamp().toString());
            sender.sendMessage(color(txt));
        }
    }

    public static void sendText(ArrayList<String> text, CommandSender sender)
    {
        for(String txt: text)
        {
            txt = txt.replace("{player}",sender.getName());
            sender.sendMessage(color(txt));
        }
    }
    public void sendText(ArrayList<String> text, Player sender)
    {
        for(String txt: text)
        {
            txt = txt.replace("{player}",sender.getName());
            sender.sendMessage(color(txt));
        }
    }

    public void sendText(List<String> text, Player sender)
    {
        for(String txt: text)
        {
            txt = txt.replace("{player}",sender.getName());
            txt = txt.replace("{uuid}",sender.getUniqueId().toString());
            txt = txt.replace("{display_name}",sender.getDisplayName());
            txt = txt.replace("{IP}", sender.getAddress().toString());

            sender.sendMessage(color(txt));
        }
    }


    public void runCommands(List<String> commands, Player p, String inform) {
        p.sendMessage(color(inform));
        for (String cmd : commands)
        {
            cmd = cmd.replace("%player%",p.getName());
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
            log("&aExecuted the command(s) &7" + cmd);
        }
    }

    public void runCommands(ArrayList<String> commands)
    {
        for(String cmd : commands)
        {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),cmd);
            log("&aExecuted the commands(s) &7 " + cmd);
        }
    }


    public ArrayList<String> commandList()
    {
        ArrayList<String> value = new ArrayList<String>();

        value.add("     &f----- &7eKernel commands &f-----");
        value.add("&a/eKernel &7<section> [true || false]");
        value.add("&a/eKernel helpbook");

        return value;
    }

    /**
     * Simple placement variable to get a default tag.
     *
     * This should be accessible within our Rank.java class.
     * */

    public static String[] tag = {color("&7Guest&r"),color("&aMember&r"),color("&eGamer&r"),color("&5Builder&r"),color("&9MOD&r"),color("&6SMOD&r"),color("&cADMIN&r"),color("&aDEV&r")};


    /*

     * Method to give a help book to administrators
     * @param
     * @param
     * @return
     *
    public ItemStack helpBook(kPVP instance, Player player)
    {
        String location =  color("&7X:&a"+player.getLocation().getBlockX() +" &7Y&a:" +player.getLocation().getBlockY() + " &7Z&a:" + player.getLocation().getBlockZ() +"&r" );

        ItemStack is = new ItemStack(Material.valueOf(instance.valkyrieConfig().getkConfig().getString("help-book.item")),instance.valkyrieConfig().getkConfig().getInt("help-book.amount"));
        //Debug.log(Debug.LOG + "Logging Help book Hash code: "+is.hashCode(),0);
        String name = instance.valkyrieConfig().getkConfig().getString("help-book.name");
        name = name.replace("{player}",player.getName());
        name = name.replace("{display_name}",player.getDisplayName());
        name = name.replace("{uuid}",player.getUniqueId().toString());
        List<String> lore = instance.valkyrieConfig().getkConfig().getStringList("help-book.lore");
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(color(name));

        for(int i=0; i < lore.size(); i++)
        {
            String page = lore.remove(0);
            page = page.replace("{player}",player.getName());
            page = page.replace("{uuid}",player.getUniqueId().toString());
            page = page.replace("{time}",getStamp().toString());
            page = page.replace("{location}", location);
            page = page.replace("{world}",player.getWorld().getName());
            page = page.replace("{builder}",tag[0]);
            page = page.replace("{mod}",tag[1]);
            page = page.replace("{smod}",tag[2]);
            page = page.replace("{admin}",tag[3]);
            page = page.replace("{dev}",tag[4]);
            //Add prefix, balance etc from permissions ex and economy.
            lore.add(color(page));
        }
        im.setLore(lore);
        is.setItemMeta(im);
        player.sendMessage(color("&7Received &fhelp &7book&f!"));
        return is;
    }

    */


    /**
     *  Logging message to the console.
     *
     * @param msg
     */
    public static void log(String msg)
    {
        Bukkit.getServer().getConsoleSender().sendMessage(color("&c&l[LOG]&f "+name+""+ msg));
    }

    public void clearPlayer(Player p)
    {
        for(int i=0; i < 100; i++)
        {
            p.sendMessage("");
        }
        p.sendMessage(color("&7Your chat has been &7&nCleared&c."));
    }

    public void selfClear(CommandSender sender) {
        for(int i=0; i <100; i++) {
            sender.sendMessage("");
        }
        sender.sendMessage( ChatColor.GRAY + "You have cleared your own chat, "+ ChatColor.GREEN +sender.getName());
    }

    public void selfClear(Player sender) {
        for(int i=0; i <100; i++) {
            sender.sendMessage("");
        }
        sender.sendMessage( ChatColor.GRAY + "You have cleared your own chat, "+ ChatColor.GREEN +sender.getName());
    }

    public void clear() {
        for(Player p :Bukkit.getServer().getOnlinePlayers())
        {
            for(int i=0; i <100; i ++)
            {
                p.sendMessage("");
            }
        }
        Bukkit.broadcastMessage(color("&7&lThe chat has been &a&lcleared&7&l."));
    }

    public ItemStack createItem(Material mat, int amount, String name) {
        ItemStack is = new ItemStack(mat,amount);
        ItemMeta meta = is.getItemMeta();

        meta.setDisplayName(color(name));
        is.setItemMeta(meta);
        return is;
    }

    /**
     * Time stamp Util, for Config and SQL.
     */
    static Calendar cal = Calendar.getInstance();
    static Date now = cal.getTime();
    public static java.sql.Timestamp stamp = new java.sql.Timestamp(now.getTime());
    public static java.sql.Timestamp getStamp() {
        return stamp;
    }



    /**
     * Runs permissionsEx default permissions setup, if the default permissions are not the only system being used.
     * @return
     * @throws NullPointerException
     */
    public ArrayList<String> pexSetup() throws NullPointerException
    {
        ArrayList<String> value = new ArrayList<>();
        value.add("pex group Guest create");
        value.add("pex group Guest prefix &7Guest");
        value.add("pex group Guest add Build.Guest");
        value.add("pex group Guest rank 50");
        value.add("pex group Member create");
        value.add("pex group Member prefix &2Member");
        value.add("pex group Member add Build.member");
        value.add("pex group Member rank 40");
        value.add("pex group Builder create");
        value.add("pex group Builder prefix &bBuilder");
        value.add("pex group Builder add Build.Builder");
        value.add("pex group Builder rank 30");
        value.add("pex group Mod create");
        value.add("pex group Mod prefix &dMod");
        value.add("pex group Mod add Build.mod");
        value.add("pex group Mod rank 20");
        value.add("pex group Admin create");
        value.add("pex group Admin prefix &cAdmin");
        value.add("pex group Admin add Builder.admin");
        value.add("pex group Admin rank 10");
        value.add("pex group Developer create");
        value.add("pex group Developer prefix &6Dev");
        value.add("pex group Developer add '*'");
        value.add("pex group Developer rank 5");
        value.add("pex group Owner create");
        value.add("pex group Owner prefix &4Owner");
        value.add("pex group Owner add '*'");
        value.add("pex group Owner rank 1");
        value.add("pex groups");
        System.out.println(color("%prefix% &4PermissionsEx File has been created with ranks!"));

        return value;

    }

    public void executePexsetup(){

        if(Bukkit.getServer().getPluginManager().getPlugin("PermissionsEx").isEnabled())
        {
            runCommands(pexSetup());
        }else
        {
            log("&4Unable to start PEX setup! Is PermissionsEx plugin installed?");
        }
    }





}
