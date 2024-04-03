// Subsets
// Given an integer array nums of unique elements,return all possible subsets(the power set).

// The solution set must not contain duplicate subsets.Return the solution in any order.

import java.util.ArrayList;
import java.util.List;

public class leet78 {

    public static void main(String[] args) {
        // System.out.println(subsets(new int[] { 1, 2, 3 }));
        System.out.println(subsets0(new int[] { 1, 2, 3 }));
    }

    /*
     * Iterative approach
     * []
     * [] [1]
     * [] [1] [2] [1 2]
     * [] [1] [2] [1 2] [3] [1 3] [2 3] [1 2 3]
     * [] [1] [2] [1 2] [3] [1 3] [2 3] [1 2 3] [4] [1 4] [2 4] [1 2 4] [3 4] [1 3
     * 4] [2 3 4] [1 2 3 4]
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutionList = new ArrayList<>();
        solutionList.add(new ArrayList<Integer>());

        for (int i : nums) {
            int n = solutionList.size();
            for (int j = 0; j < n; j++) {
                List<Integer> currentList = new ArrayList<Integer>(solutionList.get(j));
                currentList.add(i);
                // currentList = solutionList.get(j);
                solutionList.add(currentList);
            }
        }
        return solutionList;
    }

    /*
     * BackTracking
     * []
     * [1]
     * [1 2]
     * [1 2 3]
     * //backtrack
     * [1 3]
     * backtrack
     * [2]
     * [2 3]
     * backtrack
     * [3]
     */
    public static List<List<Integer>> subsets0(int[] nums) {
        List<List<Integer>> solutionList = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), solutionList);
        return solutionList;
    }

    private static void generateSubsets(int i, int[] nums, ArrayList<Integer> arrayList,
            List<List<Integer>> solutionList) {
        solutionList.add(new ArrayList<>(arrayList));

        for (int j = i; j < nums.length; j++) {
            arrayList.add(nums[j]);
            generateSubsets(j + 1, nums, arrayList, solutionList);
            arrayList.remove(arrayList.size() - 1);
        }
    }

}
