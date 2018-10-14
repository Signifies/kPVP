package classes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import utilities.PVPUtils;

import java.util.HashSet;

public interface Kit {

    String kitName();

    String getDisplay();

    Inventory getPlayerArmor();
    void setArmor();
}
