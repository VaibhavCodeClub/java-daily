
// Implementation of the Bubble sort algorithm

/*
Intuition behind the logic is simple
Compare the neighbour if right is smaller than left swap them
And sfter each inner iteration respected large number goes to rightmost place so 
during next run iterate by 1 number small

If for entire one outer iteration no swapping is done then consider the array is already sorted and exit
*/

import java.util.Arrays;

public class bubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSorting(new int[] { 1, 2, 3, 4 })));
    }

    private static int[] bubbleSorting(int[] is) {
        boolean swapped = true;
        // Run the steps n-1 times
        for (int i = 0; i < is.length; i++) {
            swapped = false;
            // For each step max item will come at the last respective index
            for (int j = 1; j < is.length - i; j++) {
                // Swap the items if not in proper order
                if (is[j] < is[j - 1]) {
                    swapped = true;
                    // Swap
                    int temp = is[j];
                    is[j] = is[j - 1];
                    is[j - 1] = temp;
                }
            }
            if (!swapped)
                break;

        }
        return is;
    }
}
