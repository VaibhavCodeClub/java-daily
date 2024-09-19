/*
Pubmatic 2
The Caesar Cipher involves shating all characters a string by a number to produce a new string, For instance, with a shift of 1 right, the string aficr becomes 'bcda'. Note that the rotation is circuler soz+1=a. This challerige involves a modification in that substrings within the string are shifted instead of the whole string. 

Consider a string s, composed of English lowercase letters ascii[a-z]. There are two kinds of operations you can perform on s

1. Roll Forward (right): i j R.

Every character in the substring s[i], s[i+1] ... s[j-1] will roll forward and be replaced with its next sequential alphabetical character (the next character after z is a). For example: a->b, m->n z->a.

2. Roll Backward (left):  i j L

Every character in the substring s[i], s[i+1] s[j] will roll backward and be replaced with its preceding alphabetical character (the character preceding a is z). For example: y<-z, m<-n,z<-a 
For example, given the string s-abc' and the following list of sequential operations

i j ch s
           abc
0 1 L zac
1 2 R zbd
0 2 R ace
The variable ch is the direction of the roll.

Function Description

Complete the function rolling String in the editor below. The function must return a string denoting the value of safter all operations have been performed.

9

rollingString has the following parameter(s) s: the initial string

10

operations[operations[0]...operations[n-1]; an array strings of three space-separated values: the integers I and j, and the character ch
Constraints

1<=|s|<=150


1<=n<=100

0<=I<=j<=|s|
ch is subset of (L, R)
Sample Input 0

STDIN Function Parameters

abc →s="abc"

3→ operations[] Size = 3

00L -> operations[] = [ "0 0 L", "2 2 L", "0 2 R"]
2 2 L
0 2 R
Sample Output 

acc
You are given string s and List<String> operations and return string in java
 */
import java.util.List;

public class RollingString {

    public static String rollingString(String s, List<String> operations) {
        char[] strArr = s.toCharArray();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            int i = Integer.parseInt(parts[0]);
            int j = Integer.parseInt(parts[1]);
            char direction = parts[2].charAt(0);

            if (direction == 'R') {
                for (int k = i; k <= j; k++) {
                    strArr[k] = rollForward(strArr[k]);
                }
            } else if (direction == 'L') {
                for (int k = i; k <= j; k++) {
                    strArr[k] = rollBackward(strArr[k]);
                }
            }
        }
        return new String(strArr);
    }
    private static char rollForward(char c) {
        if (c == 'z') {
            return 'a';
        } else {
            return (char) (c + 1);
        }
    }
    private static char rollBackward(char c) {
        if (c == 'a') {
            return 'z';
        } else {
            return (char) (c - 1);
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        List<String> operations = List.of("0 0 L", "2 2 L", "0 2 R");
        String result = rollingString(s, operations);
        System.out.println(result);
    }
}