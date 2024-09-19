// Target Sum
/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".

Return the number of different expressions that you can build, which evaluates to target.

Constraints:
    1 <= nums.length <= 20
    0 <= nums[i] <= 1000
    0 <= sum(nums[i]) <= 1000
    -1000 <= target <= 1000

 */

import java.util.Arrays;

public class Leet494 {
  public static void main(String[] args) {
    System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
  }

  private static int function(int index, int target, int[] nums, int offset, int[][] dp) {
    if (index == 0) {
      if (target == offset && nums[0] == 0)
        return 2;
      if (target == offset || target == nums[0] + offset)
        return 1;
      return 0;
    }
    if (dp[index][target] != -1)
      return dp[index][target];

    int notPick = function(index - 1, target, nums, offset, dp);
    int pick = 0;

    if (target >= nums[index] + offset) {
      pick = function(index - 1, target - nums[index], nums, offset, dp);
    }
    return dp[index][target] = (pick + notPick);
  }

  public static int countPartitions(int n, int d, int[] arr) {
    int totSum = 0;
    for (int i : arr) {
      totSum += i;
    }

    if (totSum < Math.abs(d) || (totSum + d) % 2 != 0) {
      return 0;
    }

    int target = (totSum + d) / 2;
    int offset = totSum;
    int[][] dp = new int[n][2 * totSum + 1];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }

    return function(n - 1, target + offset, arr, offset, dp);
  }

  public static int findTargetSumWays(int[] nums, int target) {
    return countPartitions(nums.length, target, nums);
  }
}
