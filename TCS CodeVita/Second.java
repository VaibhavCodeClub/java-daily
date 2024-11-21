import java.util.Scanner;

public class Second {

    // Method to solve the Dance Revolution problem
    public static int danceRevolution(int N, String[] instructions) {
        // Tiles: 0 -> up, 1 -> right, 2 -> down, 3 -> left
        String[] tiles = { "up", "right", "down", "left" };

        // Map the tile name to an index
        int[] tileIndex = { 0, 1, 2, 3 };

        // DP Table initialization: dp[foot1_position][foot2_position]
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[4][4];

        // Initialize dp for the first instruction
        int firstInstruction = getTileIndex(instructions[0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    dp[i][j] = 0; // Start with no move since feet can be placed initially
                }
            }
        }

        // Process each instruction after the first one
        for (int i = 1; i < N; i++) {
            int currentTile = getTileIndex(instructions[i]);
            int[][] newDp = new int[4][4];

            for (int foot1 = 0; foot1 < 4; foot1++) {
                for (int foot2 = 0; foot2 < 4; foot2++) {
                    if (dp[foot1][foot2] < INF) {
                        // Move foot1 to currentTile
                        newDp[currentTile][foot2] = Math.min(
                            newDp[currentTile][foot2],
                            dp[foot1][foot2] + (foot1 != currentTile ? 1 : 0)
                        );
                        // Move foot2 to currentTile
                        newDp[foot1][currentTile] = Math.min(
                            newDp[foot1][currentTile],
                            dp[foot1][foot2] + (foot2 != currentTile ? 1 : 0)
                        );
                    }
                }
            }

            // Copy the updated dp to the original dp
            dp = newDp;
        }

        // Find the minimum number of moves after all instructions
        int result = INF;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dp[i][j] < result) {
                    result = dp[i][j];
                }
            }
        }

        return result;
    }

    // Helper function to map tile name to an index
    private static int getTileIndex(String tile) {
        switch (tile) {
            case "up":
                return 0;
            case "right":
                return 1;
            case "down":
                return 2;
            case "left":
                return 3;
            default:
                throw new IllegalArgumentException("Invalid tile: " + tile);
        }
    }

    // Main method to take input from the user
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from the user at runtime
        int N = sc.nextInt(); // Read the number of instructions
        sc.nextLine(); // Consume the newline character left after reading an integer
        String[] instructions = new String[N]; // Array to store the instructions

        for (int i = 0; i < N; i++) {
            instructions[i] = sc.nextLine().trim(); // Read the instructions
        }

        // Call the function and output the result
        System.out.println(danceRevolution(N, instructions));

        sc.close();
    }
}
