import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = { 32, 11, 45, 67, 1 };

    for (int i = 0; i < arr.length - 1; i++) {
      int last = arr.length - i - 1;

      int maxIndex = getMax(arr, last);

      int temp = arr[maxIndex];
      arr[maxIndex] = arr[last];
      arr[last] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }

  static int getMax(int[] arr, int index) {
    int max = 0;
    for (int i = 0; i <= index; i++) {
      max = arr[max] < arr[i] ? i : max;
    }
    return max;
  }
}
