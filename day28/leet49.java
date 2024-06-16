// Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the aFnswer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet49 {
  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    System.out.println(groupAnagrams0(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    // Initialize a map to store the anagram groups
    Map<String, List<String>> ans = new HashMap<>();
    // Iterate over each string in the input array
    for (String string : strs) {
      // Create a character count array for the current string
      int[] count = new int[26];
      for (int i = 0; i < string.length(); i++) {
        count[string.charAt(i) - 'a']++;
      }
      // Convert the character count array to a string key
      String key = Arrays.toString(count);
      // Add the current string to the corresponding anagram group in the map
      ans.computeIfAbsent(key, k -> new ArrayList<>()).add(string);
    }
    // Return the list of anagram groups
    return new ArrayList<>(ans.values());
  }



    // Array of prime numbers used to represent each character from 'a' to 'z'.
    // Each letter is assigned a unique prime number, ensuring unique product for anagrams.
    private static final int[] PRIMES = new int[]{
      3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
      73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 
      157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 
      239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 
      331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 
      421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 
      509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 
      613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709
  };

  // Method to generate a unique key for a given string based on the product of prime numbers
  private static Integer getKey(String s) {
      int res = 1; // Initialize result to 1
      for (int i = 0; i < s.length(); i++) {
          // Multiply the current result by the prime number corresponding to the character
          res *= PRIMES[s.charAt(i) - 'a'];
      }
      return res; // Return the product as the key
  }

  public static List<List<String>> groupAnagrams0(String[] strs) {
      // Map to store lists of anagrams, keyed by their unique prime product key
      Map<Integer, List<String>> groups = new HashMap<>();
      
      for (String s : strs) {
          // Get the unique key for the current string
          Integer key = getKey(s);
          
          // Retrieve the group corresponding to the key, if it exists
          List<String> group = groups.get(key);
          
          // If the group doesn't exist, create a new one and add it to the map
          if (group == null) {
              group = new ArrayList<>();
              groups.put(key, group);
          }
          
          // Add the current string to the appropriate group
          group.add(s);
      }
      
      // Return the collection of grouped anagrams as a list of lists
      return new ArrayList<>(groups.values());
  }
}
