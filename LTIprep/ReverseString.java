/**
 * ReverseString
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "Vaishnavi";

        // Simple
        StringBuilder sb = new StringBuilder(s).reverse();
        System.out.println(sb);

        // Complex
        StringBuilder sb1 = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb1.insert(0, ch);
        }
        System.out.println(sb1);
    }
}
