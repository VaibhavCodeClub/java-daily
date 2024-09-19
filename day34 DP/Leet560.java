// Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.HashMap;

public class Leet560 {
  public static void main(String[] args) {
    System.out.println(subarraySum(new int[] { 1 }, 0));
  }

  public static int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0;
    HashMap<Integer, Integer> prefixHashMap = new HashMap<>();
    prefixHashMap.put(0, 1);
    for (int i : nums) {
      sum += i;
      if (prefixHashMap.containsKey(sum - k)) {
        count += prefixHashMap.get(sum - k);

      }
      prefixHashMap.put(sum, prefixHashMap.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
