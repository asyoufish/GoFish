package syst17796projectgofish.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Richie Chan
 */
public class PokerDeck extends PokerCards {

    // a list of PokerCards is a Poker Deck
    private List<PokerCards> pokerDeck = new ArrayList<>();

    // Poker Deck constructor generate a full deck of Poker Cards
    public PokerDeck() {
        for (int i = 0; i < 4; i++) {
            for (VALUE value : VALUE.values()) {
                PokerCards cd = new PokerCards(value);
                pokerDeck.add(cd);
            }
        }
    }

    // Get the top card of the deck
    public PokerCards draw() {
        return pokerDeck.remove(pokerDeck.size() - 1);
    }

    // Shffle Deck function
    public void shuffleCards() {
        Collections.shuffle(pokerDeck);
    }

    // Get the size of deck
    public int numOfCard() {
        return pokerDeck.size();
    }

    // List out all the cards from top to bottom of the deck
    @Override
    public String toString() {
        String output = "";
        ListIterator<PokerCards> i = pokerDeck.listIterator();
        while (i.hasNext()) {
            output += i.next() + ". ";
        }
        return output;
    }
}