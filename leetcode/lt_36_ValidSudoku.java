import java.io.*;

public class lt_36_ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String line = br.readLine().trim();
            String[] parts = line.split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = parts[j].charAt(0);
            }
        }
        System.out.println(isValidSudoku(board));
    }
}
