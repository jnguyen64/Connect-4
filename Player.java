import java.util.Scanner;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int x;
    protected String playerName;
    private char playerChip;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        x = 0;
    }
    
    /**
     * This method will show the player's last move on the board.
     */
    public int getLastMove()
    {
        return x;
    }
    
    /**
     * This method will assign the chips to the player.
     */
    public void setChip(char chip)
    {
        playerChip = chip;
    }
    
    /**
     * This method will return the player's chips.
     */
    public char getChip()
    {
        return playerChip;
    }
    
    /**
     * This method will set the name of the player once they type it in and enter it in.
     */
    public void setName(String name)
    {
        playerName = name;
    }
    
    /**
     * This method will return the player's name if evoked. 
     */
    public String getName()
    {
        return playerName;
    }
}
