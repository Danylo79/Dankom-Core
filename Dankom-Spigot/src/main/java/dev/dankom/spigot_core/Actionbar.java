package dev.dankom.spigot_core;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Actionbar {
    private String msg;
    private Player player;

    public Actionbar(String msg, Player player) {
        this.msg = msg;
        this.player = player;
    }

    public void send() {
        String message = ChatColor.translateAlternateColorCodes('&', msg);
        try {
            Class<?> c1 = Class.forName("org.bukkit.craftbukkit." + MinecraftVersion.getVersion() + ".entity.CraftPlayer");
            if (!(MinecraftVersion.getVersion().equalsIgnoreCase("v1_8_R1") || (MinecraftVersion.getVersion().contains("v1_7_")))) {
                Object ppoc;
                Class<?> c4 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".PacketPlayOutChat");
                Class<?> c5 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".Packet");

                Class<?> c2 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".ChatComponentText");
                Class<?> c3 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".IChatBaseComponent");
                Object o = c2.getConstructor(new Class<?>[]{String.class}).newInstance(message);
                ppoc = c4.getConstructor(new Class<?>[]{c3, byte.class}).newInstance(o, (byte) 2);

                Method getHandle = c1.getDeclaredMethod("getHandle");
                Object handle = getHandle.invoke(player);

                Field fieldConnection = handle.getClass().getDeclaredField("playerConnection");
                Object playerConnection = fieldConnection.get(handle);

                Method sendPacket = playerConnection.getClass().getDeclaredMethod("sendPacket", c5);
                sendPacket.invoke(playerConnection, ppoc);
            } else {
                Object ppoc;
                Class<?> c4 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".PacketPlayOutChat");
                Class<?> c5 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".Packet");

                Class<?> c2 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".ChatSerializer");
                Class<?> c3 = Class.forName("net.minecraft.server." + MinecraftVersion.getVersion() + ".IChatBaseComponent");
                Method m3 = c2.getDeclaredMethod("a", String.class);
                Object cbc = c3.cast(m3.invoke(c2, "{\"text\": \"" + message + "\"}"));
                ppoc = c4.getConstructor(new Class<?>[]{c3, byte.class}).newInstance(cbc, (byte) 2);

                Method getHandle = c1.getDeclaredMethod("getHandle");
                Object handle = getHandle.invoke(player);

                Field fieldConnection = handle.getClass().getDeclaredField("playerConnection");
                Object playerConnection = fieldConnection.get(handle);

                Method sendPacket = playerConnection.getClass().getDeclaredMethod("sendPacket", c5);
                sendPacket.invoke(playerConnection, ppoc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
