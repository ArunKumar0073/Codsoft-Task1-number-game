import java.util.Scanner;
import java.util.Random;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalAttempts = 0;
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            final int maxAttempts = 10;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            
            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + numberToGuess);
            }

            rounds++;
            totalAttempts += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        System.out.println("You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}