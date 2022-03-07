package syst17796projectgofish.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import syst17796projectgofish.Poker.PokerCards;

/**
 *
 * @author Joanna He
 */
public class PlayerHand extends PokerCards {


    // a list of PokerCards for Player hand cards
    public List<PokerCards> playerHand = new ArrayList<>();

    //represent how many cards player has
    public int playerHandSize;

    //Player hand constructor generate a set of player hand cards
    public PlayerHand(){
        for(SUIT suit : SUIT.values()){
            for(VALUE value: VALUE.values()){
                PokerCards card = new PokerCards(value, suit);
                playerHand.add(card);
            }
        }
    }
    //get the card remove at the index i of the Player hand
    public PokerCards removeCards(int i){
        return playerHand.remove(i);
    }

    //clear player hand
    public void setClearPlayerHand(){
        playerHand.clear();
    }

    //get Player hand cards size
    public int getPlayerHandSize(){
        return playerHandSize;
    }
    // find out player hand card size
    public void setPlayerHandSize(int playerHandSize){
        this.playerHandSize = playerHand.size();
    }


    @Override
    public String toString(){
        String output="";
        ListIterator<PokerCards> i =this.playerHand.listIterator();
        while(i.hasNext()){
            output += i.next()+ ".";
        }
        return output+"\n The Player has "+playerHandSize;

    }


}