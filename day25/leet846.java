// Hand of Straights
// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet846 {
  public static void main(String[] args) {
    System.out.println(isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
  }

  public static boolean isNStraightHand(int[] hand, int groupSize) {
    // If the size of array in not multiple of the groupSize return false
    if (hand.length % groupSize != 0)
      return false;

    // Sort the array
    Arrays.sort(hand);

    // Create map to store the frequency of each unit from array
    Map<Integer, Integer> countMap = new HashMap<>();

    // Put frequency in the map
    for (int i : hand) {
      countMap.put(i, countMap.getOrDefault(i, 0) + 1);
    }

    // Forming groups
    for (int card : hand) {
      if (countMap.get(card) == 0) {
        continue; // Skip if this card is already used up in a previous group
      }

      // Try to form a group starting with 'card'
      for (int i = 0; i < groupSize; i++) {
        // Loop from 0 to the length given to form the group
        int currentCard = card + i;
        if (countMap.getOrDefault(currentCard, 0) == 0) {
          return false; // If the card needed is not available, return false
        }
        // Decrease the count of the current card
        countMap.put(currentCard, countMap.get(currentCard) - 1);
      }
    }
    // If no false is returned then we have successfully formed groups return true
    return true;
  }
}
