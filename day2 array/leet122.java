// Best Time to Buy and Sell Stock II

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
 */

public class leet122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 6, 5, 4, 3 }));
    }

    public static int maxProfit(int[] prices) {
        // Maxprofit initially 0
        int maxProf = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                if (prices[j] > prices[i]) {
                    maxProf += prices[j] - prices[i];
                }

                i = j;
            }
        }
        return maxProf;
    }
}
