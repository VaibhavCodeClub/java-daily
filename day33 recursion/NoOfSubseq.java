// Here we have to find the number subsequences of an array whose sum is equal to N

public class NoOfSubseq {
  public static void main(String[] args) {
    System.out.println(function(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 0, 0, 8));
  }

  private static int function(int[] arr, int sum, int index, int s) {

    if (index == arr.length) {
      if (sum == s)
        return 1;
      return 0;
    }

    int l = function(arr, sum + arr[index], index + 1, s);

    int r = function(arr, sum, index + 1, s);
    return l + r;
  }
}
