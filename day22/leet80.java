// Remove Duplicates from Sorted Array II

/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}

If all assertions pass, then your solution will be accepted.


*/

import java.util.Arrays;

public class leet80 {
  public static void main(String args[]) {
    System.out.print(removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));

  }

  public static int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums) {
      // We can add the current element if i < 2 (less than two elements so far)
      // or if the current element is not the same as the element two positions back
      if (i < 2 || n != nums[i - 2]) {
        nums[i++] = n; // Add the current element and increment i
      }
    }
    System.out.println(Arrays.toString(nums)); // Print the modified array
    return i; // Return the new length of the array
  }
}