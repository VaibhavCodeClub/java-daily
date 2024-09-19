// A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

// 0 1 Knapsack

import java.util.Arrays;

public class ZeroOneKnapsack {
  public static void main(String[] args) {
    System.out.println(knapsack(new int[] { 20,25,5  }, new int[] {60,50,20 }, 3, 40));
  }

  private static int function(int index, int w, int[] weight, int[] value, int[][] dp) {
    if (index == 0) {
      if (weight[0] <= w)
        return value[0];
      else
        return 0;
    }
    if (dp[index][w] != -1) {
      return dp[index][w];
    }

    int notTake = 0 + function(index - 1, w, weight, value, dp);
    int take = Integer.MIN_VALUE;
    if (weight[index] <= w)
      take = value[index] + function(index - 1, w - weight[index], weight, value, dp);
    return dp[index][w] = Math.max(notTake, take);
  }

  static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    int[][] dp = new int[n][maxWeight + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return function(n - 1, maxWeight, weight, value, dp);
  }
}
