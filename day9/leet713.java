// Subarray Product Less Than K
// Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

public class leet713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        // initially count is 0
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            // sum = 1 as we are multiplying
            for (int j = i; j < nums.length; j++) {
                // for j=i j<n
                sum *= nums[j];
                // Multiply sum by each j and add it to sum
                // We are iterating from i so first subarray we be of length 1
                // Second will be of length two and so on
                // So calculate the product of each item remember each subarray is unique
                if (sum < k)
                    // if sum is strictly less than that of k then count++
                    count++;
                else
                    // else break that loop as we are going to increase the length of subarray in
                    // next iteration that is not of any use at all
                    break;

            }
        }
        return count;
    }
}
