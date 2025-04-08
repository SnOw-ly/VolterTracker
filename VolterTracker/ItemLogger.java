package com.voltermc.voltertracker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemLogger implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack item = event.getItemDrop().getItemStack();
        VolterTracker.sendToDiscord("Item Dropped", "**" + event.getPlayer().getName() + "** dropped: `" + item.getAmount() + "x " + item.getType() + "`");
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();
        VolterTracker.sendToDiscord("Item Picked", "**" + event.getPlayer().getName() + "** picked up: `" + item.getAmount() + "x " + item.getType() + "`");
    }
}
