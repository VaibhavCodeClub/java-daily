// Longest Common Subsequence
/*
Prints any one of the longest common subsequence
*/import java.util.Arrays;

public class PrintLCS {

  public static void main(String args[]) {
    longestCommonSubsequence("abcde", "ace");
  }

  public static void longestCommonSubsequence(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Correct dp array size with n+1 and m+1 for base cases
    int[][] dp = new int[n + 1][m + 1];
    for (int[] arr : dp) Arrays.fill(arr, -1);

    // Fill dp array
    function(n, m, s1, s2, dp);

    // The length of the LCS
    int len = dp[n][m];

    // Print the LCS
    int i = n;
    int j = m;
    StringBuilder str2 = new StringBuilder();

    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        str2.append(s1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    System.out.println(str2.reverse().toString());
  }

  private static void function(
    int ind1,
    int ind2,
    String s1,
    String s2,
    int[][] dp
  ) {
    // Base cases (first row or column is 0)
    for (int i = 0; i <= ind1; i++) {
      for (int j = 0; j <= ind2; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
  }
}
