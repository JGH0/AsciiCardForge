

public class CardPrinter {

	// Print multiple cards as varargs
	public static void print(Card... cards) {
		if (cards == null || cards.length == 0) {
			System.out.println("[NO CARDS]");
			return;
		}

		// Each card’s ASCII art split into lines
		String[][] cardLines = new String[cards.length][];
		int maxLines = 0;

		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cardLines[i] = new String[]{"[NULL CARD]"};
			} else {
				String art = CardArt.get(cards[i]);
				cardLines[i] = art.split("\n");
			}
			maxLines = Math.max(maxLines, cardLines[i].length);
		}

		// Print line by line (side by side)
		for (int line = 0; line < maxLines; line++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cards.length; i++) {
				if (line < cardLines[i].length) {
					sb.append(cardLines[i][line]);
				} else {
					// pad empty lines if card has fewer lines
					sb.append(" ".repeat(cardLines[i][0].length()));
				}
				sb.append("  "); // spacing between cards
			}
			System.out.println(sb);
		}
	}
}