// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

import java.util.Arrays;

public class HouseRobber2 {
  public static void main(String[] args) {
    System.out.println(houseRobber(new int[] { 2, 3, 2 }));
    System.out.println(rob(new int[] { 2, 3, 2 }));
  }

  private static long function(int[] nums, long[] dp, int index) {
    if (index == 0)
      return nums[index];
    if (index < 0)
      return 0;

    if (dp[index] != -1)
      return dp[index];
    long left = nums[index] + function(nums, dp, index - 2);
    long right = 0 + function(nums, dp, index - 1);

    return dp[index] = Math.max(left, right);
  }

  public static long houseRobber(int[] valueInHouse) {
    int n = valueInHouse.length;
    if (n == 1)
      return valueInHouse[0];
    if (n == 2)
      return Math.max(valueInHouse[0], valueInHouse[1]);

    int[] temp1 = Arrays.copyOfRange(valueInHouse, 0, n - 1);
    long[] dp1 = new long[temp1.length];
    Arrays.fill(dp1, -1);
    long max1 = function(temp1, dp1, temp1.length - 1);

    int[] temp2 = Arrays.copyOfRange(valueInHouse, 1, n);
    long[] dp2 = new long[temp2.length];
    Arrays.fill(dp2, -1);
    long max2 = function(temp2, dp2, temp2.length - 1);

    return Math.max(max1, max2);
  }

  private static int function2(int[] nums, int[] dp, int index) {
    if (index == 0)
      return nums[index];
    if (index < 0)
      return 0;

    if (dp[index] != -1)
      return dp[index];
    int left = nums[index] + function2(nums, dp, index - 2);
    int right = 0 + function2(nums, dp, index - 1);

    return dp[index] = Math.max(left, right);
  }

  public static int rob(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return nums[0];
    if (n == 2)
      return Math.max(nums[0], nums[1]);

    int[] temp1 = Arrays.copyOfRange(nums, 0, n - 1);
    int[] dp1 = new int[temp1.length];
    Arrays.fill(dp1, -1);
    int max1 = function2(temp1, dp1, temp1.length - 1);

    int[] temp2 = Arrays.copyOfRange(nums, 1, n);
    int[] dp2 = new int[temp2.length];
    Arrays.fill(dp2, -1);
    int max2 = function2(temp2, dp2, temp2.length - 1);

    return Math.max(max1, max2);
  }
}
