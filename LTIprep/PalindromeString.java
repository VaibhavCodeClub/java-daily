public class PalindromeString {

    public static void main(String[] args) {
        String s = "abdaba";

        int left = 0, right = s.length() - 1;
        boolean b = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                b = false;
                break;
            }
            left++;
            right--;
        }
        if (b) System.out.println("palin");
        else System.out.println("not");
    }
}
