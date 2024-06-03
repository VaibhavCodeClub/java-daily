// Reverse Vowels of a String
// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet345 {
  public static void main(String[] args) {
    System.out.println(reverseVowels("hello"));
    System.out.println(reverseVowels2("hello"));
  }

  public static String reverseVowels(String s) {
    char[] ss = s.toCharArray(); // Converting String to charArray

    // Creating a list of all vowels both upper and lowercase
    List<Character> vowels = new ArrayList<>(Arrays.asList(
        'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    // Define start and end to iterate through all the charArray
    int start = 0, end = s.length() - 1;

    // While start is smaller than the end iterate suing two pointers
    while (start < end) {
      // If values at both the pointers is vowel then swap them and increase the start
      // and reduce the end
      if (vowels.contains(ss[start]) && vowels.contains(ss[end])) {
        char temp = ss[start];
        ss[start] = ss[end];
        ss[end] = temp;
        start++;
        end--;

      }
      // Else if only start is vowel then decrease the end
      else if (vowels.contains(ss[start]))
        end--;
      // Else the char at the end is vowel then increase the start
      else
        start++;
    }
    // At the end return the charArray as String
    return String.valueOf(ss);
  }

  // this approach is slower one takes 12 ms while simpler approach takes 2ms
  // Below is the most optimal one

  private static boolean isVowel(char c) {
    // This function is to only check the passed character is vowel or not
    return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o'
        || c == 'u');
  }

  public static String reverseVowels2(String s) {
    char[] s1 = s.toCharArray();// Converting String to charArray
    // Initialising start and end
    int i = 0;
    int j = s.length() - 1;

    // Iterate suing 2 pointers
    while (i < j) {
      while (!isVowel(s1[i]) && i < j) {
        // If the character at i is not vowel then increment i till i<j
        i++;
      }
      while (!isVowel(s1[j]) && j > i) {
        // If the character at j is not vowel then decrement j till i<j
        j--;
      }

      if (i < j) {
        // Swap the vowels
        char c2 = s1[i];
        s1[i] = s1[j];
        s1[j] = c2;
        i++;
        j--;
      }
    }
    return String.valueOf(s1);

  }
}
