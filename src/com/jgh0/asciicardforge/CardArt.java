package com.jgh0.asciicardforge;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CardArt {

    private static final String CARDS_JSON = "resources/cards/cards.json";
    private static final Map<String, String> art = new HashMap<>();

    static {
        try {
            String jsonContent = Files.readString(Path.of(CARDS_JSON));
            parseJson(jsonContent);
        } catch (IOException e) {
            throw new RuntimeException("Could not load cards JSON: " + e.getMessage(), e);
        }
    }

    private static void parseJson(String json) {
        // Remove whitespace and braces
        json = json.trim();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}")) json = json.substring(0, json.length() - 1);

        // Split entries
        String[] entries = json.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // split by comma outside quotes
        for (String entry : entries) {
            String[] kv = entry.split(":(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", 2); // split key/value
            if (kv.length == 2) {
                String key = kv[0].trim().replaceAll("^\"|\"$", "");
                String value = kv[1].trim().replaceAll("^\"|\"$", "")
                        .replace("\\n", "\n").replace("\\\"", "\"").replace("\\\\", "\\"); // unescape
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
