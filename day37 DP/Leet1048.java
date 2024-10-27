// Longest String Chain
import java.util.Arrays;
import java.util.Comparator;

public class Leet1048 {

  public static void main(String args[]) {
    System.out.print(
      longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" })
    );
  }

  private static boolean checkPossibility(String s1, String s2) {
    if (s1.length() != s2.length() + 1) return false;
    int first = 0, second = 0;
    while (first < s1.length()) {
      if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
        second++;
      }
      first++;
    }
    return second == s2.length();
  }

  public static int longestStrChain(String[] words) {
    int n = words.length;
    Arrays.sort(words, Comparator.comparingInt(String::length));
    int[] dp = new int[n];

    int max = 1;
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; i++) {
      for (int prev = 0; prev < i; prev++) if (
        checkPossibility(words[i], words[prev]) && 1 + dp[prev] > dp[i]
      ) {
        dp[i] = 1 + dp[prev];
      }
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return max;
  }
}
