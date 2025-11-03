

public enum Rank {
	A("A"), K("K"), Q("Q"), J("J"), T("T"),
	_9("9"), _8("8"), _7("7"), _6("6"),
	_5("5"), _4("4"), _3("3"), _2("2");

	private final String label;

	Rank(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static Rank fromLabel(String label) {
		for (Rank r : values()) {
			if (r.label.equalsIgnoreCase(label))
				return r;
		}
		throw new IllegalArgumentException("Invalid rank label: " + label);
	}
}