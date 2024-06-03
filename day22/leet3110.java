// Score of a String
// You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

// Return the score of s.

public class leet3110 {
  public static void main(String[] args) {
    System.out.println(scoreOfString(""));
  }

  public static int scoreOfString(String s) {
    int sum = 0;
    int[] arr = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      arr[i] = s.charAt(i);
    }
    for (int i = 0; i < arr.length - 1; i++) {
      sum += Math.abs(arr[i] - arr[i + 1]);
    }
    return sum;
  }
}
