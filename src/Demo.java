

public class Demo {
	public static void main(String[] args) {
		Card c1 = new Card("A+");
		Card c2 = new Card("AO");
		Card c3 = new Card("K+");

		// Works with varargs
		CardPrinter.print(c1, c2, c3);

		// Works with arrays
		Card[] hand = { c1, c2, c3 };
		CardPrinter.print(hand);
	}
}