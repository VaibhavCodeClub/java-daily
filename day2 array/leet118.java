// Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

import java.util.ArrayList;
import java.util.List;

public class leet118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        if (numRows == 0)
            return tri;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        tri.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = tri.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            tri.add(cur);
        }
        return tri;
    }
}
