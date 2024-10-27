/*
The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:

    If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
    Otherwise, they will leave it and go to the queue's end.

This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 */

public class leetInterview1 {
    public static int countStudentsUnableToEat(int[] students, int[] sandwiches) {
        int[] preferenceCount = new int[2]; // Initialize counts for circular and square sandwiches
        for (int preference : students) {
            preferenceCount[preference]++; // Count the number of students preferring each type of sandwich
        }

        for (int sandwich : sandwiches) {
            if (preferenceCount[sandwich] == 0) {
                return preferenceCount[1 - sandwich]; // Return count of students unable to eat
            }
            preferenceCount[sandwich]--; // Reduce count of available sandwiches according to preference
        }

        return 0; // If all sandwiches were consumed, return 0
    }

    public static void main(String[] args) {
        int[] students = { 1, 1, 1, 0, 0, 1 };
        int[] sandwiches = { 1, 0, 0, 0, 1, 1 };
        System.out.println(countStudentsUnableToEat(students, sandwiches)); // Output: 0
    }
}
