// Minimum Remove to Make Valid Parentheses
/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
*/

import java.util.Arrays;

public class leet1249 {

  public static void main(String[] args) {
    System.out.println(minRemoveToMakeValid("))(("));
  }

  public static String minRemoveToMakeValid(String s) {
    char[] arr = s.toCharArray();
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(') {
        count++;
      } else if (arr[i] == ')') {
        if (count > 0) {
          count--;
        } else {
          arr[i] = 0;
        }
      }
    }count=0;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == ')') {
        count++;
      } else if (arr[i] == '(') {
        if (count > 0) {
          count--;
        } else {
          arr[i] = 0;
        }
      }
    }
System.out.println(Arrays.toString(arr));
    StringBuilder sb = new StringBuilder();
    for (char c : arr) {
      if (c != 0)
        sb.append(c);
    }

    return sb.toString();
  }
}