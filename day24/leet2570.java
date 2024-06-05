// Merge Two 2D Arrays by Summing Values
/*
You are given two 2D integer arrays nums1 and nums2.
    nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
    nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
    Only ids that appear in at least one of the two arrays should be included in the resulting array.
    Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays then its value in that array is considered to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet2570 {
  public static void main(String[] args) {
    int[][] soln = mergeArrays(
        new int[][] { { 148, 597 }, { 165, 623 }, { 306, 359 }, { 349, 566 }, { 403, 646 }, { 420, 381 }, { 566, 543 },
            { 730, 209 }, { 757, 875 }, { 788, 208 }, { 932, 695 } },
        new int[][] { { 74, 669 }, { 87, 399 }, { 89, 165 }, { 99, 749 }, { 122, 401 }, { 138, 16 }, { 144, 714 },
            { 148, 206 }, { 177, 948 }, { 211, 653 }, { 285, 775 }, { 309, 289 }, { 349, 396 }, { 386, 831 },
            { 403, 318 }, { 405, 119 }, { 420, 153 }, { 468, 433 }, { 504, 101 }, { 566, 128 }, { 603, 688 },
            { 618, 628 }, { 622, 586 }, { 641, 46 }, { 653, 922 }, { 672, 772 }, { 691, 823 }, { 693, 900 },
            { 756, 878 }, { 757, 952 }, { 770, 795 }, { 806, 118 }, { 813, 88 }, { 919, 501 }, { 935, 253 },
            { 982, 385 } });
    int[][] soln2 = mergeArrays0(
        new int[][] { { 148, 597 }, { 165, 623 }, { 306, 359 }, { 349, 566 }, { 403, 646 }, { 420, 381 }, { 566, 543 },
            { 730, 209 }, { 757, 875 }, { 788, 208 }, { 932, 695 } },
        new int[][] { { 74, 669 }, { 87, 399 }, { 89, 165 }, { 99, 749 }, { 122, 401 }, { 138, 16 }, { 144, 714 },
            { 148, 206 }, { 177, 948 }, { 211, 653 }, { 285, 775 }, { 309, 289 }, { 349, 396 }, { 386, 831 },
            { 403, 318 }, { 405, 119 }, { 420, 153 }, { 468, 433 }, { 504, 101 }, { 566, 128 }, { 603, 688 },
            { 618, 628 }, { 622, 586 }, { 641, 46 }, { 653, 922 }, { 672, 772 }, { 691, 823 }, { 693, 900 },
            { 756, 878 }, { 757, 952 }, { 770, 795 }, { 806, 118 }, { 813, 88 }, { 919, 501 }, { 935, 253 },
            { 982, 385 } });

    for (int[] is : soln) {
      System.out.print(Arrays.toString(is));
    }
    System.out.println();
    for (int[] is : soln2) {
      System.out.print(Arrays.toString(is));
    }
  }

  public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    // Hashmap to store all the IDs from both arrays and sum of their values
    Map<Integer, Integer> solutionMap = new HashMap<>();

    // put all the ids and their respected value from first array in map
    for (int[] is : nums1) {
      solutionMap.put(is[0], is[1]);
    }

    // during storing the values from the second array check if the key alredy
    // exists if yes then add the value to present one else put as it is
    for (int[] is : nums2) {
      solutionMap.put(is[0], solutionMap.getOrDefault(is[0], 0) + is[1]);
    }

    // Create the new 2d array to return of 2 cols and rows of size of map
    int[][] soln = new int[solutionMap.size()][2];

    // Create index such that it becomes easy to store the values in returning array
    int index = 0;
    // Iterate through the map and put the key and values in the final array
    for (Map.Entry<Integer, Integer> is : solutionMap.entrySet()) {
      soln[index++] = new int[] { is.getKey(), is.getValue() };
    }

    // Sort the array using comparator as we are sorting array nased on IDs
    Arrays.sort(soln, (a, b) -> Integer.compare(a[0], b[0]));
    return soln;
  }

  public static int[][] mergeArrays0(int[][] nums1, int[][] nums2) {
    // Take the lengths of both the arrays
    int m = nums1.length, n = nums2.length;

    // Create new output array of sum of the lengths and 2 cols
    int[][] mergedArray = new int[m + n][2];
    // Declare pointers and index as 0
    int i = 0, j = 0, k = 0;

    // Merge the two arrays
    while (i < m && j < n) {
      // As we know both the arrays are already sorted then add the smaller ID first
      // to resultant Array
      if (nums1[i][0] < nums2[j][0]) {
        // If ID from first array is small then add first one's [ID and value] to the
        // fianl array
        mergedArray[k++] = nums1[i++];
      } else if (nums1[i][0] > nums2[j][0]) {
        // If second ones then so
        mergedArray[k++] = nums2[j++];
      } else {
        // If both arrays have the same ID, sum the values and add it to the final array
        mergedArray[k++] = new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] };
        i++;
        j++;
      }
    }

    // Copy remaining elements of nums1, if any
    while (i < m) {
      mergedArray[k++] = nums1[i++];
    }

    // Copy remaining elements of nums2, if any
    while (j < n) {
      mergedArray[k++] = nums2[j++];
    }

    // Resize the merged array to the actual number of merged elements as remaining
    // will be [0,0]
    return Arrays.copyOf(mergedArray, k);
  }
}
