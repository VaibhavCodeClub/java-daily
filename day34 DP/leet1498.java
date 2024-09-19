// Number of Subsequences That Satisfy the Given Sum Condition
// You are given an array of integers nums and an integer target.

// Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 10^9 + 7.

import java.util.Arrays;

public class leet1498 {
  public static void main(String[] args) {
    System.out.println(numSubseq(new int[] { 9, 7, 0, 3, 9, 8, 6, 5, 7, 6 }, 31));
  }

  public static int MOD = (int) Math.pow(10, 9) + 7;

  public static int numSubseq(int[] nums, int target) {

    int n = nums.length;
    int[][] dp = new int[n][target + 1];

    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    return function(n - 1, target, nums, dp) % MOD;
  }

  private static int function(int index, int target, int[] nums, int[][] dp) {
    if (target == 0)
      return 1;
    if (index == 0)
      return nums[index] == target ? 1 : 0;
    if (dp[index][target] != -1)
      return dp[index][target];

    int notPick = function(index - 1, target, nums, dp);
    int pick = 0;

    if (nums[index] <= target)
      pick = function(index - 1, target - nums[index], nums, dp);
    return dp[index][target] = pick + notPick;
  }
}
