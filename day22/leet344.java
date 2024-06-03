
import java.util.Arrays;
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
        System.gc();
    }
}

public class leet344{
  public static void main(String args[]){
    new Solution().reverseString(new char[]{'a','h','e','l','l','o'});
  }
}