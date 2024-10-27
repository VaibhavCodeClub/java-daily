// Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

public class leet73 {
    public static void main(String[] args) {
        setZeroes(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });
    }

    public static void setZeroes(int[][] matrix) {
        // Declarations
        // col0 is defined to see if the first column contains 0 or not to avoid error
        // of being everything 0
        // rows and colums is length and width of that 2d array
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // iterate through the array by column
            if (matrix[i][0] == 0)
                // if at any point the first column contains 0 then make col0 as 0
                col0 = 0;
            for (int j = 1; j < cols; j++)
                // iterate through through each row
                if (matrix[i][j] == 0)
                    // if the current element is 0
                    // then make the corresponding row value and column value 0
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            // traverse inversly through the array
            for (int j = cols - 1; j >= 1; j--)
                // if at any point row or array value is 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    // then just make that value too 0
                    matrix[i][j] = 0;
            if (col0 == 0)
                // if the col0 value is 0 make the first element of each column too 0
                matrix[i][0] = 0;

        }
    }
}
