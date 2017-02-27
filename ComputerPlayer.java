import java.util.Random;
/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer extends Player
{
    // instance variables - replace the example below with your own
    private int x;
    private Random r;
    /**
     * Constructor for objects of class Computer
     */
    public ComputerPlayer()
    {
        x = 0;
    }

    /**
     * This method allows the computer to see the see what the Human player's last move was before the computer
     * goes to place their chip in the Connect4 board.
     */
    public int getLastEnemyMove(Player player)
    {
        int lastEnemyMove = player.getLastMove();
        
        return lastEnemyMove;
    }
  
    /**
     * The computer player's move is completely randomized and will be placed on the board based on a random
     * generator that picks one of the 7 columns to drop its chip.
     */
    public int randomMove()
    {
        r = new Random();
        x = r.nextInt(7);
        return x;
    }
    
    /**
     * This method will make sure that the computer player makes a valid move based its random-generated decision.
     * In addition, it will display a message that tells the player which column they placed the chip.
     */
    public void easyComputerMove(Board board){
    int i;
    boolean validCheck;
    i = randomMove();
    while(!(board.validUserInput(i)))
    {
        i = randomMove();
    }
    board.updateBoard(this.getChip(), i);
    System.out.println("I placed my token in column " + (i+1));
    
    
   }
}
