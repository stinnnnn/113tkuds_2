import java.io.*;

public class lt_37_SudokuSolver {
    public static void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private static boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) return false;
            if (board[k][col] == c) return false;
            int boxRow = (row / 3) * 3 + k / 3;
            int boxCol = (col / 3) * 3 + k % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String[] parts = br.readLine().trim().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = parts[j].charAt(0);
            }
        }

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if (j < 8) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
