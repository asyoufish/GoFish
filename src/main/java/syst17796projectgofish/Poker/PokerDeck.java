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
    
    //a list of PokerCards is a Poker Deck
    public List<PokerCards> pokerDeck = new ArrayList<>();
    
    //Poker Deck constructor generate a full deck of Poker Cards
    public PokerDeck() {
        for(SUIT suit : SUIT.values()){
            for(VALUE value : VALUE.values()){
                PokerCards cd = new PokerCards(value, suit);
                pokerDeck.add(cd);
            }
        }
    }
    
    //Get the cards at the index i of the Poker Deck
    public PokerCards getPokerCards(int i) {
        return pokerDeck.get(i);
    }
    
    //Shffle Deck function
    public void shuffleCards(){
        Collections.shuffle(this.pokerDeck);
    }
    
    //List out all the cards from top to bottom of the deck
    @Override
    public String toString() {
        String output = "";
        ListIterator<PokerCards> i = this.pokerDeck.listIterator();
        while(i.hasNext()){
            output += i.next() + ". ";
        }
        return output;
    }
}