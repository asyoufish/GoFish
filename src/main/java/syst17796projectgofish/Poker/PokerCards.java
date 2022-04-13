package syst17796projectgofish.Poker;

/**
 *
 * @author Richie Chan
 */
public class PokerCards implements Comparable<PokerCards> {

    // Empty constructor
    protected PokerCards() {
    }

    // Enum of Card Values
    public enum VALUE {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
        ACE(14);

        private int ord;

        private VALUE(int i) {
            this.ord = i;
        }

        public int getOrd() {
            return ord;
        }
    }

    private VALUE value;

    // Construct a PokerCard Object
    public PokerCards(VALUE value) {
        this.value = value;
    }

    // Return a Card.VALUE from a integer
    public static VALUE giveValue(int ord) {
        if (ord == 2)
            return VALUE.TWO;
        else if (ord == 3)
            return VALUE.THREE;
        else if (ord == 4)
            return VALUE.FOUR;
        else if (ord == 5)
            return VALUE.FIVE;
        else if (ord == 6)
            return VALUE.SIX;
        else if (ord == 7)
            return VALUE.SEVEN;
        else if (ord == 8)
            return VALUE.EIGHT;
        else if (ord == 9)
            return VALUE.NINE;
        else if (ord == 10)
            return VALUE.TEN;
        else if (ord == 11)
            return VALUE.JACK;
        else if (ord == 12)
            return VALUE.QUEEN;
        else if (ord == 13)
            return VALUE.KING;
        else if (ord == 14)
            return VALUE.ACE;
        else
            return null;
    }

    // Get the value of the PokerCard Object
    public int getValue() {
        return value.getOrd();
    }

    // Compare cards value, return 0 if the same, 1 if larger
    @Override
    public int compareTo(PokerCards o) {
        if (this.getValue() == o.getValue()) {
            return 0;
        } else if (this.getValue() > o.getValue()) {
            return 1;
        } else
            return -1;
    }

    // toString method of Card
    @Override
    public String toString() {
        return "" + value;
    }
}
