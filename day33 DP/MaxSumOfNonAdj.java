/*
 * You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.
Note:

A subsequence of an array/list is obtained by deleting some number of elements (can be zero) from the array/list, leaving the remaining elements in their original order.

 */

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumOfNonAdj {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(1);
    list.add(3);
    list.add(5);
    list.add(8);
    list.add(1);
    list.add(9);
    System.out.println(maximumNonAdjacentSum(list));
  }

  public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
    int[] dp = new int[nums.size()];
    Arrays.fill(dp, -1);
    
    return func(nums, nums.size() - 1, dp);
  }

  private static int func(ArrayList<Integer> nums, int index, int[] dp) {
    if (index == 0)
      return nums.get(index);
    if (index < 0)
      return 0;
    if (dp[index] != -1)
      return dp[index];
    int left = nums.get(index) + func(nums, index - 2, dp);
    int right = 0 + func(nums, index - 1, dp);

    return dp[index] = Math.max(left, right);
  }
}
