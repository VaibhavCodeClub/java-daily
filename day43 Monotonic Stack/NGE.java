import java.util.Arrays;
import java.util.TreeMap;

public class NGE {

  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // Array to hold the count of greater elements for each index
    int[] ngCount = new int[N];

    // Calculate the number of greater elements for each index
    for (int i = 0; i < N; i++) {
      int count = 0;
      for (int j = i + 1; j < N; j++) {
        if (arr[j] > arr[i]) {
          count++;
        }
      }
      ngCount[i] = count;
    }

    // Prepare the result for the queries
    int[] result = new int[queries];
    for (int i = 0; i < queries; i++) {
      result[i] = ngCount[indices[i]];
    }

    return result;
  }

  public static void main(String[] args) {
    // Example usage
    int[] arr = { 3, 4, 9, 1, 5 };
    int[] indices = { 0, 2, 3 };
    int queries = indices.length;

    int[] result = count_NGEs(arr.length, arr, queries, indices);
    System.out.println(Arrays.toString(result)); // Output should be [2, 1, 0]
  }
}
