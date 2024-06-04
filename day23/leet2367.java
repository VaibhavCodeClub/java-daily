//  Number of Arithmetic Triplets
/* You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

    i < j < k,
    nums[j] - nums[i] == diff, and
    nums[k] - nums[j] == diff.

Return the number of unique arithmetic triplets.
*/

import java.util.HashSet;
import java.util.Set;

public class leet2367 {
  public static void main(String[] args) {
    System.out.println(arithmeticTriplets(new int[] { 4, 5, 6, 7, 8, 9 }, 2));
    System.out.println(arithmeticTriplets9(new int[] { 4, 5, 6, 7, 8, 9 }, 2));
  }

  public static int arithmeticTriplets(int[] nums, int diff) {
    // This is brute force approach
    // Worst in both the space and time complexity
    int count = 0;
    // Simply we iterate through each of the triplet and check if they satisfy the
    // given conditions if yes then increase the count

    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff)
            count++;
        }
      }
    }
    return count;
  }
// Below is the better approach which uses HashSet and uses only O(n) time and space
  public static int arithmeticTriplets9(int[] nums, int diff) {
    
    int count = 0;
    Set<Integer> numSet = new HashSet<>();

    for (int num : nums) {
      numSet.add(num);
    }

    for (int num : nums) {
      // Here num is k, num - diff is j and num - 2 * diff is i
      if (numSet.contains(num - diff) && numSet.contains(num - 2 * diff)) {
        count++;
      }
    }

    return count;
  }
}
