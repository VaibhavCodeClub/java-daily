/*
Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost associated with it.


Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the numbers along the path. You need to tell the minimum sum of that path.


Note:

You can only move down or right at any point in time.


 */

import java.util.Arrays;

public class MinPathSum {
  public static void main(String[] args) {
    System.out.println(minSumPath(new int[][] { { 8, 1, 6 }, { 4, 4, 16 }, { 2, 7, 20 }, { 20, 7, 20 } }));
  }

  public static int minSumPath(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    return function(grid, m - 1, n - 1, dp);
  }

  private static int function(int[][] grid, int i, int j, int[][] dp) {
    if (i == 0 && j == 0)
      return grid[0][0];

    if (dp[i][j] != -1)
      return dp[i][j];

    int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
    if (i >= 1)
      top = grid[i][j] + function(grid, i - 1, j, dp);
    if (j >= 1)
      left = grid[i][j] + function(grid, i, j - 1, dp);

    return dp[i][j] = Math.min(top, left);
  }
}
