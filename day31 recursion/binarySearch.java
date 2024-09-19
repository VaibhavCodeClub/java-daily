public class binarySearch {
  public static void main(String[] args) {
    System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 0, 6, 4));
  }

  private static int search(int[] arr, int start, int end, int target) {
    if (start > end)
      return -1;

    int mid = start + (end - start) / 2;
    if (arr[mid] == target)
      return mid;

    if (arr[mid] > target)
      return search(arr, start, mid - 1, target);
    return search(arr, mid + 1, end, target);
  }
}
