import java.util.Arrays;

public class SelectionSort {

  public static void main(String args[]) {
    int[] arr = { 44, 33, 22, 55, 66 };
    sort(arr, arr.length - 1, 0, 0);
    System.out.print(Arrays.toString(arr));
  }

  private static void sort(int[] arr, int r, int c, int max) {
    if (r == 0) return;
    if (c < r) {
      if (arr[c] > arr[max]) sort(arr, r, c + 1, c);
      else sort(arr, r, c + 1, max);
    } else {
      int temp = arr[max];
      arr[max] = arr[r - 1];
      arr[r - 1] = temp;
      sort(arr, r - 1, 0, 0);
    }
  }
}
