import java.util.Scanner;

public class TicTacToe
{
	public static void main(String[] args)	//game does not prevent taking an occupied space.
	{
		int[][] board = new int[3][3];
		int player1Turn = 0;
		int player2Turn = 0;
		int moveCount = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Player 1: Enter 1 to go first, 2 to go second: ");
		if (in.nextInt() == 1)	//sets turns
		{
			player1Turn = 1;
			player2Turn = 2;
			System.out.println("Player 1 goes first and is X. Player 2 goes second and is O.");
		}
		else
		{
			player1Turn = 2;
			player2Turn = 1;
			System.out.println("Player 1 goes second and is O. Player 2 goes first and is X.");
		}
		
		boolean end = false;	// did the game end?
		int turn = 1;
		while(!end)
		{
			if(player1Turn == turn)	//p1 turn
			{
				System.out.println("It is player 1's turn. The board is shown below: ");
				printTicTacToeBoard(board);
				System.out.println("Enter the row of the position that you want to go: ");
				int row = in.nextInt();
				System.out.println("Enter the column of the position that you want to go: ");
				int column = in.nextInt();
				board[row-1][column-1] = player1Turn;
				turn = player2Turn;	//rotate between turns
			}
			else	//p2 turn
			{
				System.out.println("It is player 2's turn. The board is shown below: ");
				printTicTacToeBoard(board);
				System.out.println("Enter the row of the position that you want to go: ");
				int row = in.nextInt();
				System.out.println("Enter the column of the position that you want to go: ");
				int column = in.nextInt();
				board[row-1][column-1] = player2Turn;
				turn = player1Turn;	//rotate between turns
			}
			moveCount++;	// counts moves. to be used to determine if tie
			if (win(board))	//sees if there is 3 in a row
			{
				end = true;
				printTicTacToeBoard(board);
				if(turn == player1Turn)
				{
					System.out.println("Player 2 WON!!!");
				}
				else
				{
					System.out.println("Player 1 WON!!!");
				}
			}
			else if (moveCount == 9)	//sees if its a draw. max 9 turns.
			{
				end = true;
				printTicTacToeBoard(board);
				System.out.println("It is a DRAW!");
			}
		}
		
	}
	private static void printTicTacToeBoard(int[][] board)	//prints board
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (board[i][j] == 0)
				{
					System.out.print("   ");
				}
				else if (board[i][j] == 1)
				{
					System.out.print(" X ");
				}
				else
				{
					System.out.print(" O ");
				}
				if (j < 2)
				{
					System.out.print("|");
				}
			}
			if (i < 2)
			{
			System.out.println("\n-----------");
			}
		}
	}
	private static boolean win(int[][] board)		//checks for 3 in a row
	{
		for (int i = 0; i < 3; i++)
		{
			if (board[i][0] == board[i][1] && board[i][1]== board[i][2] && board[i][0] != 0)	//checks horizontals
			{
				return true;
			}
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0)	//checks verticals
			{
				return true;
			}
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)	//checks diagonal
		{
			return true;
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)	//checks other diagonal
		{
			return true;
		}
		return false;
	}
}
