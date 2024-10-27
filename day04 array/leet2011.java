// Final Value of Variable After Performing Operations
/*
There is a programming language with only four operations and one variable X:

    ++X and X++ increments the value of the variable X by 1.
    --X and X-- decrements the value of the variable X by 1.

Initially, the value of X is 0.

Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 */
public class leet2011 {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[] { "--X", "X++", "X++" }));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for (String string : operations) {
            if (string.contains("++"))
                count++;
            else
                count--;
        }
        return count;
    }
}
