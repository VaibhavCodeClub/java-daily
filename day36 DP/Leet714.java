// Best Time to Buy and Sell Stock with Transaction Fee

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note:
    You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
    The transaction fee is only charged once for each stock purchase and sale.
*/

import java.util.Arrays;

public class Leet714 {

  public static void main(String args[]) {
    System.out.print(maxProfit(new int[] { 1, 3, 7, 5, 10, 3 }, 3));
  }

  public static int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length][2];
    for (int[] arr : dp) Arrays.fill(arr, -1);

    return funct(0, 1, fee, prices, dp);
  }

  private static int funct(
    int index,
    int buy,
    int fee,
    int[] prices,
    int[][] dp
  ) {
    if (index >= prices.length) return 0;

    if (dp[index][buy] != -1) return dp[index][buy];

    int profit = 0;
    if (buy == 1) profit = Math.max(
      -prices[index] + funct(index + 1, 0, fee, prices, dp),
      funct(index + 1, 1, fee, prices, dp)
    );
    else profit = Math.max(
      prices[index] - fee + funct(index + 1, 1, fee, prices, dp),
      funct(index + 1, 0, fee, prices, dp)
    );
    return dp[index][buy] = profit;
  }
}
