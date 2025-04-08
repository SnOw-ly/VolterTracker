package com.voltermc.voltertracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveLogger implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        VolterTracker.sendToDiscord("Player Join", "**" + event.getPlayer().getName() + "** joined the server.");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        VolterTracker.sendToDiscord("Player Leave", "**" + event.getPlayer().getName() + "** left the server.");
    }
}
