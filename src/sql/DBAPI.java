package sql;

import me.signifies.kPVP.kPVP;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

/**
 * Created by Signifies on 11/7/2018 - 01:22.
 */
public class DBAPI implements DataTransaction{

    private SQL sql;
    private kPVP instance;
    private AccountData data;

    private Map<String, AccountData> nameToData;
    private Map<UUID, AccountData> uuidToData;
    private Set<AccountData> accountData;

    private File file;


    public DBAPI(kPVP instance, AccountData data){
        this.instance = instance;
        this.sql = instance.getSQL();
        this.data = data;
        accountData = new HashSet<>();
        nameToData = new HashMap<>();
        uuidToData = new HashMap<>();
        file = new File(instance.getDataFolder().getAbsolutePath(), "user-data.yml");

    }

    public void loadData() {
        if(!file.exists()){
            instance.saveResource("user-data.yml",false);
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        for(String key : config.getKeys(true)) {
            UUID id;
            try{
                id = UUID.fromString(key);
            }catch (Exception exception){
                continue;
            }
            String string = config.getString(key);
            String name = string.split("::")[0];
            int kills = Integer.parseInt(string.split("::")[1]);
            int deaths = Integer.parseInt(string.split("::")[2]);
            double KDR = Double.parseDouble(string.split("::")[3]);
            AccountData account = new AccountData(Bukkit.getOfflinePlayer(id),id,name,kills,deaths,KDR);
            uuidToData.put(id,account);
            nameToData.put(name.toLowerCase(),account);
            accountData.add(account);
        }
    }


    public SQL getSQL(){
        return this.sql;
    }

    public AccountData getData() {
        return this.data;
    }


    @Override
    public void transaction(SQL sql, AccountData data) {

    }

    @Override
    public void commitDataTransaction(AccountData data) {

    }

    @Override
    public void pullDataTransaction(AccountData data) {

    }

    @Override
    public void checkUser(Player player) {

    }

    @Override
    public void createTable() {
        sql.createTable("CREATE TABLE IF NOT EXISTS datatable (id INT AUTO_INCREMENT, UUID varchar(50) PRIMARY KEY, name varchar(50), kills INT, deaths INT, KDR DOUBLE(7,4), stamp TIMESTAMP, server_name varchar(25)); ");
    }

    @Override
    public HashMap<UUID, Integer> checkData() {
        return null;
    }
}
