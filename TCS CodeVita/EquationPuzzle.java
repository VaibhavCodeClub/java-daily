import java.util.HashSet;
import java.util.Set;

public class EquationPuzzle {

    public static int solveEquation(String eq1, String eq2, int R) {
        // Parsing the coefficients for both equations
        int[] coeffs1 = parseEquation(eq1);
        int[] coeffs2 = parseEquation(eq2);

        // If N values don't match for both equations, we cannot proceed
        if (coeffs1[4] != coeffs2[4]) {
            return 0;
        }

        int N = coeffs1[4];
        Set<Integer> validResults = new HashSet<>();

        // Brute force through all combinations of x, y, z, w where sum is <= R
        for (int x = 0; x <= R; x++) {
            for (int y = 0; y <= R - x; y++) {
                for (int z = 0; z <= R - x - y; z++) {
                    for (int w = 0; w <= R - x - y - z; w++) {
                        int result1 =
                            coeffs1[0] * x +
                            coeffs1[1] * y +
                            coeffs1[2] * z +
                            coeffs1[3] * w;
                        int result2 =
                            coeffs2[0] * x +
                            coeffs2[1] * y +
                            coeffs2[2] * z +
                            coeffs2[3] * w;

                        // Add to validResults only if results match and within bounds
                        if (result1 == result2 && result1 <= N) {
                            validResults.add(result1);
                        }
                    }
                }
            }
        }

        return validResults.size();
    }

    // Function to parse the coefficients from the equation
    public static int[] parseEquation(String eqStr) {
        int[] coefficients = new int[4];
        int N = 0;

        // Split the equation from <= sign
        String[] parts = eqStr.split("<=");
        String equation = parts[0].trim();
        N = Integer.parseInt(parts[1].trim());

        // Parse the equation for coefficients of x, y, z, w
        String[] terms = equation.split("\\+");

        for (String term : terms) {
            term = term.trim();
            if (term.contains("x")) {
                coefficients[0] = Integer.parseInt(
                    term.replace("x", "").trim()
                );
            } else if (term.contains("y")) {
                coefficients[1] = Integer.parseInt(
                    term.replace("y", "").trim()
                );
            } else if (term.contains("z")) {
                coefficients[2] = Integer.parseInt(
                    term.replace("z", "").trim()
                );
            } else if (term.contains("w")) {
                coefficients[3] = Integer.parseInt(
                    term.replace("w", "").trim()
                );
            }
        }

        return new int[] {
            coefficients[0],
            coefficients[1],
            coefficients[2],
            coefficients[3],
            N,
        };
    }

    public static void main(String[] args) {
        // Test case 1
        String eq1 = "10x+7y+3z+5w<=15";
        String eq2 = "4x+9y+11z+15w<=23";
        int R = 10;

        // Test case 2
        // String eq1 = "14x+7y+9z+19w<=40";
        // String eq2 = "2x+3y+4z+5w<=20";
        // int R = 5;

        System.out.println(solveEquation(eq1, eq2, R)); // Expected output: 4 for example 1, try with other examples
    }
}
