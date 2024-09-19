// Lucky Numbers in a Matrix
// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

// A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

import java.util.ArrayList;
import java.util.List;

public class leet1380 {

  public static void main(String args[]) {
    ;
    System.out.println(luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));
  }

  public static List<Integer> luckyNumbers(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i]<matrix[j]) {
          
        }
      }
    }
  }
}
