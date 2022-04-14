package syst17796projectgofish;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import syst17796projectgofish.Player.*;
import syst17796projectgofish.Poker.*;

/**
 * This class is the main tester class for the Go Fish game application.
 * 
 * @author Mitch Pepito
 */
public class GoFishApp {

    public static Players[] twoPlayers;
    public static PlayerHand[] twoPlayHand;
    public static PlayerCardsOnTable[] cardsOnTable;

    public static PokerDeck deck;
    private static int computerScore;
    private static int playerScore;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        // initialize the deck
        deck = new PokerDeck();

        System.out.print("Please enter your name: ");
        
        String name = scr.nextLine();

        Players human = new Players(name);
        Players ai = new Players("Computer");
        twoPlayers = new Players[] { human, ai };

        PlayerHand humPlayerHand = new PlayerHand();
        PlayerHand aiPlayerHand = new PlayerHand();
        twoPlayHand = new PlayerHand[] { humPlayerHand, aiPlayerHand };

        PlayerCardsOnTable aiCardsOnTable = new PlayerCardsOnTable();
        PlayerCardsOnTable humCardsOnTable = new PlayerCardsOnTable();
        cardsOnTable = new PlayerCardsOnTable[] { humCardsOnTable, aiCardsOnTable };

        deck.shuffleCards();
        twoPlayHand[0].initialPlayerHand();
        twoPlayHand[1].initialPlayerHand();

        // The game starts here
        while ((cardsOnTable[0].numOfCardsonTable() + cardsOnTable[1].numOfCardsonTable()) < 52) {
            humanTurn();
            System.out.println("--------------Next Player--------------");
            aiTurn();
            System.out.println("--------------Next Player--------------");
            if (twoPlayHand[0].getSize() == 0 && twoPlayHand[0].getSize() == 0
                    && deck.numOfCard() == 0) {
                break;
            }
        }

        // End game
        computerScore = cardsOnTable[1].numOfCardsonTable();
        playerScore = cardsOnTable[0].numOfCardsonTable();

        if (playerScore > computerScore) {
            System.out.println(twoPlayers[0].getName() + " won!! You have " + playerScore + " Cards and Computer have " + computerScore);
        } else if (playerScore < computerScore) {
            System.out.println(twoPlayers[0].getName() + " lose, try harder next time! You have " + playerScore + " Cards and Computer have "
                    + computerScore);
        } else {
            System.out.println("It's a tie. Both of you have " + playerScore + "of Cards");
        }
    }

    // human actions and prompts
    static void humanTurn() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        do {

            // check if player have a set
            if (twoPlayHand[0].checkSet()) {
                System.out.println(twoPlayers[0].getName() + " have a set!");
                cardsOnTable[0].addSet(twoPlayHand[0].passSetToTable());
            }

            // print info about player and computer
            if (cardsOnTable[1].numOfCardsonTable() != 0)
                System.out.println("Computer have " + cardsOnTable[1].numOfCardsonTable() + " of cards on table");
            if (twoPlayHand[0].getSize() == 0) {
                System.out.println(twoPlayers[0].getName() +" have no cards on hand, GO FISH!");
                break;
            } else {
                System.out.println(twoPlayers[0].getName() +" have " + twoPlayHand[0].playerHandtoString());
            }

            // Ask player what value of card he want to get
            System.out.println("Ask for computer's card");
            System.out.println(
                    "2: Two\n3: Three\n4: Four\n5: Five\n6: Six\n7: Seven\n8: Eight\n9: Nine\n10: Ten\n11: Jack\n12: Queen\n13: King\n14: Ace");
            System.out.print("Please enter integer 2 to 14: ");

            // initialize value
            PokerCards.VALUE value = PokerCards.giveValue(2);

            // reading user input and output a PokerCard
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (2 <= input && input <= 14) {
                    value = PokerCards.giveValue(input);
                } else {
                    System.out.println("Please enter 2 to 14!");
                    continue;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Card inputed is not valid, please enter again:");
                continue;
            }

            // check if computer have the Poker Card choosen by user
            if (twoPlayHand[1].haveValue(value)) {
                System.out.println("Computer have " + value);
            }

            // if computer have the card, computer give card(s) to player and return true to continue the process
            valid = twoPlayHand[0].askCard(value, 1);

            // check if player have a set
            if (twoPlayHand[0].checkSet()) {
                System.out.println(twoPlayers[0].getName() + " have a set!");
                cardsOnTable[0].addSet(twoPlayHand[0].passSetToTable());
            }

        } while (valid);
        if (deck.numOfCard() != 0) {
            System.out.println("Go fish!");
            twoPlayHand[0].fish();
        }
    }

    // Computer logic, actions and promts
    static void aiTurn() {
        Random rand = new Random();
        boolean valid = true;
        do {
            if (cardsOnTable[0].numOfCardsonTable() != 0)
                System.out.println(twoPlayers[0].getName() + " have " + cardsOnTable[0].numOfCardsonTable() + " of cards on table");
            if (twoPlayHand[1].getSize() == 0) {
                System.out.println("Computer have no cards on hand, GO FISH!");
                break;
            } else {
                System.out.println("Computer have " + twoPlayHand[1].playerHandtoString());
            }

            // Computer's decision
            int[] record = new int[15];
            if (cardsOnTable[1].numOfCardsonTable() != 0) {
                for (int i = 0; i < cardsOnTable[1].numOfCardsonTable(); i++) {
                    record[cardsOnTable[1].getCard(i).getValue()]++;
                }
            }
            if (cardsOnTable[0].numOfCardsonTable() != 0) {
                for (int i = 0; i < cardsOnTable[0].numOfCardsonTable(); i++) {
                    record[cardsOnTable[0].getCard(i).getValue()]++;
                }
            }

            boolean repeated = false;
            int pick;
            do {
                pick = rand.nextInt(13) + 2;
                if (record[pick] == 4) {
                    repeated = true;
                } else if (record[pick] != 4) {
                    repeated = false;
                }
            } while (repeated == true);

            System.out.println("Computer asks for " + PokerCards.giveValue(pick));

            if (twoPlayHand[0].haveValue(PokerCards.giveValue(pick))) {
                System.out.println(twoPlayers[0].getName() + " have " + PokerCards.giveValue(pick));
            }

            valid = twoPlayHand[1].askCard(PokerCards.giveValue(pick), 0);

            if (twoPlayHand[1].checkSet()) {
                System.out.println("Computer have a set!");
                cardsOnTable[1].addSet(twoPlayHand[1].passSetToTable());
            }
        } while (valid);
        if (deck.numOfCard() != 0) {
            System.out.println("Computer GO FISH!");
            twoPlayHand[1].fish();
        }

    }

}// end of class
