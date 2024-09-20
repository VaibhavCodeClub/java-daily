// Best Time to Buy and Sell Stock with Cooldown
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/

import java.util.Arrays;

public class Leet309 {

  public static void main(String args[]) {
    System.out.print(maxProfit(new int[] { 1, 2, 3, 0, 2 }));
  }

  public static int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int[] arr : dp) Arrays.fill(arr, -1);

    return funct(0, 1, prices, dp);
  }

  private static int funct(int index, int buy, int[] prices, int[][] dp) {
    if (index >= prices.length) return 0;

    if (dp[index][buy] != -1) return dp[index][buy];

    int profit = 0;
    if (buy == 1) profit = Math.max(
      -prices[index] + funct(index + 1, 0, prices, dp),
      funct(index + 1, 1, prices, dp)
    );
    else profit = Math.max(
      prices[index] + funct(index + 2, 1, prices, dp),
      funct(index + 1, 0, prices, dp)
    );
    return dp[index][buy] = profit;
  }
}
