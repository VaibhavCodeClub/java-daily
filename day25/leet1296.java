// Divide Array in Sets of K Consecutive Numbers
// Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.

// Return true if it is possible. Otherwise, return false.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet1296 {
  public static void main(String[] args) {
    System.out.println(isPossibleDivide(new int[] { 3, 3, 2, 2, 1, 1 }, 3));
  }

  public static boolean isPossibleDivide(int[] nums, int k) {
    if (nums.length % k != 0)
      return false;
    Arrays.sort(nums);
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i : nums)
      countMap.put(i, countMap.getOrDefault(i, 0) + 1);
    for (int num : nums) {
      if (countMap.get(num) == 0)
        continue;

      for (int j = 0; j < k; j++) {
        int currentNumber = j + num;
        if (countMap.getOrDefault(currentNumber, 0) == 0)
          return false;
        countMap.put(currentNumber, countMap.get(currentNumber) - 1);
      }
    }
    return true;
  }
}
