// Richest Customer Wealth
// You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

// A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

public class leet1672 {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][] { { 1, 5 }, { 3, 7 }, { 3, 5 } }));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] is : accounts) {
            int currentMax = 0;
            for (int is2 : is) {
                currentMax += is2;
            }
            max = max > currentMax ? max : currentMax;
        }
        return max;
    }
}

// Time complexity = O(N x M)
// Space complexity = O(1)