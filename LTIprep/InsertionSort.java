// Insertion sort implementation

/*
 * Why use insertion sort:
 * Best case complexity steps are reduced
 * No of swaps reduced as compared to Bubble sort
 * Stable
 * Used for smaller values of N
 * Works good when array is partially sorted
 * Take part in Hybrid sorting algorithm (with merge or quick)
 *
 */

/*
 * Intution is
 * For i = 0 till index no 1 array will be sorted
 * So total n-1 iterations are required
 * for each iteration sort the array till that index
 */

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int[] is = { 4, 3, 2, 6, 0 };
    for (int i = 0; i < is.length - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (is[j] < is[j - 1]) {
          int temp = is[j];
          is[j] = is[j - 1];
          is[j - 1] = temp;
        } else
          break;
      }
    }
    System.out.println(Arrays.toString(is));
  }

}
// Simplest sorting algorithm :-)
