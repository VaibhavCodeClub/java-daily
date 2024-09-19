// Minimum Falling Path Sum
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

import java.util.Arrays;

public class leet931 {
  public static void main(String[] args) {
    System.out
        .println(getMaxPathSum2(new int[][] {
            { -9999, -9888, -9777, -9666, -9555 },
            { 1, 10, 2, 4, 5, },
            { -9999, -9888, -9777, -9666, -9555 },
            { 0, 0, 0, 0, 0 },
            { -99, -98, -97, -96, -95 } }));
    // System.out
    // .println(getMaxPathSum(new int[][] { { 10, 2,3},{3,7,2},{8,1,5} }));
  }

  public static int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];

    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }

    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      int ans = function(0, j, n, dp, matrix);
      min = Math.min(min, ans);
    }
    return min;
  }

  private static int function(int i, int j, int n, int[][] dp, int[][] matrix) {
    if (j < 0 || j >= n) {
      return 21474836;
    }
    if (i == n - 1)
      return matrix[i][j];
    if (dp[i][j] != -1)
      return dp[i][j];

    int down = matrix[i][j] + function(i + 1, j, n, dp, matrix);
    int right = matrix[i][j] + function(i + 1, j + 1, n, dp, matrix);
    int left = matrix[i][j] + function(i + 1, j - 1, n, dp, matrix);

    dp[i][j] = Math.min(right, Math.min(down, left));
    return dp[i][j];
  }

  private static int function2(int i, int j, int n, int m, int[][] dp, int[][] matrix) {
    if (j < 0 || j >= m) {
      return (int) Math.pow(-10, 9);
    }

    if (i == 0) {
      return matrix[i][j];
    }

    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int down = matrix[i][j] + function2(i - 1, j, n, m, dp, matrix);
    int right = matrix[i][j] + function2(i - 1, j + 1, n, m, dp, matrix);
    int left = matrix[i][j] + function2(i - 1, j - 1, n, m, dp, matrix);

    dp[i][j] = Math.max(down, Math.max(right, left));

    return dp[i][j];
  }

  public static int getMaxPathSum(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    int maxSum = Integer.MIN_VALUE;

    for (int j = 0; j < m; j++) {
      int currentSum = function2(n - 1, j, n, m, dp, matrix);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }

  // Tabulation goes below for TLEs

  public static int getMaxPathSum2(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;

    int[][] dp = new int[n][m];
    for (int i = 0; i < m; i++) {
      dp[0][i] = matrix[0][i];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int up = matrix[i][j] + dp[i - 1][j];
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        if (j > 0)
          left = matrix[i][j] + dp[i - 1][j - 1];
        if (j < m - 1)
          right = matrix[i][j] + dp[i - 1][j + 1];

        dp[i][j] = Math.max(left, Math.max(up, right));
      }
    }
    int ans = dp[n - 1][0];
    for (int i = 1; i < m; i++) {
      ans = Math.max(ans, dp[n - 1][i]);
    }
    return ans;
  }
  // Tabulation for min path
  
  public static int minFallingPathSum2(int[][] matrix) {
    int n = matrix.length;

    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int up = matrix[i][j] + dp[i - 1][j];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (j > 0)
          left = matrix[i][j] + dp[i - 1][j - 1];
        if (j < n - 1)
          right = matrix[i][j] + dp[i - 1][j + 1];

        dp[i][j] = Math.min(left, Math.min(up, right));
      }
    }
    int ans = dp[n - 1][0];
    for (int i = 1; i < n; i++) {
      ans = Math.min(ans, dp[n - 1][i]);
    }
    return ans;
  }
}
