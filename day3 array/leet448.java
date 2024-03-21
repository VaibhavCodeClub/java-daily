
// Find All Numbers Disappeared in an Array
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

import java.util.ArrayList;
import java.util.List;

public class leet448 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>(); // Create the empty list to save the output
        for (int i : nums) {// Iterate through the array
            int index = Math.abs(i) - 1; // Grab the index value and store it in index as positive
            if (nums[index] > 0) { // If the position value at that index in positive
                nums[index] *= -1; // make it negative
            }
        }
        for (int i = 0; i < nums.length; i++) { // Iterate through the entire array
            if (nums[i] > 0) { // If any value seems positive
                ans.add(i + 1); // Add it to the return list
            }
        }
        return ans;
    }
}
