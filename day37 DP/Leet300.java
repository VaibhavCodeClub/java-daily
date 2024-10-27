// Longest Increasing Subsequence
/*
For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.

Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
For example:
[1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leet300 {

  public static void main(String args[]) {
    System.out.println(
      lengthOfLIS(new int[] { 4, 2, 1, 4, 3, 4, 5, 8, 15 }, 3)
    );
    System.out.println(
      lengthOfLIS1(
        new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 }
      )
    );
    System.out.println(lengthOfLIS2(new int[] { 1, 2, 2 }));
    System.out.println(lengthOfLIS3(new int[] { 1, 2, 2 }));
    System.out.println(printLIS(new int[] { 1, 2, 2 }));
  }

  public static int lengthOfLIS(int[] nums, int k) {
    int n = nums.length;
    int[][] dp = new int[n][n + 1];

    for (int[] arr : dp) Arrays.fill(arr, -1);
    return function(0, -1, k, nums, dp);
  }

  private static int function(
    int index,
    int prev,
    int k,
    int[] arr,
    int[][] dp
  ) {
    if (index >= arr.length) return 0;

    if (dp[index][prev + 1] != -1) return dp[index][prev + 1];

    int notPick = function(index + 1, prev, k, arr, dp);
    int pick = 0;
    if (prev == -1 || (arr[index] > arr[prev] && arr[index] - arr[prev] <= k)) {
      pick = 1 + function(index + 1, index, k, arr, dp);
    }
    return dp[index][prev + 1] = Math.max(pick, notPick);
  }

  // Binary search approach

  public static int lengthOfLIS1(int[] nums) {
    List<Integer> lis = new ArrayList<>();

    for (int num : nums) {
      int pos = Collections.binarySearch(lis, num);

      if (pos < 0) pos = -(pos + 1);

      if (pos == lis.size()) {
        lis.add(num);
      } else {
        lis.set(pos, num);
      }
    }
    System.out.print(lis);
    return lis.size();
  }

  // Tabulation approach
  public static int lengthOfLIS2(int[] nums) {
    int n = nums.length;
    int dp[][] = new int[n + 1][n + 1];

    for (int ind = n - 1; ind >= 0; ind--) for (
      int prev = ind - 1;
      prev >= -1;
      prev--
    ) {
      int len = dp[ind + 1][prev + 1];
      if (prev == -1 || nums[ind] > nums[prev]) len = Math.max(
        len,
        1 + dp[ind + 1][ind + 1]
      );
      dp[ind][prev + 1] = len;
    }
    return dp[0][0];
  }

  // Space optimisation approach
  public static int lengthOfLIS3(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];

    Arrays.fill(dp, 1);
    int ans = 1;
    for (int i = 0; i < n; i++) {
      for (int prev = 0; prev < i; prev++) if (arr[prev] < arr[i]) dp[i] =
        Math.max(dp[i], 1 + dp[prev]);
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  public static ArrayList<Integer> printLIS(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];
    int[] hash = new int[n];
    int lastIndex = 0;
    Arrays.fill(dp, 1);
    int ans = 1;
    for (int i = 0; i < n; i++) {
      hash[i] = i;
      for (int prev = 0; prev < i; prev++) if (
        arr[prev] < arr[i] && 1 + dp[prev] > dp[i]
      ) {
        dp[i] = 1 + dp[prev];
        hash[i] = prev;
      }
      if (dp[i] > ans) {
        ans = dp[i];
        lastIndex = i;
      }
    }

    ArrayList<Integer> lis = new ArrayList<>();
    lis.add(arr[lastIndex]);
    //int indx = 1;
    while (hash[lastIndex] != lastIndex) {
      lastIndex = hash[lastIndex];
      lis.add(arr[lastIndex]);
    }
    Collections.reverse(lis);
    return lis;
  }
}
