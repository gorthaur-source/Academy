package org.academiadecodigo.tailormoons.promptlogin;

import java.util.Map;
import java.util.TreeMap;

public class UserPasswords {

    static private final Map<String, String> passwordUser = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);


    public static void addAUser(String user, String password) {
        passwordUser.put(user, password);
    }


    public static boolean isLegitUser(String user, String password) {

        if(containsUser(user)) {
            return passwordUser.get(user).equals(password);
        }
        return false;

    }

    public static boolean containsUser(String user) {
        return passwordUser.containsKey(user);
    }


}