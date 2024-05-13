// Largest Local Values in a Matrix
/*
You are given an n x n integer matrix grid.

Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

    maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.

In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

Return the generated matrix.
 */

import java.util.Arrays;

public class leet2373 {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(largestLocal(new int[][] { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } })));
  }

  public static int[][] largestLocal(int[][] grid) {
    int n = grid.length;
    int maxLocal[][] = new int[n - 2][n - 2];
    for (int i = 0; i < n - 2; i++)
      for (int j = 0; j < n - 2; j++)
        maxLocal[i][j] = findMax(grid, i, j);
    return maxLocal;
  }

  public static int findMax(int[][] grid, int row, int col) {
    int max = 0;
    for (int i = row; i <= row + 2; i++)
      for (int j = col; j <= col + 2; j++)
        max = max > grid[i][j] ? max : grid[i][j];
    return max;
  }
}
