/*
You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.
You need to fill the knapsack with the items in such a way that you get the maximum profit. You are allowed to take one item multiple times.
*/
import java.util.Arrays;

public class UnboundedKnapsack {

  public static void main(String args[]) {
    System.out.print(
      unboundedKnapsack(2, 3, new int[] { 6, 12 }, new int[] { 4, 17 })
    );
  }

  public static int unboundedKnapsack(
    int n,
    int w,
    int[] profit,
    int[] weight
  ) {
    int dp[][] = new int[n][w + 1];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }

    return knapsack(n - 1, w, profit, weight, dp);
  }

  private static int knapsack(
    int index,
    int w,
    int[] profit,
    int[] weight,
    int[][] dp
  ) {
    if (index == 0) return (w / weight[0]) * profit[0];
    if (dp[index][w] != -1) return dp[index][w];
    int notTake = knapsack(index - 1, w, profit, weight, dp);
    int take = Integer.MIN_VALUE;
    if (weight[index] <= w) take = profit[index] +
    knapsack(index, w - weight[index], profit, weight, dp);

    return dp[index][w] = Math.max(take, notTake);
  }
}
