package backtracking;

public class SudokuSolver {
    private boolean solveSudoku(int[][] board) {
        return canBeSolved(board, 0, 0);
    }

    private boolean canBeSolved(int[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        if (col == board[row].length) {
            return canBeSolved(board, row + 1, 0);
        }
        if (board[row][col] != 0) {
            return canBeSolved(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (isValidNumber(board, row, col, i)) {
                board[row][col] = i;
                if (canBeSolved(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValidNumber(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        int subGridRow = (row / 3) * 3;
        int subGridCol = (col / 3) * 3;
        for (int i = subGridRow; i < subGridRow + 3; i++) {
            for (int j = subGridCol; j < subGridCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (new SudokuSolver().solveSudoku(board)) {
            System.out.println("Sudoku solved successfully:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
