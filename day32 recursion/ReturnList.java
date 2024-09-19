import java.util.ArrayList;

public class ReturnList {

  public static void main(String args[]) {
    System.out.print(
      search(new int[] { 1, 2, 33, 44, 33 }, 2, 0, new ArrayList<>())
    );
  }

  private static ArrayList<Integer> search(
    int[] arr,
    int target,
    int index,
    ArrayList<Integer> list
  ) {
    if (index == arr.length) return list;
    if (arr[index] == target) list.add(index);
    return search(arr, target, ++index, list);
  }
}
