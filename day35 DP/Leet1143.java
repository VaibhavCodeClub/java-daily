// Longest Common Subsequence
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
    For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/
import java.util.Arrays;

public class Leet1143 {

  public static void main(String args[]) {
    System.out.println(longestCommonSubsequence("abcde", "ace"));
    System.out.print(longestCommonSubsequence1("sea", "eat"));
  }

  public static int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()][text2.length()];
    for (int[] arr : dp) Arrays.fill(arr, -1);
    return function(text1.length() - 1, text2.length() - 1, text1, text2, dp);
  }

  private static int function(
    int ind1,
    int ind2,
    String text1,
    String text2,
    int[][] dp
  ) {
    if (ind1 < 0 || ind2 < 0) return 0;
    if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

    if (text1.charAt(ind1) == text2.charAt(ind2)) return (
      dp[ind1][ind2] = 1 + function(ind1 - 1, ind2 - 1, text1, text2, dp)
    );
    else return (
      dp[ind1][ind2] = Math.max(
        function(ind1 - 1, ind2, text1, text2, dp),
        function(ind1, ind2 - 1, text1, text2, dp)
      )
    );
  }

  // Tabulation approach to reduce stack space for recursive function call
  public static int longestCommonSubsequence1(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }
}
