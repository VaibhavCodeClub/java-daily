import java.util.Arrays;

public class ChocolatePickup {
  public static void main(String[] args) {
    System.out.println(maximumChocolates(3, 4, new int[][] { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } }));
  }

  public static int maximumChocolates(int n, int m, int[][] grid) {
    int[][][] dp = new int[n][m][m];
    for (int[][] is : dp) {
      for (int[] is2 : is) {
        Arrays.fill(is2, -1);
      }
    }
    return function(0, 0, m - 1, n, m, grid, dp);
  }

  private static int function(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
    if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) {
      return (int) Math.pow(-10, 9);
    }
    if (i == n - 1) {
      if (j1 == j2)
        return grid[i][j2];
      else
        return grid[i][j1] + grid[i][j2];
    }
    if (dp[i][j1][j2] != -1) {
      return dp[i][j1][j2];
    }

    int max = Integer.MIN_VALUE;
    for (int j = -1; j <= 1; j++) {
      for (int j3 = -1; j3 <= 1; j3++) {
        int value = 0;
        if (j1 == j2)
          value = grid[i][j1];
        else
          value = grid[i][j1] + grid[i][j2];
        value += function(i + 1, j1 + j, j2 + j3, n, m, grid, dp);
        max = Math.max(max, value);
      }
    }
    return dp[i][j1][j2] = max;
  }
}
