//Maximum Length of Repeated Subarray
// Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

public class Leet718 {

  public static void main(String args[]) {
    System.out.print(
      findLength(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 })
    );
  }

  public static int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    int[][] dp = new int[m + 1][n + 1];

    int maxLen = 0;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          maxLen = Math.max(dp[i][j], maxLen);
        }
      }
    }
    return maxLen;
  }
}
