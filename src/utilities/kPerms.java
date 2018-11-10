package utilities;

import java.util.ArrayList;

/**
 * Created by Signifies on 11/9/2018 - 22:50.
 */
public enum kPerms {


    PERM1(""),

    PERM2("");

    String permission;

    kPerms(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }



}
