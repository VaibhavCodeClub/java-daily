// Count Subarrays Where Max Element Appears at Least K Times
// You are given an integer array nums and a positive integer k.
// Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
// A subarray is a contiguous sequence of elements within an array.

import java.util.HashMap;
import java.util.Map;

public class leet2962 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] { 1, 3, 2, 3, 3 }, 2));
    }

    public static long countSubarrays(int[] nums, int k) {
        // int count = 0, max = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        // // Calculate the max from the array
        // if (nums[i] > max)
        // max = nums[i];
        // }
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i; j < nums.length; j++) {
        // int[] temp = Arrays.copyOfRange(nums, i, j + 1);
        // int tempCount = 0;
        // for (int l = 0; l < temp.length; l++) {
        // if (temp[l] == max)
        // tempCount++;
        // }
        // if (tempCount >= k) {
        // count++;
        // }
        // }

        // }
        // return count;

        // The approach mentioned above consumes lots of time so................

        Map<Integer, Integer> m = new HashMap<>();
        // Create HashMap to store the count of numers
        int n = nums.length;
        int max = 0;
        for (int num : nums)
            // Calculate the max value
            if (num > max)
                max = num;

        int i = 0, j = 0; // Create 2 pointers
        long ans = 0; // This is the returning value
        while (j < n) {
            // iterate through loop
            int count = m.getOrDefault(nums[j], 0);
            // Increase the value of that number by 1 if not present the it will be 1
            m.put(nums[j], count + 1);
            while (m.containsKey(max) && m.get(max) >= k) {
                // when we reach our desired number of max values add all the next coming
                // subarrays to the returning value
                ans += n - j;

                int innerCount = m.get(nums[i]);
                // Now increase i by one and reduce the count which was left behind by i
                m.put(nums[i], innerCount - 1);
                i++;
            }
            j++;
        }
        return ans;
    }
}
