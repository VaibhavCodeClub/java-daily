// Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.


// In this solution I simply sorted array and checked if any of the element is similar to the i and returned the solution
import java.util.Arrays;

public class leet217 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1 }));
    }

    public static boolean containsDuplicate(int[] nums) {
        boolean ret = false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ret = true;
            }
        }
        return ret;
    }
}
