// Most important sorting algorithm Cyclic sort

// When you are given 1 - N elements just use this algorithm
// Related questions can be like missing value in Array from 1 - N
// This algorithm only takes one iteration to sort the array so the time complexity is O(n)

import java.util.Arrays;

public class cyclicSort {

  public static void main(String[] args) {
    cyclic(new int[] { 1, 3, 2, 4, 5, 9, 8, 7, 6 });
  }

  private static void cyclic(int[] is) {
    for (int i = 0; i < is.length - 1;) {
      // Iterate through the entire array just keep in mind not to increase i for each
      // run
      if (is[i] == i + 1) {
        // Increase the i only if the value at i is proper for its position
        i++;
        continue;
      }
      // Else swap the value to its proper position
      int temp = is[is[i] - 1];
      is[is[i] - 1] = is[i];
      is[i] = temp;
    }
    System.out.println(Arrays.toString(is));
  }
}
