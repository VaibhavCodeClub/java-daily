// Running Sum of 1d Array
// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

import java.util.Arrays;

public class leet1480 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[] { 1, 1, 1, 1, 1 })));
    }

    public static int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int runningSum = 0;
            for (int j = i; j >= 0; j--) {
                runningSum += nums[j];
            }
            arr[i] = runningSum;
        }
        return arr;

        // time complexity is O(n)
        // space complexity is O(1)

        // for(int i=1;i<nums.length;i++){
        // nums[i]+=nums[i-1];}
        // return nums;
    }
}
