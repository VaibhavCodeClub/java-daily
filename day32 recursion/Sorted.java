public class Sorted {

  public static void main(String args[]) {
    System.out.println(isSorted(new int[] { 1, 2, 3, 4 }));
    System.out.print(isSorted(new int[] { 1, 0, 3, 4 }));
  }

  private static boolean isSorted(int[] arr) {
    return helper(arr, 0);
  }

  private static boolean helper(int[] arr, int index) {
    if (index == arr.length - 1) return true;
    return (arr[index] <= arr[index + 1]) && helper(arr, ++index);
  }
}
