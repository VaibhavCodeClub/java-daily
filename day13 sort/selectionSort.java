// The selection sort algorithm

/*
 * Intuitions behind the algorithm
 * 
 * for first step take the largest element from the array and put it to its
 * proper place i.e last
 * for second iteration ignore that placed number and for remaining array do the
 * same find the largest and place it in its proper place continue running for
 * each step -1
 * 
 * 
 * Instead of taking the largest element and placing it to rightmost we can take
 * the smallest and put it to the leftmost too
 */

import java.util.Arrays;

/**
 * selectionSort
 */
public class selectionSort {

    public static void main(String[] args) {
        selection(new int[] { 3, 4, 5, 2, 1, 0 });
        alternateSelection(new int[] { 3, 4, 5, 2, 1, 0 });
    }

    private static void selection(int[] is) {
        // Iterate n times
        for (int i = 0; i < is.length; i++) {
            // Find the max element from the remaining array and swap it with current index
            int last = is.length - i - 1;
            // Grab the index of the max element from the remaining array
            int maxIndex = max(is, last);

            // Swap the max element with the current one
            int temp = is[maxIndex];
            is[maxIndex] = is[last];
            is[last] = temp;
        }
        System.out.println(Arrays.toString(is));
    }

    private static int max(int[] is, int last) {
        // for taking the max element from the remaining array
        // declare index of the max element as 0
        int max = 0;
        // for 0 to the end
        for (int j = 0; j <= last; j++) {
            // if the number present at j'th index is larger
            if (is[j] > is[max])
                // take it's index as max one
                max = j;
        }
        // return the index
        return max;
    }

    private static void alternateSelection(int[] is) {
        for (int i = is.length - 1; i > 0; i--) {
            int left = is.length - i-1;
            int minIndex = fetchMin(is, left);

            int temp=is[minIndex];
            is[minIndex]=is[left];
            is[left]=temp;
        }
        System.out.println(Arrays.toString(is));

    }

    private static int fetchMin(int[] is, int left) {

        int min = is.length - 1;
        for (int i = left; i < is.length; i++) {
            if (is[i] < is[min])
                min = i;
        }
        return min;
    }

}