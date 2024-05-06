// Largest Number At Least Twice of Others
// You are given an integer array nums where the largest integer is unique.

// Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
public class leet747 {
  public static void main(String[] args) {
    System.out.println(dominantIndex(new int[] { 2,0,0,1 }));
  }

  public static int dominantIndex(int[] numbers) {
    int maxIndex = 0, maxVal = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > numbers[maxIndex]) {
        maxIndex = i;
        maxVal = numbers[i];
      }
    }
    for (int i = 0; i < numbers.length; i++) {
      if (i == maxIndex)
        continue;
      if (maxVal >= numbers[i] * 2)
        continue;
      else
        return -1;
    }
    return maxIndex;
  }
}
