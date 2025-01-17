package org.example.demo.chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Concurrent canonicalizing map atop ConcurrentMap - Pages 273-274
class Intern {
    // Concurrent canonicalizing map atop ConcurrentMap - not optimal
    private static final ConcurrentMap<String, String> map =
            new ConcurrentHashMap<>();

    //    public static String intern(String s) {
    //        String previousValue = map.putIfAbsent(s, s);
    //        return previousValue == null ? s : previousValue;
    //    }

    // Concurrent canonicalizing map atop ConcurrentMap - faster!
    public static String intern(String s) {
        var result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null)
                result = s;
        }
        return result;
    }
}
