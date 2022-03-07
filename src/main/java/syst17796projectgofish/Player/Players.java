package syst17796projectgofish.Player;

/**
 *
 * @author Joanna He
 */
public class Players{
    //identify players by name attribute
    private String name;
    
    //constructor
    public Players(){
        this.name="";
    }
    
    
    public Players(String name){
        this.name=name;
       }
    
    //getter
    public String getName(){
        return name;
    }
    //setter
    public void setName(String name){
        this.name= name;
    }
    
    //output player name
    @Override
    public String toString(){
        return "Player Name:"+name;
    }
}