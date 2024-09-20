// Best Time to Buy and Sell Stock IV
/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/
import java.util.Arrays;

public class Leet188 {

  public static void main(String args[]) {
    System.out.print(maxProfit(2, new int[] { 2, 4, 1 }));
  }

  public static int maxProfit(int k, int[] prices) {
    int n = prices.length;
    int[][][] dp = new int[n][2][k + 1];

    for (int[][] arr : dp) for (int[] arr1 : arr) Arrays.fill(arr1, -1);

    return funct(0, 1, k, prices, dp);
  }

  private static int funct(
    int index,
    int buy,
    int trans,
    int[] prices,
    int[][][] dp
  ) {
    if (index == prices.length) return 0;
    if (trans == 0) return 0;

    if (dp[index][buy][trans] != -1) return dp[index][buy][trans];

    int profit = 0;
    if (buy == 1) profit = Math.max(
      -prices[index] + funct(index + 1, 0, trans, prices, dp),
      funct(index + 1, 1, trans, prices, dp)
    );
    else profit = Math.max(
      prices[index] + funct(index + 1, 1, trans - 1, prices, dp),
      funct(index + 1, 0, trans, prices, dp)
    );
    return dp[index][buy][trans] = profit;
  }
}
