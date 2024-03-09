// Best Time to Buy and Sell Stock
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class leet121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        //  Maxprofit initially 0
        int maxProf = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            // Iterate through whole array
            if (prices[i] < minPrice) {
                // if current price is less than minPrice
                minPrice = prices[i];
                // minPrice = current price
            } else if (prices[i] - minPrice > maxProf) {
                // else if current price - minPrice is greater than the maxProf then
                // maxProf = current price - minPrice
                maxProf = prices[i] - minPrice;
            }
        }
        return maxProf;
    }
}
