/**
 abba
 bbaa
 */
public class EqualStrings {

    public static void main(String[] args) {
        String first = "abba", second = "baaa";

        if (first.length() != second.length()) {
            System.out.println(false);
        }

        int[] arr = new int[26];

        for (char ch : first.toCharArray()) {
            int curr = ch;
            arr[curr - 97]++;
        }
        // [-1,1,0,0,0]
        for (char ch : second.toCharArray()) {
            int curr = ch;
            arr[curr - 97]--;
        }

        boolean b = true;
        for (int i : arr) {
            if (i != 0) b = false;
        }

        if (b) System.out.println("equwal");
        else System.out.println("not");
    }
}
