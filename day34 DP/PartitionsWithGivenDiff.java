
/*
Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array. Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.

Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’ and the difference between ‘S1’ and ‘S2’ is equal to ‘D’. Since the answer may be too large, return it modulo ‘10^9 + 7’.

If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition ‘i’. Then, two partitions P1 and P2 are considered different if:

1) P1_S1 != P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2.
2) P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2_S2. Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed.
Refer to the example below for clarification.

Note that the sum of the elements of an empty subset is 0.
 */
import java.util.Arrays;

public class PartitionsWithGivenDiff {
  public static void main(String[] args) {
    System.out.println(countPartitions(6, 17, new int[] { 1, 0, 8, 5, 1, 4 }));
  }

  public static int MOD = (int) 1e9 + 7;

  private static int function(int index, int target, int[] nums, int[][] dp) {
    if(index==0){
      if(target==0&& nums[0]==0)return 2;
      if(target==0||target==nums[0])return 1;
      return 0;
    }
    // if (target == 0)
    //   return 1;
    // if (index == 0)
    //   return nums[index] == target ? 1 : 0;
    if (dp[index][target] != -1)
      return dp[index][target];

    int notPick = function(index - 1, target, nums, dp);
    int pick = 0;

    if (nums[index] <= target) {
      pick = function(index - 1, target - nums[index], nums, dp);
    }
    return dp[index][target] = (pick + notPick) % MOD;
  }

  public static int countPartitions(int n, int d, int[] arr) {
    int totSum = 0;
    for (int i : arr) {
      totSum += i;
    }

    if (totSum < d || (totSum + d) % 2 != 0) {
      return 0;
    }

    int target = (totSum + d) / 2;
    int[][] dp = new int[n][target + 1];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }

    return function(n - 1, target, arr, dp);
  }
}
