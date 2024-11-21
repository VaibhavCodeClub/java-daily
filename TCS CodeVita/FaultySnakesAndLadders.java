import java.util.HashMap;
import java.util.Scanner;

public class FaultySnakesAndLadders {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // Store original snake/ladder positions
        HashMap<Integer, Integer> snakesAndLadders = new HashMap<>();
        for (int i = 0; i < N; i++) {
            snakesAndLadders.put(sc.nextInt(), sc.nextInt());
        }

        // Read dice rolls
        String[] diceRolls = sc.nextLine().split(" ");
        int[] rolls = new int[diceRolls.length];
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = Integer.parseInt(diceRolls[i]);
        }

        // Final position reached
        int finalPosition = sc.nextInt();

        // Simulate path without switching
        int currentPosition = 1;
        boolean reachable = true;
        for (int roll : rolls) {
            currentPosition += roll;
            if (snakesAndLadders.containsKey(currentPosition)) {
                currentPosition = snakesAndLadders.get(currentPosition);
            }
            if (currentPosition > 100) {
                reachable = false;
                break;
            }
        }

        if (!reachable) {
            System.out.println("Not reachable");
            return;
        }

        // Check if final position is reachable (without switching)
        if (currentPosition == finalPosition) {
            System.out.println("Not affected");
            return;
        }

        // Identify switched element (if reachable)
        for (int i = 0; i < rolls.length; i++) {
            int roll = rolls[i];
            int newPosition = currentPosition + roll;
            if (snakesAndLadders.containsKey(newPosition)) {
                int originalDestination = snakesAndLadders.get(newPosition);
                snakesAndLadders.put(newPosition, currentPosition); // Switch destination

                // Simulate path with the switch
                currentPosition = 1;
                for (int j = 0; j < rolls.length; j++) {
                    currentPosition += rolls[j];
                    if (snakesAndLadders.containsKey(currentPosition)) {
                        currentPosition = snakesAndLadders.get(currentPosition);
                    }
                    if (currentPosition > 100) {
                        break;
                    }
                }

                // Check if the final position is reached after the switch
                if (currentPosition == finalPosition) {
                    if (originalDestination > newPosition) {
                        System.out.println(
                            "Ladder " + newPosition + " " + originalDestination
                        );
                    } else {
                        System.out.println(
                            "Snake " + newPosition + " " + originalDestination
                        );
                    }
                    return;
                }

                // Revert the switch
                snakesAndLadders.put(newPosition, originalDestination);
            }
        }

        System.out.println("Not reachable");
    }
}
