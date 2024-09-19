import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

  public static int[] removeDuplicates(int[] arr) {
    Set<Integer> uniqueElements = new LinkedHashSet<>();

    // Add elements to the LinkedHashSet to automatically remove duplicates
    for (int num : arr) {
      uniqueElements.add(num);
    }

    // Convert the set back to an array
    int[] result = new int[uniqueElements.size()];
    int index = 0;
    for (int num : uniqueElements) {
      result[index++] = num;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 4, 4, 5, 2, 2 };
    int[] result = removeDuplicates(arr);

    // Print the result
    System.out.print("Array after removing duplicates: ");
    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}
