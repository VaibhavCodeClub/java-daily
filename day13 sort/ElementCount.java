import java.util.HashMap;
import java.util.Map;

public class ElementCount {

  public static Map<Integer, Integer> countOccurrences(int[] arr) {
    Map<Integer, Integer> countMap = new HashMap<>();

    // Traverse the array and count the occurrences of each element
    for (int num : arr) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    //{{1,1},{2,2}}

    return countMap;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 2, 3, 4, 4, 5, 5, 5 };
    Map<Integer, Integer> result = countOccurrences(arr);

    // Print the result
    System.out.println("Element Occurrences: ");
    for (int entry : result.keySet()) {
      System.out.println(entry + ": " + result.get(entry));
    }
  }
}
