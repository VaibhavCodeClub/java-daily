// Strange Printer
/*
There is a strange printer with the following two special properties:

    The printer can only print a sequence of the same character each time.
    At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.

Given a string s, return the minimum number of turns the printer needed to print it.
 */

import java.util.Arrays;

public class leet664 {
  public static void main(String[] args) {
    System.out.println(strangePrinter("aabb"));
  }

  public static int strangePrinter(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    return function(0, n - 1, s, dp);
  }

  private static int function(int i, int j, String s, int[][] dp) {
    if (i == j)
      return 1;
    if (dp[i][j] != -1)
      return dp[i][j];

    int minTurns = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      minTurns = Math.min(minTurns, function(i, k, s, dp) + function(k + 1, j, s, dp));
    }

    return dp[i][j] = s.charAt(i) == s.charAt(j) ? minTurns - 1 : minTurns;
  }
}
