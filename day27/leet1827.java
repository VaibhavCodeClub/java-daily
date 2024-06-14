// Minimum Operations to Make the Array Increasing
/*
You are given an integer array nums (0-indexed). In one operation, you can choose an element of the array and increment it by 1.

    For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].

Return the minimum number of operations needed to make nums strictly increasing.

An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1. An array of length 1 is trivially strictly increasing.
 */

public class leet1827 {
  public static void main(String[] args) {
    System.out.println(minOperations(new int[] { 1, 1, 1 }));
  }

  public static int minOperations(int[] nums) {
    if (nums.length == 1)
      return 0;
    int ans = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        int temp = (nums[i - 1] + 1) - nums[i];
        nums[i] += temp;
        ans += temp;
      }
    }
    return ans;
  }
}
