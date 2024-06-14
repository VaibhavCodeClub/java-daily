// N-Repeated Element in Size 2N Array
/*
You are given an integer array nums with the following properties:

    nums.length == 2 * n.
    nums contains n + 1 unique elements.
    Exactly one element of nums is repeated n times.

Return the element that is repeated n times.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class leet961 {
  public static void main(String[] args) {
    System.out.println(repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
    System.out.println(repeatedNTimes00(new int[] { 2, 1, 2, 5, 3, 2 }));
  }

  public static int repeatedNTimes(int[] nums) {
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i : nums)
      seen.put(i, seen.getOrDefault(i, 0) + 1);

    for (Map.Entry<Integer, Integer> entry : seen.entrySet()) {
      if (entry.getValue() > 1) {
        return entry.getKey();
      }
    }
    return -1;
  }

  public static int repeatedNTimes00(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (!seen.add(num)) {
        return num;
      }
    }
    return -1;
  }
}