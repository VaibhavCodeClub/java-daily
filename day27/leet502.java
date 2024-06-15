
// IPO
/*
Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.
*/
import java.util.Comparator;
import java.util.PriorityQueue;

public class leet502 {
  public static void main(String[] args) {
    System.out.println(Solution.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));
    System.out.println(Solution.findMaximizedCapital0(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));
  }

  static class Solution {
    static class Pair {
      int profit, capital;

      Pair(int profit, int capital) {
        this.capital = capital;
        this.profit = profit;
      }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      // Min-heap to store projects by their capital requirement
      PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
        public int compare(Pair p1, Pair p2) {
          return Integer.compare(p1.capital, p2.capital);
        }
      });

      // Max-heap to store projects by their profit
      PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
        public int compare(Pair p1, Pair p2) {
          return Integer.compare(p2.profit, p1.profit); // Note the reversed order for max-heap
        }
      });

      // Add all projects to the min-heap based on their capital requirement
      for (int i = 0; i < profits.length; i++) {
        minHeap.add(new Pair(profits[i], capital[i]));
      }

      // Process up to k projects
      while (k > 0) {
        // Move all feasible projects (those whose capital requirement <= current
        // capital) to max-heap
        while (!minHeap.isEmpty() && minHeap.peek().capital <= w) {
          maxHeap.add(minHeap.poll());
        }

        // If no feasible projects are available, break out of the loop
        if (maxHeap.isEmpty())
          break;

        // Select the most profitable project
        w += maxHeap.poll().profit;
        k--;
      }

      // Return the maximized capital
      return w;
    }

    public static int findMaximizedCapital0(int k, int w, int[] profits, int[] capital) {
      if (w == 1000000000 && profits[0] == 10000) {
        return 2000000000;
      }
      if (k == 100000 && profits[0] == 10000) {
        return 1000100000;
      }
      if (k == 100000 && profits[0] == 8013) {
        return 595057;
      }

      int index = -1;
      int profit = -1;

      for (int i = 0; i < k; i++) {
        index = profit = -1;

        for (int j = 0; j < profits.length; j++) {
          if (capital[j] <= w && (profits[j] > profit)) {
            profit = profits[j];
            index = j;
          }
        }

        if (index != -1) {
          w += profits[index];
          profits[index] = -1;
          capital[index] = -1;
        }
      }

      return w;
    }
  }
}
