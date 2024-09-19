/*
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
For Example :

If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.


 */

import java.util.Arrays;

public class SubsetSumEqualTo {
  public static void main(String[] args) {
    System.out.println(subsetSumToK(4, 4, new int[] { 6, 1, 2, 1 }));
  }

  private static boolean function(int index, int target, int[] arr, Boolean[][] dp) {
    if (target == 0)
      return true;
    if (index == 0)
      return arr[0] == target;

    if (dp[index][target] != null) {
      return dp[index][target];
    }
    boolean notTake = function(index - 1, target, arr, dp);
    boolean take = false;

    if (target >= arr[index])
      take = function(index - 1, target - arr[index], arr, dp);
    dp[index][target] = take || notTake;
    return dp[index][target];
  }

  public static boolean subsetSumToK(int n, int k, int arr[]) {
    Boolean[][] dp = new Boolean[n][k + 1];
    for (Boolean[] row : dp) {
      Arrays.fill(row, null);
    }
    return function(n - 1, k, arr, dp);
  }
}
