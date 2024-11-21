public class BinarySearch {
  public static void main(String[] args) {

    int arr[] = { 1, 2, 3, 5, 6, 7, 8, 9, 100 };

    int left = 0, right = arr.length-1, target = 1;
    boolean found = false;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        System.out.println(mid);
        found = true;
        break;
      }
      if (arr[mid] > target) {
        right = mid - 1;

      } else {
        left = mid + 1;
      }
    }
    if (!found)
      System.out.println("not found");
  }
}
