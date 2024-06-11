// Minimum Number of Swaps to Make the String Balanced
/*
You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:
 It is the empty string, or
 It can be written as AB, where both A and B are balanced strings, or
 It can be written as [C], where C is a balanced string.

You may swap the brackets at any two indices any number of times.
Return the minimum number of swaps to make s balanced.
*/

public class leet1963 {
  public static void main(String[] args) {
    System.out.println(minSwaps("]]][[["));
    System.out.println(minSwaps00("]]][[["));
  }

  public static int minSwaps(String s) {
    int openingCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '[')
        openingCount++;
      else if (openingCount > 0)
        openingCount--;
    }
    return (openingCount + 1) / 2;
  }

  public static int minSwaps00(String s) {
    int openBrackets = 0, mismatched = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '[')
        openBrackets++;
      else { // If there are any open brackets to match it (openBrackets > 0), decrement the
             // openBrackets or increase mismatch count otherwise, increment the mismatched
             // count.
        if (openBrackets > 0) {
          openBrackets--;
        } else
          mismatched++;
      }
    }
    mismatched += openBrackets; // if still unmatched brackets add them to mismatch count and diveide by 2 to
                                // get pairs
    mismatched /= 2;
    return (mismatched + 1) / 2; // add 1 required to handle odd no mismatch brackets & divide by 2 since swap
                                 // involves 2 mismatched brackets
  }
}
