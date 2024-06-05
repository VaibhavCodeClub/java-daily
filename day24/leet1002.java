// Find Common Characters
// Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1002 {
  public static void main(String[] args) {
    System.out.println(commonChars(new String[] { "cool", "lock", "cook" }));
  }

  public static List<String> commonChars(String[] words) {

    // This is the finalList to store the string characters as our return type is
    // List<String>
    List<String> finalList = new ArrayList<>();

    // If input array is empty return the empty list
    if (words == null || words.length == 0) {
      return finalList;
    }

    // Create a map to store all the intersecting elements
    Map<Character, Integer> countMap = new HashMap<>();

    // First iterate through the first string in the array and store the count of
    // its each character in the countMap
    for (char ch : words[0].toCharArray()) {
      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
    }

    // Now iterate through the remaining array (except 0th index)
    for (int i = 1; i < words.length; i++) {

      // Create the temprory map to store the count of current string characters
      Map<Character, Integer> tempMap = new HashMap<>();

      // Store the count of current string
      for (char ch : words[i].toCharArray()) {
        tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
      }

      // remove the kry from final map if the key is not present in tempMap
      countMap.keySet().removeIf(key -> !tempMap.containsKey(key));

      // Iterate through the keys of final map
      for (char key : countMap.keySet()) {
        // If that key is present in the temprory list then it is intersecting one
        // Keep the minimum value from both the list to the final list
        countMap.put(key, Math.min(countMap.get(key), tempMap.get(key)));
      }
    }
    
    // Iterate through the final list
    for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
      // iterte till we get all the common occurances to the list
      for (int i = 0; i < entry.getValue(); i++) {
        // Add that character by converting it to the string
        finalList.add(String.valueOf(entry.getKey()));
      }
    }
    return finalList;
  }
}
