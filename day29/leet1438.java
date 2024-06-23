// Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
// Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

import java.util.ArrayDeque;

public class leet1438 {
  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[] { 8, 2, 4, 7 }, 04));
  }

  public static int longestSubarray(int[] nums, int limit) {
    ArrayDeque<Integer> inc = new ArrayDeque<>(), dec = new ArrayDeque<>();
    int res = 0, left = 0;
    for (int right = 0; right < nums.length; right++) {

      while (!inc.isEmpty() && inc.getLast() > nums[right]) {
        inc.removeLast();
      }
      while (!dec.isEmpty() && dec.getLast() < nums[right]) {
        dec.removeLast();
      }
      inc.addLast(nums[right]);
      dec.addLast(nums[right]);
      while (dec.getFirst() - inc.getFirst() > limit) {
        if (dec.getFirst() == nums[left]) {
          dec.removeFirst();
        }
        if (inc.getFirst() == nums[left]) {
          inc.removeFirst();
        }
        left++;
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }
}
