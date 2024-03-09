// Write a function that takes in an array and returns true is the array is empty, otherwise false.

public class three {
    public static void main(String[] args) {
        System.out.println(isEmpty(new int[] { 1, 2, 4, 4 }));
    }

    private static boolean isEmpty(int[] arr) {
        return arr.length == 0 ? true : false;
    }
}
