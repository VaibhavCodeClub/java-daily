// Best Time to Buy and Sell Stock II
/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
*/
import java.util.Arrays;

public class Leet122 {

  public static void main(String args[]) {
    System.out.print(maxProfit(new int[] { 5, 4, 3, 2, 1 }));
  }

  public static int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][2];
    for (int[] arr : dp) Arrays.fill(arr, -1);

    return funct(0, 1, prices, dp);
  }

  private static int funct(int index, int buy, int[] prices, int[][] dp) {
    if (index == prices.length) return 0;

    if (dp[index][buy] != -1) return dp[index][buy];

    int profit = 0;
    if (buy == 1) profit = Math.max(
      -prices[index] + funct(index + 1, 0, prices, dp),
      funct(index + 1, 1, prices, dp)
    );
    else profit = Math.max(
      prices[index] + funct(index + 1, 1, prices, dp),
      funct(index + 1, 0, prices, dp)
    );
    return dp[index][buy] = profit;
  }
}
