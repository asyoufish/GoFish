package syst17796projectgofish;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import syst17796projectgofish.Player.PlayerCardsOnTable;
import syst17796projectgofish.Player.PlayerHand;
import syst17796projectgofish.Player.Players;
import syst17796projectgofish.Poker.PokerCards;
import syst17796projectgofish.Poker.PokerDeck;

/**
 * This class is the main tester class for the Go Fish game application.
 * Currently incomplete code with placeholders
 * @author Mitch Pepito
 */
public class GoFishApp {

    private int computerScore;
    private int playerScore;
    private boolean winner;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlayerCardsOnTable[] table = new PlayerCardsOnTable[52];

        Random random = new Random();

        //remove cards from deck and distribute to players
        //show starting hand, call on other methods/classes
        System.out.println("This is your hand");

        //display playerHand
        
        
        
        //prompt player to call a card value
        //check
        System.out.println("What value would you like to call? (2-10, jack"
                + ", queen, king, ace)");
        System.out.println("Enter 'score' to display the current score, "
                + "or 'quit' to end the game.");
        String playerAction = sc.nextLine();
        switch (playerAction) {
            //if user enters any of theses accepted values it will call
            //the callValue method
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
            case "jack":
            case "queen":
            case "king":
            case "ace":
                //invokes the callValue method
                callValue(playerAction);
                break;
            case "score":
                //returns current score, num of group of 4s for each value
                break;
            case "quit":
                //for when the user does not want to play anymore
                //will display final score
                System.exit(0);
            default:
                System.out.println("Invalid value. Please enter the value"
                        + " of a Poker Card.");
                break;
        }//end of switch case

    } //end of main

    //method to check if opponent has the value stated in hand
    public static void callValue(String playerAction) {
        System.out.println("You: Do you have any " + playerAction
                + "s?");
        //check opponent's hand for value and return true or false
        //if true, add those card(s) to the turn player's pile
    

    }

    public static void drawCard()
    {
    
    }
    
}//end of class
