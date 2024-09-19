// Wildcard Matching
/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
*/
import java.util.Arrays;

public class Leet44 {

  public static void main(String args[]) {
    System.out.print(isMatch("ge?ks*", "geeksforgeeks"));
  }

  public static boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();

    Boolean[][] dp = new Boolean[m][n];
    for (Boolean[] arr : dp) Arrays.fill(arr, null);

    return funct(m - 1, n - 1, s, p, dp);
  }

  private static boolean funct(
    int i,
    int j,
    String s1,
    String s2,
    Boolean[][] dp
  ) {
    if (i < 0 && j < 0) return true;
    if (i < 0) return false;
    if (j < 0) {
      for (int a = 0; a <= i; a++) if (s1.charAt(a) != '*') return false;
      return true;
    }
    if (dp[i][j] != null) return dp[i][j];

    if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') return (
      dp[i][j] = funct(i - 1, j - 1, s1, s2, dp)
    );
    if (s1.charAt(i) == '*') return (
      dp[i][j] = funct(i - 1, j, s1, s2, dp) || funct(i, j - 1, s1, s2, dp)
    );
    return false;
  }
}
