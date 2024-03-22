// Ransom Note
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

import java.util.Arrays;

public class leet383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("ab", "aa"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            int matchingIndex = magazine.indexOf(ch);
            if (matchingIndex == -1)
                return false;
            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
        }
        return true;
    }
}
