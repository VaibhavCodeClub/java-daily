// Maximum Ascending Subarray Sum
/*
You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
*/

import java.util.ArrayList;
import java.util.List;

public class leet2089 {
  public static void main(String[] args) {
    System.out.println(targetIndices(new int[] { 1, 2, 5, 2, 3 }, 5));
  }

  public static List<Integer> targetIndices(int[] nums, int target) {
    int small = 0, count = 0;
    List<Integer> returnList = new ArrayList<>();
    for (int i : nums) {
      if (i == target)
        count++;
      if (i < target)
        small++;
    }
    for (int i = 0; i < count; i++) {
      returnList.add(small + i);
    }
    return returnList;
  }
}
