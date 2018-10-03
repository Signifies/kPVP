package utilities;

import org.bukkit.entity.Player;

public enum Messages {

    TEST("Test Message"),
    INFORM("General Information -> "),
    ARENA_START("Arena Started"),
    ARENA_FINISH("Arena Finished."),
    DUEL("Duel begins..."),
    GENERAL(""),
    PERMISSION("You can't do this.");


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
