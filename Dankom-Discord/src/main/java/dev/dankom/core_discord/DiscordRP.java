package dev.dankom.core_discord;

import dev.dankom.interfaces.Temporary;
import dev.dankom.logger.Logger;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

public class DiscordRP implements Temporary {
    private boolean running = true;
    private long created = 0;
    private Logger logger;
    private String secret;
    private final String state;
    private final String details;

    public DiscordRP(Logger logger, String secret, String state, String details) {
        this.secret = secret;
        this.state = state;
        this.details = details;
        this.logger = logger;
    }

    @Override
    public void open() {
        this.created = System.currentTimeMillis();
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(discordUser -> {
            logger.info("DiscordRP", "Starting DiscordRP (User: " + discordUser.username + "#" + discordUser.discriminator + ")");
            update();
        }).build();

        DiscordRPC.discordInitialize(secret, handlers, false);

        new Thread(() -> {
            while (running) {
                DiscordRPC.discordRunCallbacks();
            }
        }).start();
    }

    @Override
    public void close() {
        this.running = false;
        DiscordRPC.discordShutdown();
    }

    public void update() {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(state);
        b.setDetails(details);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }
}
