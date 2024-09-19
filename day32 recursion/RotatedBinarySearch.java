public class RotatedBinarySearch {

  public static void main(String args[]) {
    System.out.print(search(new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 5, 0, 7));
  }

  private static int search(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;

    if (arr[left] <= arr[mid]) {
      if (target >= arr[left] && target <= arr[mid]) right = mid - 1;
      else left = mid + 1;
    } else {
      if (target >= arr[mid] && target <= arr[right]) left = mid + 1;
      else right = mid - 1;
    }
    return search(arr, target, left, right);
  }
}
