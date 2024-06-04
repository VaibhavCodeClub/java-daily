// Longest Palindrome
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

import java.util.HashMap;
import java.util.Map;

public class leet409 {
  public static void main(String[] args) {
    System.out.println(longestPalindrome0("abccccdd"));
  }

  public static int longestPalindrome(String s) {
    // Here in this approach we are storing count of each character in the HashMap
    // and add the all even elements directly to the length of final palindrome and
    // if there is a character whose occurance is odd times then add that odd number
    // by negaing 1 from it as it makes even occurances and set the boolean value
    // hasOddCount to true as at the end we can add 1 to the final length as in
    // Palindrome centre can occur only once

    // This is slow approach
    // Map to store all the characters and their occcurances
    Map<Character, Integer> countMap = new HashMap<>();

    // Iterate through the string and store the count of each character
    for (Character character : s.toCharArray()) {
      countMap.put(character, countMap.getOrDefault(character, 0) + 1);
    }
    // creating variables to final length and get the occurance of odd element
    int totalLengthOfThePalindrome = 0;
    boolean hasOddCount = false;

    // Iterate through the Map and get the value of each character
    for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
      // Store that value in a variable
      int value = entry.getValue();
      // If the count is even add it to the final length
      if (value % 2 == 0)
        totalLengthOfThePalindrome += value;
      else {
        // If it is odd then negate 1 from it and add it to the final count as negating
        // one from odd makes it even
        totalLengthOfThePalindrome += value - 1;
        // And change the boolean value to true
        hasOddCount = true;
      }
    }
    // If there was odd then add 1 to final length
    if (hasOddCount)
      totalLengthOfThePalindrome++;

    return totalLengthOfThePalindrome;
  }

  // Here is faster approach

  // Here we are storing occurance of each character in the Array
  // First create an darray of length 58 as all uppercase and lowercase characters
  // count upto 58
  // Then store each of the character from the string at the index of character -
  // 'A' as ASCII codes matters
  // Then iterate through that array with the simplar approach above

  public static int longestPalindrome0(String s) {
    // Create array of length 58 to store occurances of each character
    int[] arr = new int[58];
    // Iterate through the String and increase the value at the respected index
    for (char ch : s.toCharArray()) {
      arr[ch - 'A']++;
    }
    // Declare variables one for length of palindrome and another to get the odd
    // count
    int totalLengthOfThePalindrome = 0;
    boolean hasOddCount = false;

    // Iterate throgh above array
    for (int i : arr) {
      // If the current value in array is even
      if (i % 2 == 0)
        // Add it to the final count
        totalLengthOfThePalindrome += i;
      else {
        // If the value is odd then add value -1 to the final count
        totalLengthOfThePalindrome += i - 1;
        // And as always set the hasOddCount to true to add 1 at the end
        hasOddCount = true;
      }
    }
    // If there is odd count add 1 to the final length
    if (hasOddCount)
      totalLengthOfThePalindrome++;
    // Return the final length
    return totalLengthOfThePalindrome;
  }
}