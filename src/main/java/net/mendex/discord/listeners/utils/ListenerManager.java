package net.mendex.discord.listeners.utils;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class ListenerManager {

    private static final ArrayList<Object> LISTENERS = new ArrayList<>();

    public static void addListeners(Object... listeners) {
        for (Object object : listeners) {
            if (object instanceof Collection<?> collection) {
                LISTENERS.addAll(
                        collection.stream()
                        .filter(listener -> listener instanceof ListenerAdapter)
                        .toList()
                );
            }
            else if (object instanceof ListenerAdapter listener) LISTENERS.add(listener);
        }
    }

    public static ArrayList<Object> getListeners() {
        return LISTENERS;
    }

}
