// Edit Distance

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character
*/
import java.util.Arrays;

public class Leet72 {

  public static void main(String args[]) {
    System.out.print(minDistance("intention", "execution"));
  }

  public static int minDistance(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    int[][] dp = new int[m][n];
    for (int[] arr : dp) Arrays.fill(arr, -1);

    return function(m - 1, n - 1, str1, str2, dp);
  }

  private static int function(int i, int j, String s1, String s2, int[][] dp) {
    if (j < 0) return i + 1;
    if (i < 0) return j + 1;

    if (dp[i][j] != -1) return dp[i][j];

    if (s1.charAt(i) == s2.charAt(j)) {
      return dp[i][j] = function(i - 1, j - 1, s1, s2, dp);
    }
    int insert = 1 + function(i, j - 1, s1, s2, dp);
    int remove = 1 + function(i - 1, j, s1, s2, dp);
    int replace = 1 + function(i - 1, j - 1, s1, s2, dp);

    return dp[i][j] = Math.min(insert, Math.min(remove, replace));
  }
}
