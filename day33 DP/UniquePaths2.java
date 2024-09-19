// leet63
// Unique Paths II
/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths2 {
  public static void main(String[] args) {
    System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
    System.out.println(mazeObstacles(3, 3, new ArrayList<ArrayList<Integer>>() {
      {
        add(new ArrayList<Integer>() {
          {
            add(0);
            add(0);
            add(0);
          }
        });
        add(new ArrayList<Integer>() {
          {
            add(0);
            add(-1);
            add(-1);
          }
        });
        add(new ArrayList<Integer>() {
          {
            add(0);
            add(0);
            add(0);
          }
        });
      }
    }));
  }

  private static int function(int i, int j, int[][] dp, int[][] obstacleGrid) {
    if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1)
      return 0;
    if (i == 0 && j == 0)
      return 1;
    if (i < 0 || j < 0)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];

    int up = function(i - 1, j, dp, obstacleGrid);
    int left = function(i, j - 1, dp, obstacleGrid);

    return dp[i][j] = up + left;
  }

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    return function(m - 1, n - 1, dp, obstacleGrid);
  }

  private static final int MOD = 1000000007;

  private static int function2(int i, int j, int[][] dp, ArrayList<ArrayList<Integer>> mat) {
    if (i >= 0 && j >= 0 && mat.get(i).get(j) == -1)
      return 0;
    if (i == 0 && j == 0)
      return 1;
    if (i < 0 || j < 0)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];

    int up = function2(i - 1, j, dp, mat);
    int left = function2(i, j - 1, dp, mat);

    return dp[i][j] = (up + left) % MOD;
  }

  static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
    int[][] dp = new int[n][m];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    return function2(n - 1, m - 1, dp, mat);
  }
}
