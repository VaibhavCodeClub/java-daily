// Longest Palindromic Subsequence
// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
//

public class Leet516 {

  public static void main(String args[]) {
    System.out.print(longestPalindromeSubseq("bbabcbcab"));
  }

  public static int longestPalindromeSubseq(String s) {
    String s2 = new StringBuffer(s).reverse().toString();
    int n = s.length();

    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][n];
  }
}
