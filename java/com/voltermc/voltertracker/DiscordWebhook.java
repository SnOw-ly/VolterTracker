package com.voltermc.voltertracker.utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DiscordWebhook {

    public static void sendEmbed(String webhookUrl, String title, String description) {
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String payload = "{ \"embeds\": [{ \"title\": \"" + title + "\", \"description\": \"" + description.replace("\"", "\\\"") + "\" }] }";

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(payload.getBytes());
            outputStream.flush();
            outputStream.close();

            connection.getResponseCode(); // Trigger the request
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
