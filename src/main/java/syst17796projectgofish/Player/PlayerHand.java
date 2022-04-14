package syst17796projectgofish.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import syst17796projectgofish.GoFishApp;
import syst17796projectgofish.Poker.PokerCards;

/**
 *
 * @author Joanna He
 */
public class PlayerHand extends Players {

    // a list of PokerCards for Player hand cards
    private List<PokerCards> playerHand;

    public PlayerHand() {
        playerHand = new ArrayList<>();
    }

    public void initialPlayerHand() {
        for (int i = 0; i < 4; i++) {
            playerHand.add(GoFishApp.deck.draw());
        }
    }

    // clear player hand
    public void setClearPlayerHand() {
        playerHand.clear();
    }

    // get the player hand num of cards
    public int getSize() {
        return playerHand.size(); 
    }

    // get the card remove at the index i of the Player hand
    public PokerCards removeCards(int i) {
        return playerHand.remove(i);
    }

    // check if this player have a value of card
    public boolean haveValue(PokerCards.VALUE value) {
        boolean haveValue = false;
        PokerCards card = new PokerCards(value);
        for (int i = 0; i < playerHand.size(); i++) {
            if (card.compareTo(playerHand.get(i)) == 0) {
                haveValue = true;
                return haveValue;
            }
        }
        return haveValue;
    }

    // give card(s) to other player
    public ArrayList<PokerCards> giveCards(PokerCards.VALUE value) {
        ArrayList<PokerCards> give = new ArrayList<PokerCards>();
        PokerCards card = new PokerCards(value);
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).compareTo(card) == 0) {
                give.add(playerHand.remove(i));
                i--;
            }
        }
        return give;
    }

    // player ask for a value of card(s)
    public boolean askCard(PokerCards.VALUE value, int player) {
        PlayerHand otherPlayer = GoFishApp.twoPlayHand[player];
        if (otherPlayer.haveValue(value)) {
            ArrayList<PokerCards> card = otherPlayer.giveCards(value);
            for (int i = 0; i < card.size(); i++) {
                playerHand.add(card.get(i));
            }
            return true;
        } else {
            return false;
        }
    }

    // fish
    public void fish() {
        if (GoFishApp.deck.numOfCard() > 0) {
            playerHand.add(GoFishApp.deck.draw());
        }
    }

    // check if there's a set in hand
    public boolean checkSet() {
        int[] record = new int[15];
        for (int i = 0; i < playerHand.size(); i++) {
            record[playerHand.get(i).getValue()]++;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 4) {
                return true;
            }
        }
        return false;
    }

    // a set in hand passes to table
    public ArrayList<PokerCards> passSetToTable() {
        Collections.sort(playerHand);
        ArrayList<PokerCards> set = new ArrayList<PokerCards>();
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).compareTo(playerHand.get(i + 1)) == 0) {
                if (playerHand.get(i).compareTo(playerHand.get(i + 2)) == 0) {
                    if (playerHand.get(i).compareTo(playerHand.get(i + 3)) == 0) {
                        set.add(playerHand.remove(i));
                        set.add(playerHand.remove(i));
                        set.add(playerHand.remove(i));
                        set.add(playerHand.remove(i));
                        return set;
                    }
                }
            }
        }
        return null;
    }

    // print out player's hand
    public String playerHandtoString() {
        String output = "";
        Collections.sort(playerHand);
        ListIterator<PokerCards> i = playerHand.listIterator();
        while (i.hasNext()) {
            output += i.next() + " . ";
        }
        return output;
    }

}