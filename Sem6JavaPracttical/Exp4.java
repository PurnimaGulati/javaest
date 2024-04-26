import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Card {
    private String symbol;

    public Card(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Card{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}

public class Exp4 {
    private Collection<Card> cards;

    public Exp4() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Collection<Card> findCardsBySymbol(String symbol) {
        Collection<Card> foundCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equals(symbol)) {
                foundCards.add(card);
            }
        }
        return foundCards;
    }

    public static void main(String[] args) {
        Exp4 cardCollection = new Exp4();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample cards
        cardCollection.addCard(new Card("Heart"));
        cardCollection.addCard(new Card("Diamond"));
        cardCollection.addCard(new Card("Spade"));
        cardCollection.addCard(new Card("Club"));
        cardCollection.addCard(new Card("Heart"));
        cardCollection.addCard(new Card("Spade"));

        // Asking user for symbol to search
        System.out.print("Enter the symbol to search: ");
        String symbolToSearch = scanner.nextLine();

        // Finding cards by symbol
        Collection<Card> foundCards = cardCollection.findCardsBySymbol(symbolToSearch);

        // Displaying found cards
        if (foundCards.isEmpty()) {
            System.out.println("No cards found with symbol '" + symbolToSearch + "'");
        } else {
            System.out.println("Cards found with symbol '" + symbolToSearch + "':");
            for (Card card : foundCards) {
                System.out.println(card);
            }
        }
    }
}
