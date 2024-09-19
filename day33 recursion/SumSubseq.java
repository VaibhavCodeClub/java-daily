// Here we have to find all the subsequences of an array whose sum is equal to N

import java.util.ArrayList;

public class SumSubseq {
  public static void main(String[] args) {
    function(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, new ArrayList<>(), 0, 0, 8);
  }

  private static void function(int[] arr, ArrayList<Integer> list, int sum, int index, int s) {

    if (index == arr.length) {
      if (sum == s)
        System.out.println(list);
      return;
    }

    list.add(arr[index]);
    function(arr, list, sum + arr[index], index + 1, s);

    list.remove(list.size() - 1);
    function(arr, list, sum, index + 1, s);
  }
}
