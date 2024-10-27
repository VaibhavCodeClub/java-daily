// Add to Array-Form of Integer
/*
The array-form of an integer num is an array representing its digits in left to right order.
For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet989 {
  public static void main(String[] args) {
    System.out.println(addToArrayForm(new int[] { 2,1,5 }, 806));
    System.out.println(addToArrayForm0(new int[] {2,1,5 }, 806));
  }

  public static List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> returnList = new ArrayList<>();
    int carry = 0, p = num.length - 1;

    while (p >= 0 || k > 0) {
      int numval = 0;if (p >= 0) {
        numval = num[p];
      }
      int last = k % 10;
      k /= 10;
      int sum = numval + last + carry;
      returnList.add(0, sum % 10);
      carry = sum / 10;
      p--;
    }
    if (carry > 0)
      returnList.add(0, carry);
    return returnList;
  }
  public static List<Integer> addToArrayForm0(int[] num, int k) {
    List<Integer> ans = new ArrayList<>();
    int p = num.length - 1;
    int carry = 0;
    while (p >= 0 || k > 0) {
      int numval = 0;
      if (p >= 0) {
        numval = num[p];
      }
      int d = k % 10; // it is the last digit from k
      int sum = numval + d + carry;
      carry = sum / 10;
      ans.add(sum % 10);
      p--; // moving the pointer
      k = k / 10; // removing the last digit from k
    }

    if (carry > 0) {
      ans.add(carry); // adding carry to the array list
    }

    Collections.reverse(ans); // reversing the ans array list
    return ans;
  }
}
