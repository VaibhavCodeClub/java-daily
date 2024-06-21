// Daily Temperatures
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

import java.util.Arrays;
import java.util.Stack;

public class leet739 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 40, 50, 60 })));
    System.out.println(Arrays.toString(dailyTemperatures0(new int[] { 30, 40, 50, 60 })));
  }

  public static int[] dailyTemperatures(int[] temperatures) {
    for (int i = 0; i < temperatures.length; i++) {
      boolean changed = false;
      for (int j = i + 1; j < temperatures.length; j++) {
        if (temperatures[j] > temperatures[i]) {
          temperatures[i] = j - i;
          changed = true;
          break;
        }
      }
      if (!changed)
        temperatures[i] = 0;
    }
    temperatures[temperatures.length - 1] = 0;
    return temperatures;
  }
  // The above approach gives the TLE for huge test cases sadly that was my own
  // approach BTW.
  // Below is better one

  static class Pair {
    int temperature;
    int index;

    Pair(int temperature, int index) {
      this.temperature = temperature;
      this.index = index;
    }
  }

  public static int[] dailyTemperatures0(int[] temperatures) {
    int[] arr = new int[temperatures.length];
    Stack<Pair> indexStack = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      while (!indexStack.isEmpty() && temperatures[i] > indexStack.peek().temperature) {
        int stackIndex = indexStack.pop().index;

        arr[stackIndex] = (i - stackIndex);
      }
      indexStack.push(new Pair( temperatures[i],i));
    }
    return arr;
  }
}
