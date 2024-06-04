// Flipping an Image
/*
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.
    For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
    For example, inverting [0,1,1] results in [1,0,0].
*/

public class leet832 {
  public static void main(String[] args) {
    System.out
        .println(flipAndInvertImage(new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } }));
  }

  // Simple as well efficient approach

  private static int[] invertTheArray(int[] is) {
    // This function is to invert the elements of the array if there is 1 make it 0
    // and if there is 0 make it 1
    for (int i = 0; i < is.length; i++) {
      is[i] = is[i] == 0 ? 1 : 0;
    }
    return is;
  }

  private static int[] reverseTheArray(int[] is) {
    // This function is to reverse the array elements
    int start = 0, end = is.length - 1;
    while (start < end) {
      int temp = is[end];
      is[end] = is[start];
      is[start] = temp;
      start++;
      end--;
    }
    return is;
  }

  public static int[][] flipAndInvertImage(int[][] image) {
    // Simply iterate through the array and replace each nested array by calling
    // respected functions
    for (int i = 0; i < image.length; i++) {
      // replace each array by reversing it
      image[i] = reverseTheArray(image[i]);
    }
    for (int i = 0; i < image.length; i++) {
      // replace each array by inverting values of it
      image[i] = invertTheArray(image[i]);
    }
    return image;
  }
}
