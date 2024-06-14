// How Many Numbers Are Smaller Than the Current Number
// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

// Return the answer in an array.

import java.util.Arrays;

public class leet1365 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 5, 0, 10, 0, 10, 6 })));
    System.out.println(Arrays.toString(smallerNumbersThanCurrent0(new int[] { 5, 0, 10, 0, 10, 6 })));
  }

  private static int smallerCount(int[] arr, int num) {
    int count = 0;
    for (int i : arr)
      if (i < num)
        count++;
    return count;
  }

  public static int[] smallerNumbersThanCurrent(int[] nums) {
    int smallest = nums[0], largest = nums[0], largestCount = 0;
    for (int i : nums) {
      if (i < smallest) {
        smallest = i;
      } else if (i > largest)
        largest = i;
      largest++;
    }

    int[] ret = new int[nums.length];

    for (int i = 0; i < ret.length; i++) {
      if (nums[i] == smallest)
        ret[i] = 0;
      else if (nums[i] == largest)
        ret[i] = nums.length - 1 - largestCount;

      else {
        ret[i] = smallerCount(nums, nums[i]);
      }

    }
    return ret;
  }

  public static int[] smallerNumbersThanCurrent0(int[] nums) {
    int[] count = new int[101];
    int[] result = new int[nums.length];

    for (int num : nums) {
      count[num]++;
    }

    for (int i = 1; i <= 100; i++) {
      count[i] += count[i - 1];
    }

    for (int i = 0; i < nums.length; i++) {
      result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
    }
    return result;
  }
}
