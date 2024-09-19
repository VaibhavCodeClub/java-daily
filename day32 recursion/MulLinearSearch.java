import java.util.ArrayList;
import java.util.List;

public class MulLinearSearch {

  public static void main(String args[]) {
    search(new int[] { 1, 2, 33, 4, 55, 6, 55 }, 1, 0);
    System.out.print(list);
  }

  static List<Integer> list = new ArrayList<>();

  private static void search(int[] arr, int target, int index) {
    if (index == arr.length) return;
    if (arr[index] == target) list.add(index);
    search(arr, target, ++index);
  }
}
