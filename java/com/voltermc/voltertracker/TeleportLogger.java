package com.voltermc.voltertracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class TeleportLogger implements Listener {

    @EventHandler
    public void onTeleportCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage().toLowerCase();
        if (msg.startsWith("/tp") || msg.startsWith("/teleport") || msg.startsWith("/tpa")) {
            VolterTracker.sendToDiscord("Teleport Command", "**" + event.getPlayer().getName() + "** used teleport: `" + event.getMessage() + "`");
        }
    }
}
