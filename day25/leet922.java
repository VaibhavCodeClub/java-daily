// Sort Array By Parity II
// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

// Return any answer array that satisfies this condition.

import java.util.Arrays;

public class leet922 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortArrayByParityII(new int[] { 888, 505, 627, 846 })));
    System.out.println(Arrays.toString(sortArrayByParityII0(new int[] { 888, 505, 627, 846 })));
  }

  public static int[] sortArrayByParityII(int[] nums) {
    int oddPointer = 1, evenPointer = 0, len = nums.length;
    while (oddPointer < len && evenPointer < len) {
      // Move oddPointer to the next position where nums[oddPointer] is even
      while (oddPointer < len && nums[oddPointer] % 2 == 1) {
        oddPointer += 2;
      }
      // Move evenPointer to the next position where nums[evenPointer] is odd
      while (evenPointer < len && nums[evenPointer] % 2 == 0) {
        evenPointer += 2;
      }
      if (oddPointer < len && nums[oddPointer] % 2 == 0 && nums[evenPointer] % 2 == 1) {
        int temp = nums[oddPointer];
        nums[oddPointer] = nums[evenPointer];
        nums[evenPointer] = temp;
        oddPointer += 2;
        evenPointer += 2;
      }
    }
    return nums;
  }// Better approach is below

  public static int[] sortArrayByParityII0(int[] nums) {

    int arr[] = new int[nums.length];
    int k = -2;
    int c = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) {
        k += 2;
        arr[k] = nums[i];
      } else {
        c += 2;
        arr[c] = nums[i];

      }
    }

    return arr;

  }
}
