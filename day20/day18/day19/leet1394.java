// Find Lucky Integer in an Array
// Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

// Return the largest lucky integer in the array. If there is no lucky integer return -1.

import java.util.Arrays;
import java.util.HashMap;

public class leet1394 {
  public static void main(String[] args) {
    System.out.println(findLucky(new int[] { 5 }));
  }

  public static int findLucky(int[] arr) {
    // HashMap<Integer, Integer> abc = new HashMap<>();
    // int maxVal = -1;
    // for (int i : arr) {
    //   abc.put(i, abc.getOrDefault(i, 0) + 1);
    // }

    // for (int i : abc.keySet()) {
    //   if (i == abc.get(i) && i > maxVal)
    //     maxVal = i;
    // }
    // return maxVal;

    // Faster approach is below

    int freq[]=new int[arr.length+1];
    for(int i:arr){
    freq[i]++;
    }
    int max=-1;
    System.out.println(Arrays.toString(freq)+" <> "+arr.length);
    for(int i=1;i<=arr.length;i++){
    if(i==freq[i]){
    max = Math.max(max,i);
    }
    }

    return max;
  }
}
