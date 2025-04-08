package com.voltermc.voltertracker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PvPLogger implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            Player killed = event.getEntity();
            Player killer = killed.getKiller();
            VolterTracker.sendToDiscord("PvP Kill", "**" + killer.getName() + "** killed **" + killed.getName() + "**");
        }
    }
}
