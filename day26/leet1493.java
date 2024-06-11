// Longest Subarray of 1's After Deleting One Element
// Given a binary array nums, you should delete one element from it.

// Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

public class leet1493 {

  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }));
  }

  public static int longestSubarray(int[] nums) {

    // Initialise currentSum as we are storing the sum of all 1's till next 0
    // Initialise prevSum as if we encounter 0 store current count to it and set
    // currentSum == 0
    // And the ans will be our final answer
    int prevSum = 0, currSum = 0, ans = 0;

    // Iterate through whole array
    for (int i : nums)

      // If the current value is 1 increase count by 1
      if (i == 1)
        currSum++;
      // else set answer as max of current answer or previousSum + currentSum
      // store currentSum to previous
      // set currentSum to 0
      else {
        ans = Math.max(ans, prevSum + currSum);
        prevSum = currSum;
        currSum = 0;
      }
    // at last again set answer as max of current answer or previousSum + currentSum
    ans = Math.max(ans, prevSum + currSum);

    // If our answers length is equal to the length of array reduce it by 1
    return ans == nums.length ? ans - 1 : ans;
  }
}