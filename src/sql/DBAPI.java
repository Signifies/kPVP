package sql;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Signifies on 11/7/2018 - 01:22.
 */
public class DBAPI implements DataTransaction{

    private SQL sql;
    private AccountData data;

    public DBAPI(SQL sql, AccountData data){
        this.sql = sql;
        this.data = data;
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
    public HashMap<UUID, Integer> checkData() {
        return null;
    }
}
