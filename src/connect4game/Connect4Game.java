package connect4game;

import java.util.Scanner;

/*
You are required to create a text mode version of the Connect 4 game. The text mode version 
displays the board using characters (for example „x‟ for one player, „o‟ for the other player, and 
a space for an empty slot). 
The game starts by asking whether to start a 1 player game (Player vs. Computer), or a 2 
player game (Player vs. Player).
 */
public class Connect4Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to connect4");
        System.out.println("Select game type");
        System.out.println("Enter 1 for \"Player vs. Computer\"");
        System.out.println("Enter 2 for \"Player vs. Player\"");

        // user input to choose 1 or 2 mode for playing
        int mode = input.nextInt();                 //   [1] --> player vs. cpu     [2] -->  player  vs. player
        System.out.println("Starting game");
        System.out.println("");

        // declare variable ch for the character of player
        char ch;
        // make 2D array for board
        char board[][] = new char[6][7];

        // create loop variable to exit loop when there is a winner
        boolean loop = true;

        int turn = 1;

        while (loop) {

            if (turn % 2 == 1) {                                  // check if he is the first player or second
                System.out.print("Player 1:  ");
                ch = 'X';
            } else {
                System.out.print("Player 2:  ");
                ch = 'O';
            }

            // move input from player
            int move;
            if (mode == 1 && turn % 2 == 0) {
                move = 1 + (int) (Math.random() * 7); // cpu player
                System.out.println(move);
            } else {
                move = input.nextInt();     //  normal player input
                // check if  input is out of col range or not
                if (move < 1 || move > 7) {
                    System.out.println("Invalid place, play again");
                    continue;
                }
            }

            int row = 5;
            // check if player input valid in empty place in col or col became occupied
            for (int i = 5; i >= 0; i--) {
                if (board[i][move - 1] == 'X' || board[i][move - 1] == 'O') {
                    row--;
                }
            }

            // check if col full completely or not
            if (row < 0) {
                System.out.println("Invalid place, play again");
                continue;
            }

            // if valid input and there is a space
            board[row][move - 1] = ch;

            // print header of board
            for (int i = 1; i <= 7; i++) {
                System.out.print("" + i + " | ");
            }
            System.out.println("");

            // print board 
            for (row = 0; row < 6; row++) {
                System.out.print("");
                for (int col = 0; col <= 6; col++) {
                    if (board[row][col] == 'X' || board[row][col] == 'O') {
                        System.out.print(board[row][col] + " | ");
                    } else {
                        System.out.print("" + "  | ");
                    }
                }
                System.out.println("");
            }
            System.out.println("");
            turn++;   // to turn to player 2

            //check if  full board inputs    6×7=42
            if (turn > 42) {
                System.out.println("Withdraw");
                break;
            }

            // check for the horizontal matching  '4 x  -->  x x x x'   or    '4 o  -->  o o o o' to find the winner
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j <= 6; j++) {
                    if (j == 4) {
                        break;
                    }
                    if (board[i][j] == 'X'
                            && board[i][j + 1] == 'X'
                            && board[i][j + 2] == 'X'
                            && board[i][j + 3] == 'X') {
                        System.out.println("Player 1 is the Winner!");
                        loop = false;
                    } else if (board[i][j] == 'O'
                            && board[i][j + 1] == 'O'
                            && board[i][j + 2] == 'O'
                            && board[i][j + 3] == 'O') {
                        System.out.println("Player 2 is the Winner!");
                        loop = false;
                    }
                }
            }

            // check for the vertical matching  to find the winner
            for (int j = 0; j <= 6; j++) {
                for (int i = 0; i < 6; i++) {
                    if (i == 3) {
                        break;
                    }
                    if (board[i][j] == 'X'
                            && board[i + 1][j] == 'X'
                            && board[i + 2][j] == 'X'
                            && board[i + 3][j] == 'X') {
                        System.out.println("Player 1 is the Winner!");
                        loop = false;
                    } else if (board[i][j] == 'O'
                            && board[i + 1][j] == 'O'
                            && board[i + 2][j] == 'O'
                            && board[i + 3][j] == 'O') {
                        System.out.println("Player 2 is the Winner!");
                        loop = false;
                    }
                }
            }

            // check for the diagonal matching ( top left to right ) to find the winner
            // iterate through rows to row at index [2] and through columns to col at index [3]
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {

                    if (board[i][j] == 'X'
                            && board[i + 1][j + 1] == 'X'
                            && board[i + 2][j + 2] == 'X'
                            && board[i + 3][j + 3] == 'X') {
                        System.out.println("Player 1 is the Winner!");
                        loop = false;
                    } else if (board[i][j] == 'O'
                            && board[i + 1][j + 1] == 'O'
                            && board[i + 2][j + 2] == 'O'
                            && board[i + 3][j + 3] == 'O') {
                        System.out.println("Player 2 is the Winner!");
                        loop = false;
                    }
                }
            }

            // check for the diagonal matching ( top right to left ) to find the winner
            // iterate through rows to row at index [2] and through columns from col at index [6] to col at index [3]
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j > 2; j--) {

                    if (board[i][j] == 'X'
                            && board[i + 1][j - 1] == 'X'
                            && board[i + 2][j - 2] == 'X'
                            && board[i + 3][j - 3] == 'X') {
                        System.out.println("Player 1 is the Winner!");
                        loop = false;
                    } else if (board[i][j] == 'O'
                            && board[i + 1][j - 1] == 'O'
                            && board[i + 2][j - 2] == 'O'
                            && board[i + 3][j - 3] == 'O') {
                        System.out.println("Player 2 is the Winner!");
                        loop = false;
                    }
                }
            }

        }
    }

}
