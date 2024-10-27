// Maximum Ascending Subarray Sum

/*
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
A subarray is defined as a contiguous sequence of numbers in an array.
A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
*/

public class leet1800 {
  public static void main(String[] args) {
    System.out.println(maxAscendingSum(new int[] { 10}));
  }

  public static int maxAscendingSum(int[] nums) {
    int maxSum = nums[0], curSum = maxSum;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1])
        curSum += nums[i];
      else {
        maxSum = Math.max(curSum, maxSum);
        curSum = nums[i];
      }
    }
    maxSum = Math.max(curSum, maxSum);
    return maxSum;
  }
}
