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

public class insertionSort {
    public static void main(String[] args) {
        insertion(new int[] { 4, 3, 2, 6, 0 });
    }

    private static void insertion(int[] is) {
        for (int i = 0; i < is.length - 1; i++) {
            // RUn until length - 2
            for (int j = i + 1; j > 0; j--) {
                // Take j as i + 1 to 0 and compare current j element with its previous one
                if (is[j] < is[j - 1]) {
                    // If not in proper order simply swap em
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