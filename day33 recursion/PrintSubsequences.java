import java.util.ArrayList;

public class PrintSubsequences {
  public static void main(String[] args) {
    print(new int[] { 3, 1, 2 }, new ArrayList<>(), 0);
  }

  private static void print(int[] arr, ArrayList<Integer> list, int index) {
    if (index >= arr.length) {
      System.out.println(list);
      return;
    }
    // Add current element to the list
    list.add(arr[index]);
    // and call the function again with taking the current element
    print(arr, list, index + 1);

    // remove the recently added element
    list.remove(list.size() - 1);
    // call the function such that it becomes the function call without taking
    // current element
    print(arr, list, index + 1);
  }
}

// Time complexity for above program is O(n^2)*n
// and space complexity is O(n)