package syst17796projectgofish.Poker;

/**
 *
 * @author Richie Chan
 */
public class PokerCards implements Comparable<PokerCards> {
    
    //Empty constructor
    protected PokerCards(){}

    //Enum of Card Values
    protected enum VALUE {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private int ord;
        private VALUE(int i){
            this.ord = i;
        }
        public int getOrd(){
            return ord;
        }
    }

    //Enum of Card Suits
    protected enum SUIT {CLUB, DIAMOND, HEARTS, SPADE}

    private VALUE value;
    private SUIT suit;

    //Construct a PokerCard Object
    public PokerCards(VALUE value, SUIT suit){
        this.value = value;
        this.suit = suit;
    }

    //Get the value of the PokerCard Object
    protected int getValue() {
        return value.getOrd();
    }
    protected void setValue(VALUE value) {
        this.value = value;
    }
    protected SUIT getSuit() {
        return suit;
    }
    protected void setSuit(SUIT suit) {
        this.suit = suit;
    }

    //Compare cards value, return 0 if the same, 1 if larger
    @Override
    public int compareTo(PokerCards o) {
        if(this.getValue() == o.getValue()){
            return 0;
        }
        else if(this.getValue() > o.getValue()) {
            return 1;
        }
        else
            return -1;
    }

    //toString method of Card
    @Override
    public String toString() {
        return suit + " OF " + value;
    }
}
