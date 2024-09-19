// Distinct Subsequences

// Given two strings s and t, return the number of distinct subsequences of s which equals t.
// The test cases are generated so that the answer fits on a 32-bit signed integer.
import java.util.Arrays;

public class Leet115 {

  private static int MOD = (int) Math.pow(10, 9) + 7;

  public static void main(String args[]) {
    System.out.print(numDistinct("babgbag", "bag"));
  }

  public static int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();

    int[][] dp = new int[m + 1][n + 1];
    for (int[] arr : dp) Arrays.fill(arr, -1);

    return function(m, n, s, t, dp);
  }

  private static int function(int i, int j, String s, String t, int[][] dp) {
    if (j == 0) return 1;
    if (i == 0) return 0;

    if (dp[i][j] != -1) return dp[i][j];

    if (s.charAt(i - 1) == t.charAt(j - 1)) return (
      dp[i][j] = ((function(i - 1, j - 1, s, t, dp) % MOD) +
        (function(i - 1, j, s, t, dp) % MOD)) %
      MOD
    );
    else return dp[i][j] = function(i - 1, j, s, t, dp) % MOD;
  }
}
