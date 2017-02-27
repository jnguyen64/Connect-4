
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    private int lastMoveX;
    private int lastMoveY;
    private char[][] connectBoard;
    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        connectBoard = createBoard();
    }

    /**
     * This method creates the Connect4 board based on the desired number of rows and columns, which is 7 columns and 6 rows.
     */
    private static char[][] createBoard()
    {
        char[][] connectBoard = new char [6][7];
        for(int q=0; q<connectBoard.length; q++)
        {
            for(int w=0; w<connectBoard[0].length; w++)
            {
                connectBoard[q][w] = '.';
            }
        }
        return connectBoard;
    }

    /**
     * This method will make the newly created Connect4 board visbile and appear as 
     * text-based board with 7 columns and 6 rows in the Terminal window. 
     */
    public void printBoard()
    {
        
        for(int q=0; q<this.connectBoard.length; q++)
        {
            for(int w=0; w<this.connectBoard[0].length; w++)
            {
                System.out.print(this.connectBoard[q][w] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
    
    /**
     * This method will refresh the board to show the latest moves by moving the chips to the selected column that the player would 
     * like the chip to be in.
     */
    public boolean updateBoard(char chip, int move)
    {
        boolean check = false;
        for(int i=(this.connectBoard.length - 1); i>=0; i--)
        {
            if(move < 0 || move > 6)
            {
                break;
              }
            if(this.connectBoard[i][move]=='.')
            {
                lastMoveY = i;
                lastMoveX = move;
                this.connectBoard[i][move] = chip;
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * This method checks to ensure that the user isn't placing their chip in a column that is already full.
     */
    public boolean validUserInput(int playerChoice)
    {
        boolean spotCheck = false;
        if(this.connectBoard[0][playerChoice]=='.')
        {
            spotCheck = true;
        }
        return spotCheck;
    }

    /**
     * This method will look to see if there is a win after 4 chips have been placed on the board. There are 4 possible ways to win the
     * game. The first is by getting 4 in a row vertically or horizontally. This method looks at the spot of the last placed chip to simplify the checking.
     * It then checks for diagonal wins through looking for 4 chips in certain positions (pre-determined positions that are the only possible locations for diagonal
     * wins.
     */
    public boolean checkForWin(Player player)
    {
        boolean winCheck = false;
        int chipCounter = 0;
        
        for(int i =0; i<connectBoard.length; i++) //Checks for a win vertically
        {
            if (connectBoard[i][lastMoveX]==player.getChip())
            {
                chipCounter++;
               }
            else 
            {
                chipCounter = 0;
               }
            if (chipCounter >= 4)
            {
                winCheck = true;
                System.out.println(player.getName() + " wins!");
                return winCheck;
               }
           }
        chipCounter =0;
        for(int i =0; i<connectBoard[0].length; i++) //Checks for a win horizontally
        {
             if (connectBoard[lastMoveY][i]==player.getChip())
            {
                chipCounter++;
               }
            else 
            {
                chipCounter = 0;
               }
            if (chipCounter >= 4)
            {
                winCheck = true;
                 System.out.println(player.getName() + " wins!");
                return winCheck;
               }
               
           }
           chipCounter = 0;
           
        for(int x =0; x<=2; x++) //Checks for diagnoal downward to the right --->  \
        {
            for(int y =0; y<=3; y++)
            {
                if(connectBoard[x][y] == player.getChip() &&
                connectBoard[x+1][y+1] == player.getChip() &&
                connectBoard[x+2][y+2] == player.getChip() &&
                connectBoard[x+3][y+3] == player.getChip())
                {
                    winCheck = true;
                    System.out.println(player.getName() + " wins!");
                    return winCheck;
                   }
               }
           }
          
           for(int x =0; x<=2; x++) //Checks for diagonal downwards to the left ---> /
        {
            for(int y =3; y<=6; y++)
            {
                if(connectBoard[x][y] == player.getChip() &&
                connectBoard[x+1][y-1] == player.getChip() &&
                connectBoard[x+2][y-2] == player.getChip() &&
                connectBoard[x+3][y-3] == player.getChip())
                {
                    winCheck = true;
                    System.out.println(player.getName() + " wins!");
                
                    return winCheck;
                   }
               }
           }
        return winCheck;
       }
       
}
