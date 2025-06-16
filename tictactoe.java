import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = ' ';
            }
        }

        char player = 'X';
        boolean gameover = false;
        Scanner game = new Scanner(System.in);

        while (!gameover) {
            printBoard(board);
            System.out.println("Player " + player + ", your turn (enter row and column):");
            int x = game.nextInt();
            int y = game.nextInt();

            if (x < 0 || x > 2 || y < 0 || y > 2 || board[x][y] != ' ') {
                System.out.println("Invalid Move, Try again!");
                continue;
            }

            board[x][y] = player;
            gameover = haveWon(board, player);

            if (gameover) {
                printBoard(board);
                System.out.println("Player " + player + " has Won!");
            } else {
                player = (player == 'X') ? 'O' : 'X';
            }
        }

        game.close();
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column]);
                if (column < 2) System.out.print(" | ");
            }
            System.out.println();
            if (row < 2) System.out.println("---------");
        }
    }

    public static boolean haveWon(char[][] board, char player) {
    
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
