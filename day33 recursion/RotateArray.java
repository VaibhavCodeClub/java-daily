import java.util.Arrays;

public class RotateArray {
  public static void main(String[] args) {
    int[] arr = { 22, 33, 44, 55 };
    int[] arr1 = { 22, 33, 44, 66, 55 };

    rotate(arr, 0, arr.length - 1);
    rotate1(arr1, 0);

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr1));
  }

  private static void rotate(int[] arr, int left, int right) {
    if (left >= right)
      return;
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    rotate(arr, left + 1, right - 1);
  }

  private static void rotate1(int[] arr, int left) {
    if (left >= arr.length / 2)
      return;
    int temp = arr[left];
    arr[left] = arr[arr.length - 1 - left];
    arr[arr.length - 1 - left] = temp;
    rotate1(arr, left + 1);
  }
}
