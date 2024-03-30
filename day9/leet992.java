// Subarrays with K Different Integers
// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

import java.util.HashMap;
import java.util.Map;

public class leet992 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return lol(nums, k) - lol(nums, k - 1);
        // Get the number of all distinct subarrays which contain all the number of
        // distinct elements less than k and subtract the total subarrays which contain
        // k-1 distinct numbers and return it
    }

    public static int lol(int[] nums, int k) {
        // Some initialisations
        int count = 0, n = nums.length;
        int start = 0;
        // Map to store the numbers and their count
        Map<Integer, Integer> tot = new HashMap<>();

        for (int end = 0; end < n; end++) {
            // The loop which runs from start to end once
            tot.put(nums[end], tot.getOrDefault(nums[end], 0) + 1);

            // if the size of HashMap is greater than k
            while (tot.size() > k) {
                // Reduce the count value of that element at nums[start] by one
                if (tot.get(nums[start]) > 1)
                    tot.put(nums[start], tot.get(nums[start]) - 1);
                else
                    // if the count of the element at nums[start] was 1 then remove it
                    tot.remove(nums[start]);
                // move starting point forward of that window by 1
                start++;
            }
            // Add the count of subarrays with at most k distinct elements
            count += (end - start + 1);
        }
        return count;
    }
}
