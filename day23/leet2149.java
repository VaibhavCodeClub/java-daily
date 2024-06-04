// Rearrange Array Elements by Sign
/*
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

    Every consecutive pair of integers have opposite signs.
    For all integers with the same sign, the order in which they were present in nums is preserved.
    The rearranged array begins with a positive integer.

Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
*/

import java.util.Arrays;

public class leet2149 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(rearrangeArray(new int[] { -5, 2 })));
    System.out.println(Arrays.toString(rearrangeArray9(new int[] { -5, 2 })));
  }

  public static int[] rearrangeArray(int[] nums) {
    // Worst approach
    int positive = 0, negative = 0, n = nums.length;
    int[] ret = new int[n];

    // Finding the first positive and negatiive number
    while (nums[positive] < 0) {
      positive++;
    }
    while (nums[negative] > 0) {
      negative++;
    }

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        ret[i] = nums[positive];
        do {
          positive++;
        } while (positive < n && nums[positive] < 0);
      } else {
        ret[i] = nums[negative];
        do {
          negative++;
        } while (negative < n && nums[negative] > 0);
      }
    }
    return ret;
  }

  // Better and simple approach is below

  public static int[] rearrangeArray9(int[] nums) {
    int n = nums.length;
    int arr[] = new int[n];
    // As we are told that we have to start with the positive number here positive
    // index is initialized as 0 and negative one as 1
    int pos = 0;
    int neg = 1;

    for (int i = 0; i < n; i++) {
      // iterate through the loop
      if (nums[i] > 0) {
        // If nums[i] is a positive put it at the position of the pos index and increase
        // that index by 2 as next position is for negative number
        arr[pos] = nums[i];
        pos += 2;
      } else {
        // If the number is negative then put it at the position of the neg index and
        // increase the neg index by 2
        arr[neg] = nums[i];
        neg += 2;
      }
    }
    return arr;
  }
}
