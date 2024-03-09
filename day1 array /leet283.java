// Move Zeroes

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

import java.util.Arrays;

public class leet283 {
    public static void main(String[] args) {
        moveZeroes(new int[] { 0, 1, 0, 3, 12 });
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            while (k < nums.length) {
                // Just move the 0 to right by 1 place
                if (nums[i] == 0 && nums[k] != 0) {
                    nums[k] += nums[i];
                    nums[i] = nums[k] - nums[i];
                    nums[k] -= nums[i];
                    k++;
                } else {
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
