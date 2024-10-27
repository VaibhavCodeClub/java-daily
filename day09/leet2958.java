// Length of Longest Subarray With at Most K Frequency
/*
You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
 */

import java.util.HashMap;
import java.util.Map;

public class leet2958 {
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[] { 1, 2, 3, 1, 2, 3, 1, 2 }, 2));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> rret = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (j < nums.length) {
            rret.put(nums[j], rret.getOrDefault(nums[j], 0) + 1);

            while (i <= j && rret.get(nums[j]) > k) {
                int dec = rret.get(nums[i]);
                rret.put(nums[i], dec - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

}