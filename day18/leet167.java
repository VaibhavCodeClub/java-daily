// Two Sum II - Input Array Is Sorted
/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
*/

import java.util.Arrays;

public class leet167 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[] {1,2,3,4,5,6,9 },449)));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target)
        break;
      if (sum > target)
        right--;
      else
        left++;
    }
    return new int[] { left + 1, right + 1 };
  }
}
