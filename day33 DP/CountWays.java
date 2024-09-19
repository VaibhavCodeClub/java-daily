// Code360 problem 
/*
You have been given a number of stairs. Initially, you are at the 0th stair, and you need to reach the Nth stair.


Each time, you can climb either one step or two steps.


You are supposed to return the number of distinct ways you can climb from the 0th step to the Nth step.
Example :

N=3
We can climb one step at a time i.e. {(0, 1) ,(1, 2),(2,3)} or we can climb the first two-step and then one step i.e. {(0,2),(1, 3)} or we can climb first one step and then two step i.e. {(0,1), (1,3)}.
 */
public class CountWays {
  public static void main(String[] args) {
    System.out.println(countDistinctWayToClimbStair(5));
  }

  public static long countDistinctWayToClimbStair(int nStairs) {
    int prev2 = 1;
    int prev1 = 1;
    for (int i = 2; i <= nStairs; i++) {
      int curri = prev2 + prev1;
      prev2 = prev1;
      prev1 = curri;
    }
    return prev1;
  }
}


/*

    if (nStairs == 0) return 0;  // No stairs to climb
    if (nStairs == 1) return 1;  // Only one way to climb one stair
    
    int prev2 = 1;
    int prev1 = 1;
    for (int i = 2; i <= nStairs; i++) {
        int curri = prev2 + prev1;
        prev2 = prev1;
        prev1 = curri;
    }
    return prev1;

    
 */