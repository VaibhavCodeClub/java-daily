// Intersection of Two Arrays
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet349 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2, 2 })));
    System.out.println(Arrays.toString(intersection1(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2, 2 })));
  }

  public static int[] intersection(int[] nums1, int[] nums2) {
    // Create set to store the intersections (only unique)
    Set<Integer> finalSet = new HashSet<>();

    // Sort the array2 as binary search needs array sorted
    Arrays.sort(nums2);

    // Run loop for each element in the first array
    for (int i : nums1) {
      // take that element and check if it is present in second array
      boolean isExistsInSecond = binarySearch(nums2, i);

      // If it is present then add it to the set
      if (isExistsInSecond) {
        finalSet.add(i);
      }
    }
    // Convert the set to array
    int[] array = setToIntArray(finalSet);
    return array;
  }

  static boolean binarySearch(int[] arr, int target) {
    // This is binary search function
    // To check if the specific target element is preset in an array or not
    // Initialize start and end points
    int start = 0, end = arr.length - 1;

    // Iterate while start is small then end
    while (start <= end) {

      // calculate the mid this is efficient way
      int mid = start + (end - start) / 2;

      // if arr[mid] == target then the element is present return true
      if (target == arr[mid])
        return true;
      // Else adjust the start and end accordingly
      else if (arr[mid] < target)
        start = mid + 1;
      else
        end = mid - 1;
    }
    // After iterating return false as the element is not present
    return false;
  }

  public static int[] setToIntArray(Set<Integer> set) {
    // The function to convert Set to Integer array
    // Create array of set size
    int[] array = new int[set.size()];
    // Initialize index at 0
    int index = 0;
    for (Integer element : set) {
      // for each element is set store that value in array and increase index
      array[index++] = element;
    }
    // return the output array
    return array;
  }
  // Above approach is not efficient one so here is the better version
  // Above approach gives 4ms while below gives 2ms

  public static int[] intersection1(int[] nums1, int[] nums2) {
    // Create a HashSet and store all the elements from the first Array to it
    Set<Integer> set1 = new HashSet<>();
    for (int num : nums1) {
      set1.add(num);
    }
    // Create another HashSet to store all intersecting elements in it
    Set<Integer> finalSet = new HashSet<>();
    // Loop through second array
    for (int num : nums2) {
      // If that element is present in first set that means it is present in first
      // array then add it to the finalSet
      if (set1.contains(num)) {
        finalSet.add(num);
      }
    }
    // Convert final set to array and return it
    return setToIntArray(finalSet);
  }

}
