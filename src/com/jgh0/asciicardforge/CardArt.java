package com.jgh0.asciicardforge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CardArt {

    private static final String CARDS_JSON = "/cards/cards.json"; // classpath path
    private static final Map<String, String> art = new HashMap<>();

    static {
        try (InputStream is = CardArt.class.getResourceAsStream(CARDS_JSON)) {
            if (is == null) throw new RuntimeException("Could not find " + CARDS_JSON + " in classpath!");
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = reader.readLine()) != null) sb.append(line).append("\n");
            }
            parseJson(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not load cards JSON: " + e.getMessage(), e);
        }
    }

    private static void parseJson(String json) {
        json = json.trim();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}")) json = json.substring(0, json.length() - 1);

        String[] entries = json.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        for (String entry : entries) {
            String[] kv = entry.split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", 2);
            if (kv.length == 2) {
                String key = kv[0].trim().replaceAll("^\"|\"$", "");
                String value = kv[1].trim().replaceAll("^\"|\"$", "")
                        .replace("\\n", "\n").replace("\\\"", "\"").replace("\\\\", "\\");
                art.put(key.toUpperCase(Locale.ROOT), value);
            }
        }
    }

    public static String get(String cardName) {
        return art.getOrDefault(cardName.toUpperCase(Locale.ROOT), "[UNKNOWN CARD: " + cardName + "]");
    }

    public static String get(Card card) {
        String key = (card.rank().getLabel() + "_" + card.suit().name()).toUpperCase(Locale.ROOT);
        return art.getOrDefault(key, "[UNKNOWN CARD: " + key + "]");
    }
}
