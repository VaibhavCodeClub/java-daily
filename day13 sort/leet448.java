// Find All Numbers Disappeared in an Array

// Using cyclic sort
// Google question
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

import java.util.ArrayList;
import java.util.List;

public class leet448 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] { 1,1 }));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> solution = new ArrayList<>();

        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i] - 1]){
            i++;
                continue;}
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;

        }for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1) solution.add(i+1);
        }
        return solution;
    }
}
