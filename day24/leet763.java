// Number of Arithmetic Triplets
/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.
*/

// Obviously not done by me I got th solution from youtube video

import java.util.ArrayList;
import java.util.List;

public class leet763 {
  public static void main(String[] args) {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
  }

  public static List<Integer> partitionLabels(String s) {

    // Create the List as out returnType of the function is List
    List<Integer> partitions = new ArrayList<>();

    for (int i = 0; i < s.length();) {
      // Get first and last occurance of the first character
      int startIndex = i;
      int endIndex = s.lastIndexOf(s.charAt(startIndex));

      for (int j = startIndex; j <= endIndex - 1; j++) {
        // Find last index of any sunsequent characters
        int lastIndexOfNextChar = s.lastIndexOf(s.charAt(j));
        if (lastIndexOfNextChar > endIndex) {
          // If that ast index is greater than existing endIndex replace it
          endIndex = lastIndexOfNextChar;
        }
      }
      // Add the length of current string to the output list as we are converting
      // index to length add 1
      partitions.add(endIndex - startIndex + 1);

      // Move i to the endIndex such that loop will continue from the end of existing
      // substring
      i = endIndex + 1;
    }
    // return the list
    return partitions;
  }
}
