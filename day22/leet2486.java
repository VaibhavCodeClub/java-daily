// Append Characters to String to Make Subsequence
// You are given two strings s and t consisting of only lowercase English letters.

// Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.

// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

public class leet2486 {
  public static void main(String[] args) {
    System.out.println(appendCharacters("coaching", "coding"));
  }

  public static int appendCharacters(String s, String t) {
    int first = 0, second = 0;
    int firstEnd = s.length(), secondEnd = t.length();

    while (first < firstEnd && second < secondEnd) {
      if (s.charAt(first) == t.charAt(second)) {
        first++;
        second++;
      } else
        first++;
    }
    
    return secondEnd-second;
  }
}
