// Pancake Sorting
/*
Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:
    Choose an integer k where 1 <= k <= arr.length.
    Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
*/

import java.util.ArrayList;
import java.util.List;

public class leet969 {
  public static void main(String[] args) {
    System.out.println(pancakeSort(new int[] { 3, 2, 4, 1 }));
  }
 // For first iteration we need to get the highest index from the array
  private static int findMaxIndex(int[] arr, int n) {
    int maxIndex = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[maxIndex])
        maxIndex = i;
    }
    return maxIndex;
  } 
// Flipping array from zero upto index indexOfLargestUnsortedNumber
  private static void flip(int[] arr, int indexOfLargestUnsortedNumber) {
    int start = 0;
    while (start < indexOfLargestUnsortedNumber) {
      int temp = arr[indexOfLargestUnsortedNumber];
      arr[indexOfLargestUnsortedNumber] = arr[start];
      arr[start] = temp;
      start++;
      indexOfLargestUnsortedNumber--;
    }
  }

  public static List<Integer> pancakeSort(int[] arr) {
    List<Integer> returnList = new ArrayList<>();

    for (int i = arr.length; i > 1; i--) {
      int indexOfLargestUnsortedNumber = findMaxIndex(arr, i);
      if (indexOfLargestUnsortedNumber != i - 1) {
        returnList.add(indexOfLargestUnsortedNumber + 1);
        flip(arr, indexOfLargestUnsortedNumber);
        returnList.add(i);
        flip(arr, i - 1);
      }
    }
    return returnList;
  }
}
