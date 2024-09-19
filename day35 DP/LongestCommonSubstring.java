// You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.
// A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.
import java.util.Arrays;

public class LongestCommonSubstring {

  public static void main(String args[]) {
    System.out.print(longestCommonSubstr("abcjklp", "acjkp"));
  }

  public static int longestCommonSubstr(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();

    int[][] dp = new int[m + 1][n + 1];
    int maxLen = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          maxLen = Math.max(maxLen, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return maxLen;
  }
}
