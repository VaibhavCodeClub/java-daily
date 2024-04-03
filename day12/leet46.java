// Permutations
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

import java.util.ArrayList;
import java.util.List;

public class leet46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
    }

    public static List<List<Integer>> permute(int[] nums) {
        // Create empty 2d list to return permutations
        List<List<Integer>> solution = new ArrayList<>();
        // Calling the helper method
        backtrack(solution, new ArrayList<>(), nums);
        // Finally return the solution
        return solution;
    }

    private static void backtrack(List<List<Integer>> solution, ArrayList<Integer> arrayList, int[] nums) {
        if (arrayList.size() == nums.length) {
            // If the length of temperory arraylist is equal to original array then we have
            // achieved our target exit this method
            solution.add(new ArrayList<>(arrayList));
            // Before exiting add temperory arralist to the final arraylist
            // On each seperate call a single arraylist will be added
            return;
        }
        for (int num : nums) {
            // for each int in array 
            if (arrayList.contains(num))
            // if that num is already present in the arraylist just continue to next iteration
                continue;

            arrayList.add(num);
            // Add current num to the temp list

            backtrack(solution, arrayList, nums);
            // call self by giving updated temp list

            arrayList.remove(arrayList.size() - 1);
            // remove the last element from temp list
        }
    }
}
