// Count Substrings Starting and Ending with Given Character
// You are given a string s and a character c. Return the total number of substrings of s that start and end with c.

public class leet100236 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("muqgsjvmm", 'j'));
    }

    public static long countSubstrings(String s, char c) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                if (ss.charAt(0) == c && ss.charAt(ss.length() - 1) == c) {
                    count++;
                }
            }

        }
        return count;

    }
}
