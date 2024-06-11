// Sort Array By Parity
// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

// Return any array that satisfies this condition.

import java.util.Arrays;

public class leet905 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortArrayByParity(new int[] { 0, 1 })));
  }

  public static int[] sortArrayByParity(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
      if (nums[start] % 2 == 0) {
        start++;
      } else if (nums[end] % 2 == 1) {
        end--;
      } else {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
    return nums;
  }
}