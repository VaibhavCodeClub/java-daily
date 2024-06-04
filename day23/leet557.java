// Reverse Words in a String III

// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

public class leet557 {
  public static void main(String[] args) {
    System.out.println(reverseWords("Let's take LeetCode contest"));
    System.out.println(reverseWords0("Let's take LeetCode contest"));
  }

  public static String reverseWords(String s) {
    String[] arr = s.split(" ");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = reverseEachWord(arr[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (String string : arr) {
      sb.append(string + " ");
    }
    return sb.toString().trim();
  }

  private static String reverseEachWord(String string) {
    StringBuilder sb = new StringBuilder(string);
    return sb.reverse().toString();
  }

  // Better approach for TC
  public static String reverseWords0(String s) {
    String[] arr = s.split(" ");
    StringBuilder result = new StringBuilder();
    for (String string : arr)
      result.append(new StringBuilder(string).reverse()).append(" ");
    return result.toString().trim();
  }
}
