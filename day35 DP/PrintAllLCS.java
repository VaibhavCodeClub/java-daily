// Prints all common subsequences
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllLCS {

  public static void main(String args[]) {
    System.out.println(longestCommonSubsequences("abaaa", "baabaca"));
  }

  public static List<String> longestCommonSubsequences(String s, String t) {
    int n = s.length();
    int m = t.length();

    // Correct dp array size with n+1 and m+1 for base cases
    int[][] dp = new int[n + 1][m + 1];

    // Fill dp array
    function(n, m, s, t, dp);

    // List to store all LCS
    List<String> result = new ArrayList<>();
    // Call the helper function to find all LCSs
    findAllLCS(n, m, s, t, dp, "", result);

    return result;
  }

  private static void function(
    int ind1,
    int ind2,
    String s,
    String t,
    int[][] dp
  ) {
    // Base cases (first row or column is 0)
    for (int i = 0; i <= ind1; i++) {
      for (int j = 0; j <= ind2; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
  }

  private static void findAllLCS(
    int i,
    int j,
    String s,
    String t,
    int[][] dp,
    String currentLCS,
    List<String> result
  ) {
    // If we've reached the end of either string, store the current LCS
    if (i == 0 || j == 0) {
      String sss = new StringBuilder(currentLCS).reverse().toString();
      if (!result.contains(sss)) {
        result.add(sss);
      }
      return;
    }

    // If the characters match, move diagonally and add the character to the LCS
    if (s.charAt(i - 1) == t.charAt(j - 1)) {
      findAllLCS(i - 1, j - 1, s, t, dp, currentLCS + s.charAt(i - 1), result);
    } else {
      // If characters don't match, explore both paths (if they provide the same LCS length)
      if (dp[i - 1][j] == dp[i][j]) {
        findAllLCS(i - 1, j, s, t, dp, currentLCS, result);
      }
      if (dp[i][j - 1] == dp[i][j]) {
        findAllLCS(i, j - 1, s, t, dp, currentLCS, result);
      }
    }
  }
}
