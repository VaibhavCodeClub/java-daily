// Maximum subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.
// Kadan's Algorithm

public class leet53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { 1, 2, 3, -2, 5 }));
    }

    public static long maxSubArray(int[] nums) {
        int maxSum = nums[0], curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = curSum + nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}