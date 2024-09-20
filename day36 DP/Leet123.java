// Best Time to Buy and Sell Stock III
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/
import java.util.Arrays;

public class Leet123 {

  public static void main(String args[]) {
    System.out.print(maxProfit(new int[] { 10, 22, 5, 75, 65, 80 }));
  }

  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int[][][] dp = new int[n][2][3];

    for (int[][] arr : dp) for (int[] arr1 : arr) Arrays.fill(arr1, -1);

    return funct(0, 1, 2, prices, dp);
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
