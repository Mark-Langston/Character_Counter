// CSC262 Programming in Java
// Mark Langston    5/17/2024
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("String & Character Analyzer");
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            // Prompts user to enter a string, can be lowercase, contain spaces and/or punctuation
            System.out.println("Enter a string, do not enter any uppercase letters:");

            // Read the input string
            input = scanner.nextLine();

            // Check if the string contains any uppercase letters
            boolean validInput = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    validInput = false;
                    break;
                }
            }

            // If input valid, break
            if (validInput) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a string with lowercase alphabetic characters, spaces, and punctuation only.");
            }
        }

        // Array to store the frequency of each letter
        int[] frequency = new int[256];

        // Calculate the frequency of each letter
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            frequency[ch]++;
        }

        // Find the max
        int maxFrequency = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
            }
        }

        // Print letters that have the maximum frequency
        System.out.println("The most frequently occurring letter(s):");
        for (int i = 0; i < 256; i++) {
            if (frequency[i] == maxFrequency && maxFrequency > 0) {
                System.out.printf("%c (%d)%n", (char) i, maxFrequency);
            }
        }

        scanner.close();
    }
}