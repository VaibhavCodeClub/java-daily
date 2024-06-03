// Reverse Words in a String
/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
*/

public class leet151 {
  public static void main(String[] args) {
    System.out.print(reverseWords("  The   Sky is Blue   "));
  }

  public static String reverseWords(String s) {
    String[] words = s.split(" +");
    StringBuilder sb = new StringBuilder();
    for (String string : words) {
      sb.insert(0, string+' ');
    }
    return sb.toString().trim();
  }
}
