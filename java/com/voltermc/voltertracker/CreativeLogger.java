package com.voltermc.voltertracker;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CreativeLogger implements Listener {

    @EventHandler
    public void onCreativeItemUse(PlayerInteractEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
            ItemStack item = event.getItem();
            if (item != null) {
                String msg = "**" + event.getPlayer().getName() + "** used item in creative: `" + item.getType() + "`";
                VolterTracker.sendToDiscord("Creative Item Use", msg);
            }
        }
    }
}
