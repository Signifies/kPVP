package files;

import me.signifies.kPVP.kPVP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Level;

/**
 * Created by Signifies on 10/3/2018 - 14:58.
 */
public class PVPConfig {
    private FileConfiguration PVPConfig = null;
    private File PVPConfigFile = null;
    private static final String fileName = "config.yml";

    private kPVP instance;

    public PVPConfig(kPVP instance)
    {
        this.instance = instance;
    }


    public void reloadPVPConfig() {
        if (PVPConfigFile == null) {
            PVPConfigFile = new File(instance.getDataFolder(),fileName);
        }
        PVPConfig = YamlConfiguration.loadConfiguration(PVPConfigFile);

        // Look for defaults in the jar
        Reader defConfigStream = null;
        try {
            defConfigStream = new InputStreamReader(instance.getResource(fileName), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            PVPConfig.setDefaults(defConfig);
        }
    }

    public FileConfiguration getPVPConfig() {
        if (PVPConfig == null) {
            reloadPVPConfig();
        }
        return PVPConfig;
    }

    public void savePVPConfig() {
        if (PVPConfig == null || PVPConfigFile == null) {
            return;
        }
        try {
            getPVPConfig().save(PVPConfigFile);
        } catch (IOException ex) {
            instance.getLogger().log(Level.SEVERE, "Could not save config to " + PVPConfigFile, ex);
        }
    }

    public void saveDefaultPVPConfig() {
        if (PVPConfigFile == null) {
            PVPConfigFile = new File(instance.getDataFolder(), fileName);
        }
        if (!PVPConfigFile.exists()) {
            instance.saveResource(fileName, false);
        }
    }
}
