// Maximum Strong Pair XOR I
/*
You are given a 0-indexed integer array nums. A pair of integers x and y is called a strong pair if it satisfies the condition:

    |x - y| <= min(x, y)

You need to select two integers from nums such that they form a strong pair and their bitwise XOR is the maximum among all strong pairs in the array.

Return the maximum XOR value out of all possible strong pairs in the array nums.

Note that you can pick the same integer twice to form a pair.
*/

public class leet2932 {
    static class TrieNode {
        TrieNode Zero, One;
    }

    public static void main(String[] args) {
        System.out.println(maximumStrongPairXor(new int[] { 10, 110 }));
        System.out.println(maximumStrongPairXor(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                int min = Math.min(nums[i], nums[j]);
                if (diff <= min) {
                    max = Math.max(max, nums[i] ^ nums[j]);
                }
            }
        }
        return max;
    }

    // efficient approach in terms of both the memory and speed is below
    public static int maximumStrongPairXor0(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            for (int num2 : nums) {
                int xor = num ^ num2;
                if (xor > ans && Math.abs(num - num2) <= Math.min(num, num2)) {
                    ans = xor;
                }
            }
        }
        return ans;
    }
}
