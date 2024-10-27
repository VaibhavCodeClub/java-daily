public class palindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome(""));
  }

  private static boolean isPalindrome(String string) {
    int left = 0;
    int right = string.length() - 1;
    while (right > left) {
      if (string.charAt(right) != string.charAt(left)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
