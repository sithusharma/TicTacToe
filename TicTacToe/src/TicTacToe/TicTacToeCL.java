package TicTacToe;

import java.util.Scanner;

public class TicTacToeCL {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (true) {
            System.out.println(currentPlayer + "'s turn. Enter row (1-3) and column (1-3) separated by a space: ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                displayBoard();

                if (hasWon()) {
                    System.out.println(currentPlayer + " has won the game!");
                    break;
                } else if (isTie()) {
                    System.out.println("The game is a tie!");
                    break;
                }

                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("  1 2 3");

        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    private static boolean hasWon() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    private static boolean isTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}

