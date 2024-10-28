import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    // System.out.println(Arrays.toString(mergeSort(new int[]{55,22,66,99,11,3,2,10},0,8)));
    int[] arr = new int[] { 55, 22, 66, 99, 11, 3, 2, 10 };
    mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  static void mergeSort(int[] arr, int low, int high) {
    if (low >= high) return;
    int mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);

    merge(arr, low, mid, high);
  }

  static void merge(int[] arr, int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    int index = 0;
    int[] temp = new int[arr.length];
    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp[index++] = arr[left];
        left++;
      } else {
        temp[index++] = arr[right];
        right++;
      }
    }
    while (left <= mid) {
      temp[index++] = arr[left];
      left++;
    }
    while (right <= high) {
      temp[index++] = arr[right];
      right++;
    }
    for (int i = low; i <= high; i++) {
      arr[i] = temp[i - low];
    }
  }
}
