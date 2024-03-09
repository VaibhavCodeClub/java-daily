// Two Sum
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

// Here I used very simple approach I just made 2 for loops to iterate through array and returned the indices when their sum matches the target element
import java.util.Arrays;

public class leet1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
