// Spiral Matrix

// Given an m x n matrix, return all elements of the matrix in spiral order.

import java.util.ArrayList;
import java.util.List;

public class leet54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        // Create an empty arraylist to return the answer
        List<Integer> retur = new ArrayList<>();

        if (matrix.length == 0)
            // If there is nothing in the input array then just return the empty one
            return retur;

        // Initialisation start the colS and rowS as 0 and colE and rowE by taking the
        // length of the 2 array and another one by taking the length on one of the
        // array form 2 d array column is the length of one single array
        int colS = 0, rowS = 0, colE = matrix[0].length - 1, rowE = matrix.length - 1;

        // loop while colS and rowS are smaller than that of colE and rowE respectively
        while (colS <= colE && rowS <= rowE) {

            // TRAVERSE RIGHT /TOP
            for (int j = colS; j <= colE; j++)
                // we are starting from the left top corner traverse to the right side by adding
                // constant row value and changing the column value
                retur.add(matrix[rowS][j]);

            // at the end increase the rowS value by one so for next iteration we will start
            // from the next row
            rowS++;

            // TRAVERSE DOWN / RHS
            for (int i = rowS; i <= rowE; i++)
                // After first column iteration we will reach to the top right corner of the
                // matrix now iterate through the rows and keep the column value contant
                retur.add(matrix[i][colE]);

            // we are done with the rightmost column now decrease the value of colE by one
            colE--;

            // TRAVERSE LEFT / BOTTOM
            if (rowS <= rowE) { // just to ensure that we are not going beyond the limits
                // we are at the right bottom corner of the matrix now you do reverse traversing
                // through the bottom row
                for (int i = colE; i >= colS; i--)
                    // keep the row value constant as rowE and decrease colE value to iterate
                    // through the whole row
                    retur.add(matrix[rowE][i]);

                // after decrease the rowE value by 1
                rowE--;
            }

            // TRAVERSE UP / LEFT
            if (colS <= colE) {
                // we are at the bottom left corner traverse to up to complete the first round
                for (int i = rowE; i >= rowS; i--)
                    // keep the column value as constant colS and iterate through rows inversly
                    retur.add(matrix[i][colS]);
                // At the end increase the colS value by 1
                colS++;
            }
        }
        return retur;
    }
}
