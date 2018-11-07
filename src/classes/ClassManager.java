package classes;

import org.bukkit.entity.Player;

/**
 * Created by Signifies on 10/3/2018 - 19:10.
 */
public class ClassManager {

    /**
     * Clear armor method -> will eventually be moved to Player Class.
     * @param p
     */
    public void clearArmor(Player p)
    {
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
    }

}
