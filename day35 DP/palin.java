public class palin {

  private static boolean isPalin(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String args[]) {
    System.out.println(isPalin("aabcbaa"));
    System.out.print(isPalin(""));
  }
}
