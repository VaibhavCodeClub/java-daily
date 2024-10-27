// Valid Sudoku

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

*/

import java.util.HashSet;

public class leet36 {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        }));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static boolean isValidSudoku(char[][] board) {
        HashSet seen = new HashSet();
        // Creating the hashset to store if the specific number has occured in that row
        // column of block or not
        for (int i = 0; i < 9; i++) {
            // Iterate through rows and columns
            for (int j = 0; j < 9; j++) {
                //  if there is . no need to check the conditions
                if (board[i][j] != '.') {
                    if (!seen.add("row" + i + board[i][j]) || !seen.add("column" + j + board[i][j])
                            | !seen.add("box" + (i / 3) * 3 + j / 3 + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
