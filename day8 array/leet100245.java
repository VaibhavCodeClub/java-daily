
// Maximum Length Substring With Two Occurrences
//  Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character. 
import java.util.HashMap;
import java.util.Map;

public class leet100245 {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("eebadadbfa"));
    }

    public static int maximumLengthSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);

                if (isValidSubstring(ss)) {
                    maxLen = Math.max(maxLen, ss.length());
                }
            }
        }
        return maxLen;
    }

    public static boolean isValidSubstring(String s) {
        Map<Character, Integer> occur = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = occur.getOrDefault(ch, 0);
            occur.put(ch, count + 1);
            if (count  >= 2) {
                return false;
            }
        }
        return true;
    }
}
