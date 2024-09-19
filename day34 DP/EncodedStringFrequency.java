/*
Pubmatic 1 
Long Encoded String
Consider a string that consists of lowercase English letters (i.e., [a-z]) only. The following rules are used to encode all of its characters into the string s
a is encoded as 1, bis encoded as 2, cis encoded as 3,..., and is encoded as 9
jis encoded as 10#, kis encoded as 11 lis

encoded as 12#,.... and zis encoded as 26. If any character occurs two or more consecutively its count immediately follows the encoded character in parentheses, e.g. 'aa' is encoded as 1(2).
Examples

• String "abzx" is encoded as s = "1226#24

• String "aabccc" is encoded as s = "1(2)23/3/

String "bajj" is encoded as s = "2110#(2)"

• String "wwxyzwww"is encoded as s = "23# (2)24#25#26#23#(3)
Given an encoded string s, determine the character counts for each letter of the original, decoded string. Return array of 26 integers where index O contains the number of a
characters, index I contains the number of b characters, and so on.

Function Description

Complete the frequency function in the editor below.

frequency has the following parameter: string s: an encoded string
Return

int[26]: the character frequencies as described

Constraints

String s consists of decimal integers from 0to9 #s and ()s only.

• 1 <= length of s≤10^5

• It is guaranteed that string s is a valid encoded string.

2<=c≤10^4, where c is a parenthetical count of consecutive occurrences of an encoded character
Sample Input For Custom Testing

1226#24#

Sample Output 0

1100000000000005081

public static List<Integer> frequency(String s) {



// Write your code here}
 */
import java.util.ArrayList;
import java.util.List;

public class EncodedStringFrequency {
    public static void main(String args[]){
        System.out.print(frequency("23#(2)24#25#26#23#(3)"));
    }
    public static List<Integer> frequency(String s) {
        int[] freq = new int[26];
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                i += 3;
                if (i < s.length() && s.charAt(i) == '(') {
                    int end = s.indexOf(')', i);
                    int count = Integer.parseInt(s.substring(i + 1, end));
                    freq[num - 1] += count;
                    i = end + 1; 
                } else {
                    freq[num - 1]++;
                }
            } else {
                int num = s.charAt(i) - '0';
                i++;
                if (i < s.length() && s.charAt(i) == '(') {
                    int end = s.indexOf(')', i);
                    int count = Integer.parseInt(s.substring(i + 1, end));
                    freq[num - 1] += count;
                    i = end + 1;
                } else {
                    freq[num - 1]++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int count : freq) {
            result.add(count);
        }
        return result;
    }
}