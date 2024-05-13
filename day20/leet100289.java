import java.util.Arrays;

public class leet100289 {
  int[] dp = new int[1002];

  public int minimumSubstringsInPartition(String s) {
      Arrays.fill(dp, -1);
      return F(s.length() - 1, s);
  }

  private int F(int i, String s) {
      if (i < 0) return 0;
      if (dp[i] != -1) return dp[i];

      int[] freq = new int[26];
      int ans = 5005;

      for (int j = i; j >= 0; j--) {
          freq[s.charAt(j) - 'a'] += 1;
          int maxi = -1, mini = 5005;
          for (int k = 0; k < 26; k++) {
              if (freq[k] != 0) {
                  mini = Math.min(mini, freq[k]);
                  maxi = Math.max(maxi, freq[k]);
              }
          }
          if (mini == maxi) {
              ans = Math.min(ans, 1 + F(j - 1, s));
          }
      }

      return dp[i] = ans;
  }

  public static void main(String[] args) {
      leet100289 solution = new leet100289();
      System.out.println(solution.minimumSubstringsInPartition("fabccddg")); // Output: 3
      System.out.println(solution.minimumSubstringsInPartition("abababaccddb")); // Output: 2
  }
}
