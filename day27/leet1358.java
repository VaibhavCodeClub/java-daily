// Number of Substrings Containing All Three Characters
// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

public class leet1358 {
  public static void main(String[] args) {
    System.out.println(numberOfSubstrings(
        "bbacba"));
    System.out.println(numberOfSubstrings00(
        "bbacba"));
    System.out.println(numberOfSubstrings(
        "abc"));
  }
  // This approach is too slow such that it gives TLE
  // i.e. O(n^2)

  public static int numberOfSubstrings(String s) {
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      int[] hashArray = new int[3];
      for (int j = i; j < s.length(); j++) {
        hashArray[s.charAt(j) - 'a'] = 1;
        if (hashArray[0] + hashArray[1] + hashArray[2] == 3) {
          count++;
        }
      }
    }

    return count;
  }

  public static int numberOfSubstrings00(String s) {
    int count = 0;
    int[] arr = new int[] { -1, -1, -1 };
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a'] = i;

      int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
      count += (min + 1);

    }
    return count;
  }
}
