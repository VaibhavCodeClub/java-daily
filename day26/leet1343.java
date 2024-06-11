// Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

// Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold. 

public class leet1343 {
  public static void main(String[] args) {
    System.out.println(numOfSubarrays(new int[] { 2, 2, 2, 2, 5, 5, 5, 8 }, 3, 4));
  }

  public static int numOfSubarrays(int[] arr, int k, int threshold) {
    int coumnt = 0;
    int targetSum = k * threshold;
    int currentSum = 0;

    for (int i = 0; i < k; i++)
      currentSum += arr[i];

    if (currentSum >= targetSum)
      coumnt++;

    for (int i = k; i < arr.length; i++) {
      currentSum += arr[i] - arr[i - k];
      if (currentSum >= targetSum)
        coumnt++;
    }
    return coumnt;
  }

}