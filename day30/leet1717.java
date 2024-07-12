// Maximum Score From Removing Substrings
/*
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

  Remove substring "ab" and gain x points.
      For example, when removing "ab" from "cabxbae" it becomes "cxbae".
  Remove substring "ba" and gain y points.
      For example, when removing "ba" from "cabxbae" it becomes "cabxe".

Return the maximum points you can gain after applying the above operations on s.
*/

public class leet1717 {
  public static void main(String[] args) {
    System.out.println(maximumGain("bbaaabab", 4, 5));
  }

  public static int point(StringBuilder s, String target, int p) {
    int total = 0;
    StringBuilder str = new StringBuilder();
    for (char c : s.toString().toCharArray()) {
      if (str.length() > 0 && (str.charAt(str.length() - 1) + "" + c).equals(target)) {
        str.deleteCharAt(str.length() - 1);
        total += p;
      } else {
        str.append(c);
      }
    }
    s.setLength(0);
    s.append(str);
    return total;
  }

  public static int maximumGain(String s, int x, int y) {
    String s1 = "ab", s2 = "ba";
    if (y > x) {
      String temp = s1;
      s1 = s2;
      s2 = temp;
      int temp2 = x;
      x = y;
      y = temp2;
    }
    StringBuilder sb = new StringBuilder(s);
    return point(sb, s1, x) + point(sb, s2, y);
  }
}
