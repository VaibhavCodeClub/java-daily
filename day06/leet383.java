// Ransom Note
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

import java.util.HashMap;

public class leet383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("ab", "aba"));
        System.out.println(canConstruct0("ab", "aa"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // This is a straight forward approach hence requires more time as well space
        for (int i = 0; i < ransomNote.length(); i++) {
            // Just iterate through the ransomnote
            char ch = ransomNote.charAt(i);// Fetch the current character from ransom note

            int matchingIndex = magazine.indexOf(ch); // Check if that character is present in the magazine or not
            if (matchingIndex == -1)
                // if not found that indexOf function gives -1 so if not found return false
                return false;
            // else remove that character from the magazine and continue
            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
            // for removing that character just use simple approach
            // from 0th index to matchingIndex-1 and from matchingIndex+1 to end index split
            // the string and concatenate it
        }
        return true;
    }
    // Time complexity is O(n.m)
    // Space complexity is O(m)

    public static boolean canConstruct0(String ransomNote, String magazine) {
        // Create an empty hashmap to store the character in the magazine and its
        // appearance / count
        HashMap<Character, Integer> magazineLetters = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            // Iterate through the magazine and fetch each character from magazine
            char m = magazine.charAt(i);
            // set the current count of that letter else by default keep it as zero
            int currentCount = magazineLetters.getOrDefault(m, 0);
            // during storing that character into the HashMap increase the count by one
            // meaning by default if will become 1
            magazineLetters.put(m, currentCount + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            // This is retrival phase iterate through the ransome note
            char r = ransomNote.charAt(i); // Fetchc every character
            int currentCount = magazineLetters.getOrDefault(r, 0);
            // set its count to zero if that element is not found in the HashMap else fetch
            // that value and store it in currentCount
            if (currentCount == 0) {
                return false;
                // if the current count is zero in magazine HashMap just return the false as on
                // of the letter is not found in magazine from ransom note
            }
            // else just negate 1 from the count of that character from HashMap
            magazineLetters.put(r, currentCount - 1);
        }
        return true;
    }
    // Time complexity is O(m)
    // Space complexity is O(k) i.e. O(1)
}