// Build Array from Permutation
// Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.

// A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).

import java.util.Arrays;

public class leet1920 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));
    }

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
