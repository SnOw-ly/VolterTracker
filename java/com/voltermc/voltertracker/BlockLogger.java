package com.voltermc.voltertracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockLogger implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        String msg = "**" + event.getPlayer().getName() + "** placed: `" + event.getBlock().getType() + "` at " + event.getBlock().getLocation();
        VolterTracker.sendToDiscord("Block Placed", msg);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        String msg = "**" + event.getPlayer().getName() + "** broke: `" + event.getBlock().getType() + "` at " + event.getBlock().getLocation();
        VolterTracker.sendToDiscord("Block Broken", msg);
    }
}
