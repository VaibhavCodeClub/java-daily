import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

  public static Set<Integer> findIntersection(int[] arr1, int[] arr2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> intersectionSet = new HashSet<>();

    // Add elements of the first array to the set
    for (int num : arr1) {
      set1.add(num);
    }

    // Check if elements of the second array are in the set
    for (int num : arr2) {
      if (set1.contains(num)) {
        intersectionSet.add(num);
      }
    }

    return intersectionSet;
  }

  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 2, 1 };
    int[] arr2 = { 2, 2 };

    Set<Integer> result = findIntersection(arr1, arr2);
    System.out.println("Intersection: " + result);
  }
}
