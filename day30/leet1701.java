// Average Waiting Time

/*
There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

    arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
    timei is the time needed to prepare the order of the ith customer.

When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.
*/

public class leet1701 {
  public static void main(String[] args) {
    System.out
        .println(averageWaitingTime(new int[][] { { 2, 3 }, { 6, 3 }, { 7, 5 }, { 11, 3 }, { 15, 2 }, { 18, 1 } }));
  }

  public static double averageWaitingTime(int[][] customers) {
    double completionTime = customers[0][0], sum = 0;
    for (int[] is : customers) {
      if (completionTime >= is[0]) {
        completionTime += is[1];
        double currentTime = completionTime - is[0];
        sum += currentTime;
      } else {
        sum += is[1];
        completionTime = is[0] + is[1];
      }
    }
    return sum / customers.length;
  }
}
