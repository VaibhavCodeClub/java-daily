// Intersection of Two Arrays II
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet350 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
  }

  public static int[] intersect(int[] nums1, int[] nums2) {
    // Create map to store the count of occurance of each element in first array
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int integer : nums1) {
      // Put all the elements from array1 and their respective count in that map
      countMap.put(integer, countMap.getOrDefault(integer, 0) + 1);
      // getOrDefault is used to get current value or if not present it puts the
      // second parameter at the place of that element count (here 0).
    }

    // Create list to store all the intersecting elements
    List<Integer> finalIntegers = new ArrayList<>();
    // Iterte through second array
    for (int integer : nums2) {
      // If the occurance of that specific element in the map is greater than 1 it
      // means that element is common one then add it to the final list
      if (countMap.getOrDefault(integer, 0) > 0) {
        finalIntegers.add(integer);
        // And negate the occurance of that element from the map
        countMap.put(integer, countMap.get(integer) - 1);
      }
    }

    // As the return type of our function is array not list create new empty array
    // whose length is as same as the list
    int[] arr = new int[finalIntegers.size()];
    // create the index as 0
    int indes = 0;
    // Iterate through the list and put each element in the array by increasing the
    // index
    for (Integer integer : finalIntegers) {
      arr[indes++] = integer;
    }
    // Return the array
    return arr;
  }
}
