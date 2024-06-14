// Maximum Number of Words Found in Sentences
// A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

// You are given an array of strings sentences, where each sentences[i] represents a single sentence.

// Return the maximum number of words that appear in a single sentence.

public class leet2114 {
  public static void main(String[] args) {
    System.out.println(mostWordsFound(
        new String[] { "alice and bob love leetcode", "i think so too", "this is great thanks very much" }));
    System.out.println(mostWordsFound00(
        new String[] { "alice and bob love leetcode", "i think so too", "this is great thanks very much" }));
  }

  public static int mostWordsFound(String[] sentences) {
    // Stolen from jagtapanjali00
    int count = 0;
    for (String string : sentences)
      count = Math.max(count, (string.split(" ").length));
    return count;
  }

  private static int wordCount(String s) {
    int currentCount = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == ' ')
        currentCount++;
    return currentCount + 1;
  }

  public static int mostWordsFound00(String[] sentences) {
    int count = 0;
    for (String string : sentences) {
      count = Math.max(wordCount(string), count);
    }
    return count;
  }
}
