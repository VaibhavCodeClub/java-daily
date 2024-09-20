/*
Problem Description

Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. The problem with bubble sort is its worst case scenario. When the smallest element is in the last position, then it takes more time to sort in ascending order, but takes less time to sort in descending order.

An array is called beautiful if all the elements of the array are in either ascending or descending order. Given an array of numbers, find the minimum swap operations required to make the array beautiful.

Constraints

0 < N < 1000

0 < Arr[i] < 1000

Input

First line contains of integer N denoting number of elements in the array.

Second line consist of N integers separated by space denoting the elements of the array.

Output

Single integer denoting the least numbers of swap operations required to make the array beautiful.

Time Limit (secs)

1

Examples

Example 1:

Input:

5

4 5 3 2 1

Output:

1

Explanation:

The number of swaps required to sort the elements in ascending order is 9.

The number of swaps required to sort the elements in descending order is 1.

The best way is to sort in descending order and swaps required is 1.

Example 2:

Input:

5

4 5 1 2 3

Output 2:

4


*/

import java.util.Arrays;
import java.util.Scanner;

public class Bubble {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    int[] ascArr = Arrays.copyOf(arr, arr.length);
    int[] descArr = Arrays.copyOf(arr, arr.length);

    int ascSwaps = bubbleSorting(ascArr, true);
    int descSwaps = bubbleSorting(descArr, false);

    System.out.print(Math.min(ascSwaps, descSwaps));
    sc.close();
  }

  private static int bubbleSorting(int[] arr, boolean sortAscending) {
    int swapCount = 0;
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (
          (sortAscending && arr[j] > arr[j + 1]) ||
          (!sortAscending && arr[j] < arr[j + 1])
        ) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapCount++;
          swapped = true;
        }
      }
      if (!swapped) break;
    }
    return swapCount;
  }
}
