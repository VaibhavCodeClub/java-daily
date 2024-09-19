//Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
import java.util.ArrayList;
import java.util.List;

public class leet22 {
  public static void main(String[] args) {
    System.out.println(generateParenthesis(2));
  }

  private static List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtrack(res, new StringBuilder(), 0, 0, n);
    return res;
  }

  private static void backtrack(List<String> res, StringBuilder sb, int open, int close, int max) {
    if (sb.length() == max * 2) {
      res.add(sb.toString());
      return;
    }
    if (open < max) {
      sb.append("(");
      backtrack(res, sb, open + 1, close, max);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      sb.append(")");
      backtrack(res, sb, open, close + 1, max);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
