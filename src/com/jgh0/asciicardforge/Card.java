package com.jgh0.asciicardforge;

public class Card {
	private final Suit suit;
	private final Rank rank;

	// constructor using Suit + Rank
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	// constructor using shorthand like "A+" or "AO"
	public Card(String code) {
		if (code == null || code.length() != 2)
			throw new IllegalArgumentException("Card code must be exactly 2 characters (e.g. 'A+', '9O', 'K*')");

		this.rank = Rank.fromLabel(String.valueOf(code.charAt(0)));
		this.suit = Suit.fromSymbol(code.charAt(1));
	}

	public Suit suit() {
		return suit;
	}

	public Rank rank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank.getLabel() + suit.getSymbol();
	}
}