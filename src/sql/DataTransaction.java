package sql;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Signifies on 11/7/2018 - 01:26.
 */
public interface DataTransaction
{
    void transaction(SQL sql, AccountData data);

    void commitDataTransaction(AccountData data);

    void pullDataTransaction(AccountData data);

    void checkUser(Player player);

    void createTables();

    HashMap<UUID, Integer> checkData();
}
