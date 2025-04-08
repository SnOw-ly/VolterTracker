package com.voltermc.voltertracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageLogger implements Listener {

    @EventHandler
    public void onPrivateMsg(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage().toLowerCase();
        if (msg.startsWith("/msg") || msg.startsWith("/tell") || msg.startsWith("/w")) {
            VolterTracker.sendToDiscord("Private Message", "**" + event.getPlayer().getName() + "** sent: `" + msg + "`");
        }
    }

    @EventHandler
    public void onPublicChat(AsyncPlayerChatEvent event) {
        VolterTracker.sendToDiscord("Public Chat", "**" + event.getPlayer().getName() + "**: `" + event.getMessage() + "`");
    }
}
