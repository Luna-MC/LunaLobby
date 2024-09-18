package com.lunamc.lobby.utils;

public final class LazyUtil {

    public static boolean anyEquals(Object object, Object... objects) {
        for (Object each : objects)
            if (each.equals(object))
                return true;

        return false;
    }

}
