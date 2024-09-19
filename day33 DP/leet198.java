// House Robber
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

import java.util.Arrays;

public class leet198 {
  public static void main(String[] args) {
    System.out.println(rob(new int[] { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58,
        170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67,
        205, 94, 205, 169, 241, 202, 144, 240 })); 

        System.out.println(rob2(new int[] { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58,
        170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67,
        205, 94, 205, 169, 241, 202, 144, 240 }));
        System.out.println(rob3(new int[] { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58,
        170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67,
        205, 94, 205, 169, 241, 202, 144, 240 }));
  }

  public static int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return function(nums, dp, nums.length - 1);
  }

  private static int function(int[] nums, int[] dp, int index) {
    if (index == 0)
      return nums[index];
    if (index < 0)
      return 0;

    if (dp[index] != -1)
      return dp[index];
    int left = nums[index] + function(nums, dp, index - 2);
    int right = 0 + function(nums, dp, index - 1);

    return dp[index]=Math.max(left, right);
  }

  public static int rob2(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0]=nums[0];
    for (int i = 1; i < dp.length; i++) {
      int take  = nums[i];
      if(i>1)take+=dp[i-2];
      int nonTake=0+dp[i-1];
      dp[i]=Math.max(take,nonTake);
    }
    return dp[dp.length-1];
  } 
  
  public static int rob3(int[] nums) {
    int prev=nums[0];
    int prev2=0;
    for (int i = 1; i < nums.length; i++) {
      int take  = nums[i];
      if(i>1)take+=prev2;
      int nonTake=0+prev;
      int cur=Math.max(take,nonTake);

      prev2=prev;
      prev=cur;
    }
    return prev;
  }
}
