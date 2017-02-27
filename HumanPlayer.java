import java.util.Scanner;
/**
 * Write a description of class HumanPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanPlayer extends Player
{
    Scanner scan = new Scanner(System.in);
    private int x;
    /**
     * Constructor for objects of class HumanPlayer
     */
    public HumanPlayer()
    {
    }

    /**
     * This method asks player to choose and type in the column number where they would like the chip to be placed in.
     * There are 7 columns on the Connect4 board so the player must type in a valid column number ranging from
     * 1 to 7. 
     */
    public int getNextMove()
    {
        int y;
        System.out.println(this.getName() + ", where would you like to place your chip? Please enter a number from 1-7.");
        y = scan.nextInt();
        x = y-1;
        return x;
    }
   
}
