// Car Fleet
/*
There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet853 {
  public static void main(String[] args) {
    System.out.println(carFleet(10, new int[] { 6, 8 }, new int[] { 3, 2 }));
  }

  public static int carFleet(int target, int[] position, int[] speed) {
    List<int[]> pair = new ArrayList<>();
    for (int i = 0; i < position.length; i++) {
      pair.add(new int[] { position[i], speed[i] });
    }
    // Sort cars based on starting position in descending order
    Collections.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

    ArrayDeque<Double> timeStack = new ArrayDeque<>();
    for (int[] car : pair) {
      double timeToTarget = (double) (target - car[0]) / car[1];
      // Check if the current car can merge with the last fleet
      if (!timeStack.isEmpty() && timeToTarget <= timeStack.peek()) {
        continue; // This car joins the fleet in front of it
      }
      timeStack.push(timeToTarget); // This car starts a new fleet
    }
    return timeStack.size();
  }
}
