package files;

import me.signifies.kPVP.kPVP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.logging.Level;

/**
 * Created by Signifies on 10/3/2018 - 19:11.
 */
public class StatisticsFile {
    private FileConfiguration StatConfig = null;
    private File StatConfigFile = null;
    private static final String fileName = "statistics.yml";

    private kPVP instance;

    public StatisticsFile(kPVP instance)
    {
        this.instance = instance;
    }


    public void reloadStatConfig() {
        if (StatConfigFile == null) {
            StatConfigFile = new File(instance.getDataFolder(),fileName);
        }
        StatConfig = YamlConfiguration.loadConfiguration(StatConfigFile);

        // Look for defaults in the jar
        Reader defConfigStream = null;
        try {
            defConfigStream = new InputStreamReader(instance.getResource(fileName), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            StatConfig.setDefaults(defConfig);
        }
    }

    public FileConfiguration getStatConfig() {
        if (StatConfig == null) {
            reloadStatConfig();
        }
        return StatConfig;
    }

    public void saveStatConfig() {
        if (StatConfig == null || StatConfigFile == null) {
            return;
        }
        try {
            getStatConfig().save(StatConfigFile);
        } catch (IOException ex) {
            instance.getLogger().log(Level.SEVERE, "Could not save config to " + StatConfigFile, ex);
        }
    }

    public void saveDefaultStatConfig() {
        if (StatConfigFile == null) {
            StatConfigFile = new File(instance.getDataFolder(), fileName);
        }
        if (!StatConfigFile.exists()) {
            instance.saveResource(fileName, false);
        }
    }
}
