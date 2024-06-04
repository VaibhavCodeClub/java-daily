// Partition Array According to Given Pivot
/*
You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

    Every element less than pivot appears before every element greater than pivot.
    Every element equal to pivot appears in between the elements less than and greater than pivot.
    The relative order of the elements less than pivot and the elements greater than pivot is maintained.
        More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj. Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.

Return nums after the rearrangement.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet2161 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(pivotArray(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10)));
    System.out.println(Arrays.toString(pivotArray0(new int[] { 9, 12, 5, 10, 14, 3, 10 }, 10)));
  }

  public static int[] pivotArray(int[] nums, int pivot) {
    // Approach
    // I have created 3 lists which are to store smaller elements than pivot,
    // greater elements and elements equal to pivot respectively
    // Then iterate through whole array and put respective values in lists
    // at the end iterate through each list (first smaller second equal and at the
    // end greater elements) and change the values of the inoout array as per their
    // values and return that array

    // This solution is worst in time complexity but gives better space complexity

    List<Integer> smallerThan = new ArrayList<>();
    List<Integer> greaterThan = new ArrayList<>();
    List<Integer> equalTo = new ArrayList<>();

    for (int i : nums)
      if (i < pivot)
        smallerThan.add(i);
      else if (i > pivot)
        greaterThan.add(i);
      else
        equalTo.add(i);

    int indexx = 0;
    for (Integer integer : smallerThan)
      nums[indexx++] = integer;
    for (Integer integer : equalTo)
      nums[indexx++] = integer;
    for (Integer integer : greaterThan)
      nums[indexx++] = integer;

    return nums;
  }

  // Below is the better approach to solve this example in time

  public static int[] pivotArray0(int[] nums, int pivot) {
    int[] arr = new int[nums.length];
    int index = 0;

    for (int i : nums)
      if (i < pivot)
        arr[index++] = i;
    for (int i : nums)
      if (i == pivot)
        arr[index++] = i;
    for (int i : nums)
      if (i > pivot)
        arr[index++] = i;

    return arr;
  }
}
