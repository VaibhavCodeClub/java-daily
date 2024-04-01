//Count Subarrays With Fixed Bounds
/*
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

    The minimum value in the subarray is equal to minK.
    The maximum value in the subarray is equal to maxK.

Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.
*/

/*
Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].

*/
public class leet2444 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] { 1, 3, 5, 2, 7, 5 }, 1, 5));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0; // Initialize the count of subArrays as per the criteria
        int highest = -1, lowest = -1, maximum = -1, n = nums.length; // Initialize variables for tracking indices

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) // If current number is outside the range
                highest = i; // Update highest index encountered so far
            if (nums[i] == minK) // If current number is equal to minK
                lowest = i; // Update lowest index encountered so far
            if (nums[i] == maxK) // If current number is equal to maxK
                maximum = i; // Update maximum index encountered so far

            ans += Math.max(0, Math.min(lowest, maximum) - highest); // Update ans with count of valid subArrays
        }
        return ans; // Return the count of subArrays as per the criteria

    }
}
