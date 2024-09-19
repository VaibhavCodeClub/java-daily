// Partition Array Into Two Arrays to Minimize Sum Difference
// You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.

// Return the minimum possible absolute difference.

public class leet2035 {
  public static void main(String[] args) {
    System.out.println(minimumDifference(new int[] { -36, 36 }));
  }

  public static int minimumDifference(int[] arr) {
    int totSum = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      totSum += arr[i];
    }

    boolean[][] dp = new boolean[n][totSum + 1];

    for (int i = 0; i <= totSum; i++) {
      dp[0][i] = (i == arr[0]);
    }

    for (int ind = 1; ind < n; ind++) {
      for (int target = 0; target <= totSum; target++) {
        boolean notTaken = dp[ind - 1][target];

        boolean taken = false;
        if (arr[ind] <= target) {
          taken = dp[ind - 1][target - arr[ind]];
        }

        dp[ind][target] = notTaken || taken;
      }
    }

    int mini = 0;

    for (int i = 0; i <= totSum; i++) {
      if (dp[n - 1][i]) {
        int diff = Math.abs(i - (totSum - i));
        mini = Math.min(mini, diff);
      }
    }
    return mini;
  }
}
