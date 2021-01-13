package dev.dankom.spigot_core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public class Hologram {
    private Plugin plugin;
    private final String text;
    private final int offset;

    public Hologram(Plugin plugin, String text, int offset) {
        this.plugin = plugin;
        this.text = text;
        this.offset = offset;
    }

    public Hologram(Plugin plugin, String text) {
        this(plugin, text, -1);
    }

    public void spawn(Location loc) {
        loc.setY(loc.getY() + offset);
        ArmorStand armorStand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', text));
        armorStand.setCustomNameVisible(true);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            armorStand.remove();
        }, 60);
    }

    public void spawn(World world, int x, int y, int z) {
        spawn(new Location(world, x, y, z));
    }
}
