package syst17796projectgofish.Player;

import java.util.ArrayList;

import syst17796projectgofish.Poker.PokerCards;

/**
 *
 * @author Mitch Pepito
 */
public class PlayerCardsOnTable extends Players {

    private ArrayList<PokerCards> tableCard;

    // Generate cardsOnTable
    public PlayerCardsOnTable() {
        tableCard = new ArrayList<PokerCards>();
    }

    // get the numumber of cards on table
    public int numOfCardsonTable() {
        return tableCard.size();
    }

    // add set from player's hand to table
    public void addSet(ArrayList<PokerCards> set) {
        for (int i = 0; i < 4; i++) {
            tableCard.add(set.get(0));
        }
    }

    // get card on the table with index i
    public PokerCards getCard(int i) {
        return tableCard.get(i);
    }

}
