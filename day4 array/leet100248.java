// Existence of a Substring in a String and Its Reverse
// Given a string s, find any substring of length 2 which is also present in the reverse of s.

// Return true if such a substring exists, and false otherwise.

public class leet100248 {
    public static void main(String[] args) {
        System.out.println(isSubstringPresent("leetcode"));
    }

    public static boolean isSubstringPresent(String str) {
        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            rev = ch + rev;}
        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j <= str.length(); j++) {
                String ss = str.substring(i, j);
                if (rev.contains(ss) && ss.length() > 1) {
                    return true;
                }
            }

        }
        return false;
    }
}
