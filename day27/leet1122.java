// Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
// Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

// Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet1122 {
  public static void main(String[] args) {
    System.out
        .println(Arrays.toString(
            relativeSortArray(new int[] { 2, 3, 1, 3, 2, 19, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 })));
    System.out
        .println(Arrays.toString(
            relativeSortArray00(new int[] { 2, 3, 1, 3, 2, 19, 4, 6, 7, 9, 2, 19 }, new int[] { 2, 1, 4, 3, 9, 6 })));
  }

  public static int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] returnArray = new int[arr1.length];
    int index = 0;
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int i : arr1)
      countMap.put(i, countMap.getOrDefault(i, 0) + 1);

    for (int i = 0; i < arr2.length;) {
      returnArray[index++] = arr2[i];
      countMap.put(arr2[i], countMap.get(arr2[i]) - 1);

      if (countMap.get(arr2[i]) == 0) {
        i++;
      }
    }
    int[] remainingKeys = countMap.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();

    for (int key : remainingKeys) {
      int count = countMap.get(key);
      while (count > 0) {
        returnArray[index++] = key;
        count--;
      }
    }
    return returnArray;
  }

  public static int[] relativeSortArray00(int[] arr1, int[] arr2) {
    // Find the maximum value in arr1 for the range of the counting array
    int max = 0;
    for (int num : arr1) {
      if (num > max) {
        max = num;
      }
    }

    // Initialize the count array
    int[] count = new int[max + 1];
    for (int num : arr1) {
      count[num]++;
    }

    // Initialize the result array
    int[] result = new int[arr1.length];
    int index = 0;

    // Place elements from arr2 into the result array in the correct order
    for (int num : arr2) {
      while (count[num] > 0) {
        result[index++] = num;
        count[num]--;
      }
    }

    // Place remaining elements that are not in arr2 into the result array
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        result[index++] = i;
        count[i]--;
      }
    }

    return result;
  }
}
