package dev.dankom.spigot_core;

import org.bukkit.Bukkit;

public class MinecraftVersion {
    public static String getVersion() {
        String v = "";
        v = Bukkit.getServer().getClass().getPackage().getName();
        v = v.substring(v.lastIndexOf(".") + 1);
        return v;
    }
}
