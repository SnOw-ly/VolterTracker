package com.voltermc.voltertracker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetLogCommand implements CommandExecutor {

    private final VolterTracker plugin;

    public SetLogCommand(VolterTracker plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.hasPermission("voltertracker.setlog")) {
            if (args.length != 1) {
                sender.sendMessage("§cUsage: /voltertracker setlog <webhook-url>");
                return true;
            }

            String webhook = args[0];
            FileConfiguration config = plugin.getConfig();
            config.set("webhook_url", webhook);
            plugin.saveConfig();

            VolterTracker.setWebhookUrl(webhook);
            sender.sendMessage("§aWebhook URL updated!");
            plugin.getLogger().info("Webhook updated by " + sender.getName());

            return true;
        } else {
            sender.sendMessage("§cYou don't have permission to do this.");
        }

        return true;
    }
}
