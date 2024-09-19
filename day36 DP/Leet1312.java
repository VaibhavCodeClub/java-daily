// Minimum Insertion Steps to Make a String Palindrome
/*
Given a string s. In one step you can insert any character at any index of the string.F
Return the minimum number of steps to make s palindrome.
A Palindrome String is one that reads the same backward as well as forward.
*/

public class Leet1312 {

  public static void main(String args[]) {
    System.out.print(longestPalindromeSubseq("leetcode"));
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
    return s.length() - dp[n][n];
  }
}
