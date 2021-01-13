package dev.dankom.core_discord;

import dev.dankom.core_discord.type.DiscordAttributeMap;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    private final JDA jda;
    private final DiscordAttributeMap dam;

    public DiscordBot(String token, DiscordAttributeMap dam) throws LoginException {
        this.jda = JDABuilder.createDefault(token).build();
        this.dam = dam;

        init();
    }

    private void init() {
        jda().getPresence().setActivity((Activity) dam.get("activity"));
    }

    public DiscordBot(String token) throws LoginException {
        this(token, new DiscordAttributeMap());
    }

    public JDA jda() {
        return jda;
    }
}
