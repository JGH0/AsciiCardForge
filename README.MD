# ASCII Card Generator

A small Java library to print ASCII art playing cards in the terminal. Works in any environment — no Unicode symbols required, just plain ASCII. Perfect for text-based card games, demos, or fun terminal applications.

---

## Features

- Print one or multiple cards side by side.
- Supports both arrays and varargs of `Card` objects.
- Fully ASCII-based — works in any terminal.
- Easy-to-extend card art stored in `resources/cards/cards.json`.
- Simple API for integrating into your projects.

---

## Installation

Clone the repository:

```bash
git clone https://github.com/yourusername/ASCII_CardGenerator.git
cd ASCII_CardGenerator
```

Compile the source:

```bash
javac src/*.java
```

Run the demo:

```bash
java -cp src Demo
```

---

## Usage

### Create Cards

```java
Card c1 = new Card("A+");
Card c2 = new Card("AO");
Card c3 = new Card("K+");
```

### Print Cards

```java
// Using varargs
CardPrinter.print(c1, c2, c3);

// Using an array
Card[] hand = { c1, c2, c3 };
CardPrinter.print(hand);
```

### Output Example

```
  _________     _________     _________
 |A        |   |A        |   |K |/|\|  |
 |+   *    |   |O  /~\   |   |+ /o,o\  |
 |    !    |   |  / ^ \  |   |  \_-_/  |
 |  *-+-*  |   | ( <O> ) |   | ~-_-~-_ |
 |    |    |   |  \ v /  |   |  /~-~\  |
 |   ~~~  +|   |   \_/  O|   |  \o`o/ +|
 |        V|   |        V|   |  |\|/| X|
  ~~~~~~~~~     ~~~~~~~~~     ~~~~~~~~~
```

---

## Project Structure

```
.
├── ASCI_Art.txt
├── resources
│   └── cards
│       └── cards.json   # ASCII art definitions
└── src
    ├── Card.java         # Card model
    ├── CardArt.java      # ASCII art loader
    ├── CardPrinter.java  # Print utility
    ├── Demo.java         # Demo / example usage
    ├── Rank.java         # Card ranks
    └── Suit.java         # Card suits
```

---

## Contributing

Contributions are welcome!

- Add new card art or card sets under `resources/cards/`.
- Improve the printer alignment or add features.
- Report bugs or suggest features via GitHub Issues.

---

## License

This project is licensed under the MIT License.