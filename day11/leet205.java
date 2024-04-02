// Isomorphic Strings
// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to
// get t.

// All occurrences of a character must be replaced with another character while
// preserving the order of characters. No two characters may map to the same
// character, but a character may map to itself.

import java.util.HashMap;
import java.util.Map;

/**
 * leet205
 */
public class leet205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("BADC", "BABA"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stoMap = new HashMap<>(); // Map to store all characters from the s and their
                                                            // respected character from t
        for (int i = 0; i < s.length(); i++) {
            // Iterate through entire s as s.length() == t.length()

            // Fetch current characters from both strings
            char currentS = s.charAt(i);
            char currentT = t.charAt(i);

            // If the key is already present in map names currentS
            if (stoMap.containsKey(currentS)) {
                // And currrent charater from t is not similar to that stored character then
                // retun false
                if (stoMap.get(currentS) != currentT)
                    return false;
            } else {
                // Else if the map contains the value which is similar to current t value
                if (stoMap.containsValue(currentT)) {
                    for (Map.Entry<Character, Character> entry : stoMap.entrySet()) {
                        // loop that iterates over each key-value pair in the map stoMap. During each
                        // iteration, the loop variable entry represents the current key-value pair,
                        // allowing you to access both the key and value of the map's entries within the
                        // loop's body.

                        if (entry.getValue() == currentT && entry.getKey() != currentS)
                            // if the value of already present pair is equal to t but its key is not equal
                            // to s then return false
                            return false;
                    }
                }
                // If both the above conditions are false then just pu the current s haracter as
                // key and t as value
                stoMap.put(currentS, currentT);
            }
        }
        System.out.println(stoMap);
        return true;
    }
}