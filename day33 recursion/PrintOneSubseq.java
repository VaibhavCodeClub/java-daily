// Here we have to find only one subsequence of an array whose sum is equal to N

import java.util.ArrayList;

public class PrintOneSubseq {
  public static void main(String[] args) {
    function(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new ArrayList<>(), 0, 0, 8);
  }

  private static boolean function(int[] arr, ArrayList<Integer> list, int sum, int index, int s) {

    if (index == arr.length) {
      if (sum == s) {
        System.out.println(list);
        return true;
      }
      return false;
    }

    list.add(arr[index]);
    if (function(arr, list, sum + arr[index], index + 1, s) == true)
      return true;

    list.remove(list.size() - 1);
    if (function(arr, list, sum, index + 1, s) == true)
      return true;
    return false;
  }
}
