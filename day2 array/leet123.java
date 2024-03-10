// Best Time to Buy and Sell Stock III

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

public class leet123 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
    }

    public static int maxProfit(int[] prices) {
        // int n = prices.length;
        // if (n <= 1)
        // return 0;

        // // First transaction
        // int[] leftProfit = new int[n];
        // int minPrice = prices[0];
        // leftProfit[0] = 0;
        // for (int i = 1; i < n; i++) {
        // minPrice = Math.min(minPrice, prices[i]);
        // leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        // }

        // // Second transaction
        // int[] rightProfit = new int[n];
        // int maxPrice = prices[n - 1];
        // rightProfit[n - 1] = 0;
        // for (int i = n - 2; i >= 0; i--) {
        // maxPrice = Math.max(maxPrice, prices[i]);
        // rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        // }

        // // Combining both transactions
        // int maxProfit = 0;
        // for (int i = 0; i < n; i++) {
        // maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        // }

        // return maxProfit;
        int buy1 = -prices[0], buy2 = -prices[0];
        int profit1 = 0, totalProfit = 0;

        for (int price : prices) {

            buy1 = Math.max(buy1, -price);
            profit1 = Math.max(profit1, price + buy1);

            buy2 = Math.max(buy2, profit1 - price);
            totalProfit = Math.max(totalProfit, price + buy2);

        }
        return totalProfit;
    }
}
