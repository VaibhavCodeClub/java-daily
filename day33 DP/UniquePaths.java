// Leet62
// Unique Paths

// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

import java.util.Arrays;

public class UniquePaths {
  public static void main(String[] args) {
    System.out.println(uniquePaths(1,1));
  }

  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    return function(m - 1, n - 1, dp);
  }

  private static int function(int i, int j, int[][] dp) {
    if (i == 0 && j == 0)
      return 1;
    if (i < 0 || j < 0)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];

    int up = function(i - 1, j, dp);
    int left = function(i, j - 1, dp);

    return dp[i][j] = up + left;
  }
}
