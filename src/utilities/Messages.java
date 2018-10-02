package utilities;

import org.bukkit.entity.Player;

public enum Messages {

    TEST(""),
    INFORM(""),
    ARENA_START(""),
    ARENA_FINISH(""),
    DUEL(""),
    GENERAL("");

    String msg;
    Messages(String msg){
        msg = PVPUtils.color(msg);
    }

    public String getMessage(){
        return msg;
    }

    public void setMessage(String format){
        msg = format;
    }

}
