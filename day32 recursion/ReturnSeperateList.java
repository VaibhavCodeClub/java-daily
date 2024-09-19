import java.util.ArrayList;

public class ReturnSeperateList {

  public static void main(String args[]) {
    System.out.print(search(new int[] { 11, 22, 33, 44, 22 }, 22, 0));
  }

  private static ArrayList<Integer> search(int[] arr, int target, int index) {
    ArrayList<Integer> list = new ArrayList<>();
    if (index == arr.length) return list;
    if (arr[index] == target) list.add(index);
    list.addAll(search(arr, target, ++index));
    return list;
  }
}
