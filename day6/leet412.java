// Fizz Buzz

/*
 * Given an integer n, return a string array answer (1-indexed) where:
 * 
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class leet412 {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // ret.add(i % 5 == 0 && i % 3 == 0 ? "FizzBuzz"
            // : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i));

            ret.add(i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i));
        }
        return ret;
    }
}
// Time complexity O(n) as we iterate only once using for loop
// Space complexity O(1) as we create a single list to store Strings of length n
// but it is not considered as complexity