// 3Sum Closest
// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

import java.util.Arrays;

/**
 * leet16
 */
public class leet16 {

  public static void main(String[] args) {
    int[] nums = { 4, 0, 5, -5, 3, 3, 0, -4, -5 };
    System.out.println(threeSumClosest(nums, -2));
  }

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int resltSum = nums[0] + nums[1] + nums[2];
    int minDifference = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int currentSum = nums[i] + nums[left] + nums[right];

        if (currentSum == target)
          return target;
        if (currentSum < target)
          left++;
        else
          right--;

        int difftoTarget = Math.abs(currentSum - target);

        if (difftoTarget < minDifference) {
          resltSum = currentSum;
          minDifference = difftoTarget;
        }

      }
    }
    return resltSum;
  }
}
