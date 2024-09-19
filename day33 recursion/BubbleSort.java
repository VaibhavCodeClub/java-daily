import java.util.Arrays;

public class BubbleSort {

  public static void main(String args[]) {
    int[] arr = { 44, 33, 22, 55, 66 };
    sort(arr, arr.length - 1, 0);
    System.out.print(Arrays.toString(arr));
  }

  private static void sort(int[] arr, int r, int c) {
    if (r == 0) return;
    if (c < r) {
      if (arr[c] > arr[c + 1]) {
        int temp = arr[c];
        arr[c] = arr[c + 1];
        arr[c + 1] = temp;
      }
      sort(arr, r, c + 1);
    } else sort(arr, r - 1, 0);
  }
}
