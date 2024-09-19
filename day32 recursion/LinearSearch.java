public class LinearSearch {

  public static void main(String args[]) {
    System.out.println(search(new int[] { 11, 33, 44, 2 }, 23));
    System.out.println(searchIndex(new int[] { 11, 33, 44, 2 }, 2));
    System.out.println(searchFromLast(new int[] { 11, 33, 44, 2 }, 12));
  }

  private static boolean search(int[] arr, int target) {
    return helper(arr, target, 0);
  }

  private static boolean helper(int[] arr, int target, int index) {
    if (index == arr.length) return false;
    if (arr[index] == target) return true;
    return helper(arr, target, ++index);
  }

  private static boolean searchFromLast(int[] arr, int target) {
    return lastHelper(arr, target, arr.length - 1);
  }

  private static boolean lastHelper(int[] arr, int target, int index) {
    if (index == -1) return false;
    if (arr[index] == target) return true;
    return lastHelper(arr, target, --index);
  }

  private static int searchIndex(int[] arr, int target) {
    return indexHelper(arr, target, 0);
  }

  private static int indexHelper(int[] arr, int target, int index) {
    if (index == arr.length) return -1;
    if (arr[index] == target) return index;
    return indexHelper(arr, target, ++index);
  }
}
