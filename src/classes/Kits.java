package classes;

import org.bukkit.entity.Player;

public class Kits {

    /*
    private void giveKitToPlayer(Player player, String kitName){
        for (int i = 0; i<36; i++){
            if (getConfig().getItemStack(kitName +".Items."+i) != null){
                player.getInventory.addItem(getConfig().getItemStack(kitName + ".Items."+i);
                // or player.getInventory.setitem(i, getConfig().getItemStack(kitName + ".Items."+i);
            }
        }
    }
    private Inventory getKitInventory(String kitName){
    Inventory inventory = Bukkit.createInventory(null, 54, "Edit kit " + kitName);
    for (int i =0; i<36; i++){
        if (main.getConfig().getItemStack("Legends.Items."+i) != null){
            inventory.addItem(main.getConfig().getItemStack("Legends.Items."+i));
        }
    }
    // Add save-arrow etc. below
    return inventory;
}
    */


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
