package dev.dankom.core_discord.type;

import dev.dankom.util.type.AttributeMap;
import net.dv8tion.jda.api.entities.Activity;

import java.util.HashMap;

public class DiscordAttributeMap extends AttributeMap {
    public DiscordAttributeMap(Activity activity) {
        HashMap<String, Object> defaults = new HashMap<>();
        defaults.put("Activity", activity);
        setDefaults(defaults);
    }
}
