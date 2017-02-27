import java.util.Scanner;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    private int x;
    private boolean comp = false;
    Scanner scan = new Scanner(System.in);
    private Board board;
    private HumanPlayer player1;
    private HumanPlayer player2;
    private ComputerPlayer playerComp;



    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        x = 0;
    }

    /**
     * This method allows the player to play the game of Connect4. It will create a new, visible board and ask the player if they want to play with a computer
     * or not. If they do, the game will ask the player to enter their name and then ask for their move and then the computer's move. It will go back and 
     * forth until the player or computer gets 4 chips in a row in vertical, horiztonal, or diagonal direction.
     * 
     * If the player wants to play with another Human player, the game will ask for the first player to enter their name and then the second player to enter
     * their name too. After that, each player takes turn in placing their chip into the Connect4 board. The game will be over when one of the two Human
     * players is first to reach 4 chips in a row, horizontally, vertically, or diagonally.
     */


    public void play()
    {
        comp = compCheck();
        board = new Board();
        
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
        playerComp = new ComputerPlayer();
        boolean gameContinue = true;
        int currentMove = 0;
        player1.setChip('1');
        player2.setChip('2');
        playerComp.setChip('2');
        System.out.println("Player 1, please enter your name.");
        String player1Name = scan.nextLine();
        player1.setName(player1Name);
        playerComp.setName("Computer");
        
        if(comp==false)
        {
        System.out.println("Player 2, please enter your name.");
        String player2Name = scan.nextLine();
        player2.setName(player2Name);
        board.printBoard();
        }
        while(gameContinue )
        {
            while(!board.updateBoard(player1.getChip(), (currentMove = player1.getNextMove())))
            {
                System.out.println("Invalid move");
            }
            
            board.printBoard();
            if(board.checkForWin(player1))
            {
                break;
            }
            if(comp==false)
            {
                while(!board.updateBoard(player2.getChip(), (currentMove = player2.getNextMove())))
                {
                    System.out.println("Invalid move");
                }
                board.printBoard();
                if(board.checkForWin(player2))
                {
                    break;
                }
            }
            else
            {
                playerComp.easyComputerMove(board);
                board.printBoard();
                if(board.checkForWin(playerComp))
                {
                    break;
                }
            }

        
        }
    }

    /**
     * This method is evoked when the Human player starts the game. The Human player has a choice of either playing or not playing with a computer player. 
     * If the Human player chooses "N", it will create a game between two Human Players. If the Human player chooses "Y", it will create a game between the 
     * Human Player and computer player. In addition, if the Human player enters in some other response than "Y" or "N", the game will not understand the
     * response and will ask the Human player to enter in the correct response ("Y" or "N"). If the response is "Y", the computer player mechanics will 
     * take place of the second Human Player.
     */
    public boolean compCheck()
    {
        boolean comp = false;
        System.out.println("Would you like to play against a computer? (Y/N)");
        String compCheck = scan.nextLine();
        while(!(compCheck.equals("Y")) && !(compCheck.equals("N")))
        {
            System.out.println("Invalid response. Please enter either Y or N");
            compCheck = scan.nextLine();
          }
        if(compCheck.equals("Y"))
        {
            comp = true;
        }
        return comp;
    }



}
