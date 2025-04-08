package com.voltermc.voltertracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandLogger implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String player = event.getPlayer().getName();
        String command = event.getMessage();
        VolterTracker.sendToDiscord("Command Used", "**" + player + "** used: `" + command + "`");
    }
}
