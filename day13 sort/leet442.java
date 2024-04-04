// Find All Duplicates in an Array
// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant extra space.

import java.util.ArrayList;
import java.util.List;

public class leet442 {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1, 1 }));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) {
                i++;
                continue;
            }
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
        for (int index = 0; index < nums.length; index++)
            if (nums[index] != index + 1)
                sol.add(nums[index]);
        return sol;
    }
}
