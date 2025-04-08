package com.voltermc.voltertracker;

import com.voltermc.voltertracker.utils.DiscordWebhook;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class VolterTracker extends JavaPlugin {
    private static String webhookUrl;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        webhookUrl = config.getString("webhook_url");

        getServer().getPluginManager().registerEvents(new CreativeLogger(), this);
        getServer().getPluginManager().registerEvents(new CommandLogger(), this);
        getServer().getPluginManager().registerEvents(new PvPLogger(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveLogger(), this);
        getServer().getPluginManager().registerEvents(new BlockLogger(), this);
        getServer().getPluginManager().registerEvents(new ItemLogger(), this);
        getServer().getPluginManager().registerEvents(new MessageLogger(), this);
        getServer().getPluginManager().registerEvents(new TeleportLogger(), this);

        getCommand("voltertracker").setExecutor(new SetLogCommand(this));

        Bukkit.getLogger().info("VolterTracker enabled.");
    }

    public static void sendToDiscord(String title, String message) {
        if (webhookUrl != null && !webhookUrl.isEmpty()) {
            DiscordWebhook.sendEmbed(webhookUrl, title, message);
        }
    }

    public static void setWebhookUrl(String url) {
        webhookUrl = url;
    }
}
