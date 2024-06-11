// Continuous Subarray Sum
/*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:

    its length is at least two, and
    the sum of the elements of the subarray is a multiple of k.
Note that:
    A subarray is a contiguous part of the array.
    An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
*/

import java.util.HashMap;
import java.util.Map;

public class leet523 {
  public static void main(String args[]) {
    System.out.println(checkSubarraySum(new int[] { 5, 0, 0, 0 }, 3));
  }

  public static boolean checkSubarraySum(int[] nums, int k) {
    int n = nums.length, prefSum = 0;
    Map<Integer, Integer> firstOccuranceMap = new HashMap<>();
    firstOccuranceMap.put(0, -1); // Initialize to handle cases where subarray starts at index 0

    for (int i = 0; i < n; i++) {
      prefSum = (prefSum + nums[i]) % k;
      if (prefSum < 0)
        prefSum += k; // Handle negative modulo results

      if (firstOccuranceMap.containsKey(prefSum)) {
        if (i + -firstOccuranceMap.get(prefSum) >= 2)
          return true;
      } else
        firstOccuranceMap.put(prefSum, i);
    }
    return false;
  }
}