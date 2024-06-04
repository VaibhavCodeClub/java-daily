// Find First Palindromic String in the Array
// Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

// A string is palindromic if it reads the same forward and backward.

public class leet2108 {
  public static void main(String[] args) {
    System.out.println(firstPalindrome(new String[] { "abc", "car", "", "racecar", "cool" }));
  }

  // Approach just take each String from the array and check if it is palindrome
  // or not if yes return it else if not a single String is palindrome return ""

  public static String firstPalindrome(String[] words) {
    for (String string : words) {
      if (isPalindromic(string))
        return string;
    }
    return "";
  }

  // To check if the String is paindrome or not take the left pointer and right
  // pointer Run the while loop until they pass each other if the character at
  // both the pointers is same continue the with increasing
  // left pointer value and decreasing right value if not same return false as it
  // is niot palindrome and when the loop terminates return true as we are not
  // returning true at all in the loop as all the comparisons are passed the
  // string is palindrome

  private static boolean isPalindromic(String string) {
    int left = 0;
    int right = string.length() - 1;
    while (left < right) {
      if (string.charAt(left) == string.charAt(right)) {
        left++;
        right--;
      } else
        return false;
    }
    return true;
  }
}
