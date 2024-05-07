// Largest Number
// Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

// Since the result may be very large, so you need to return a string instead of an integer.

import java.util.Arrays;

public class leet179 {
  public static void main(String[] args) {
    System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
  }

  public static String largestNumber(int[] nums) {
    String[] arr = new String[nums.length];
    StringBuilder returnStr = new StringBuilder("");

    for (int i = 0; i < arr.length; i++)
      arr[i] = nums[i] + "";

    Arrays.sort(arr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
    for (String string : arr)
      returnStr.insert(0, string);

      return returnStr.charAt(0)=='0'?"0":returnStr.toString();
    }
}
