import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class abc {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("filename.txt"))) {
            String line = br.readLine(); // Read the first line from the file
            if (line != null) {
                String[] words = line.split(" "); // Split the line by spaces
                if (words.length > 1) {
                    System.out.println(words[1]); // Print the second word
                } else {
                    System.out.println("The line does not contain a second word.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
