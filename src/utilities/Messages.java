package utilities;

import org.bukkit.entity.Player;

public enum Messages {
  //Want to make sure everythings going over.

    TEST("Test Message"),
    INFORM("General Information -> "),
    ARENA_START("ArenaManager Started"),
    ARENA_FINISH("ArenaManager Finished."),
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
