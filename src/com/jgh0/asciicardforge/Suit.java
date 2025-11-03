package com.jgh0.asciicardforge;


public enum Suit {
	CLUBS('+'),
	HEARTS('#'),
	DIAMONDS('O'),
	SPADES('^');

	private final char symbol;

	Suit(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public static Suit fromSymbol(char c) {
		for (Suit s : values()) {
			if (s.symbol == c)
				return s;
		}
		throw new IllegalArgumentException("Invalid suit symbol: " + c);
	}
}