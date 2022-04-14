package syst17796projectgofish.Player;

/**
 *
 * @author Joanna He
 */
public class Players {

    // identify players by name attribute
    protected String name;

    // constructor
    protected Players() {
        this.name = "";
    }

    public Players(String name) {
        this.name = name;
    }

    // get name
    public String getName() {
        return name;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    // output player name
    @Override
    public String toString() {
        return "Player Name:" + name;
    }
}