// Reverse String
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.
import java.util.Arrays;

class Solution {
  public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
    System.out.println(Arrays.toString(s));
    System.gc();
  }
}

public class leet344 {
  public static void main(String args[]) {
    new Solution().reverseString(new char[] { 'a', 'h', 'e', 'l', 'l', 'o' });
  }
}