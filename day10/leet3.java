// Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.

import java.util.HashMap;
import java.util.Map;

public class leet3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, count = 0; // Initialize the values
        Map<Character, Integer> str = new HashMap<>();// HashMap to store the count of elements

        while (end < s.length()) { // Iterate the entire string
            char currentChar = s.charAt(end); // Fetch the current character from the string
            if (str.containsKey(currentChar) && str.get(currentChar) >= start) {
                // If that character is already present in the HashMap and as well that
                // currentChar is not the first element of that substring the
                start = str.get(currentChar) + 1;
                // Move the start to the next of currentChar's previous occurance such that it
                // must occur only once
            }
            str.put(currentChar, end); // Put that current in the HashMap and its last occuranc as end
            count = Math.max(count, end - start + 1); // Count = max among current count and end- start +1
            end++;
        }
        return count;
    }
}
