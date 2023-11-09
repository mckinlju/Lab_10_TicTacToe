import java.util.Scanner;

public class Main
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean playAgain = false;
        String goAgain = "";
        boolean gameEnd;
        int rowMove = 0;
        int colMove = 0;
        boolean validMove;


        do
        {
            clearBoard();
            gameEnd = false;
            while (!gameEnd)
            {
                displayBoard();
                do {
                    rowMove = SafeInput.getRangedInt(in, "Enter the row in which you would like to play: ", 1, ROW) - 1;
                    colMove = SafeInput.getRangedInt(in, "Enter the column in which you would like to play: ", 1, COL) - 1;
                    validMove = isValidMove(rowMove, colMove);
                    if (!validMove) {
                        System.out.println("That is not a valid move. Give it another go!");
                    }
                } while (!validMove);

                makeMove(rowMove, colMove);
                gameEnd = isWin(currentPlayer);
                if (!gameEnd) {
                    if (isTie())
                    {
                        gameEnd = true;
                        displayBoard();
                        System.out.println("The game ended in a tie!");
                    }else {
                        switchPlayer();
                    }
                }else {
                    displayBoard();
                    System.out.println("Congratulations, player " + currentPlayer + " wins!");
                    break;
                }
            }
            goAgain = String.valueOf(SafeInput.getYNConfirm(in, "Would you like to play again y/n? "));
            if (goAgain == "Y")
            {
                playAgain = true;
            }
        }while (!playAgain);

    }


    private static void clearBoard()
    {
        for (int r = 0; r < ROW; r++)
        {
            for (int c = 0; c < COL; c++ )
            {
                board[r][c] = " ";
            }
        }
    }

    private static void displayBoard()
    {
        for (int r = 0; r < ROW; r++)
        {
            for (int c = 0; c < COL; c++)
            {
                System.out.print(board[r][c]);
                if (c < COL -1)
                {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(r < ROW -1)
            {
                System.out.println("----");
            }
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    private static void makeMove(int row, int col)
    {
        board[row][col] = currentPlayer;
    }

    private static boolean isWin(String player)
    {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player)
    {
        for(int c = 0; c < COL; c++)
        {
            if (board[0][c].equals(player) && board[1][c].equals(player) && board[2][c].equals(player))
            {
                return true;
            }
        }
        return false;
    }


    private static boolean isRowWin(String player)
    {
        for(int r = 0; r < ROW; r++)
        {
            if (board[r][0].equals(player) && board[r][1].equals(player) && board[r][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) | (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie()
    {
        for (int r = 0; r < ROW; r++)
        {
            for (int c = 0; c < COL; c++ )
            {
                if(board[r][c].equals(" "))
                {
                    return false;
                }
            }
        }
        return !isWin("X") && !isWin("O");
    }

    private static void switchPlayer()
    {
        if (currentPlayer.equals("X" ))
        {
            currentPlayer = "O";
        } else
        {
            currentPlayer = "X";
        }
    }
}