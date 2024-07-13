package hello;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int roundsPlayed = 0;
        int totalAttempts = 0;
        String playAgain = "yes";
        
        while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")) {
            roundsPlayed++;
            int attempts = playGame(scanner, random);
            totalAttempts += attempts;
            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next();
        }
        
        System.out.println("Game Over! You participated in " + roundsPlayed + " rounds with a total of " + totalAttempts + " attempts.");
        if (roundsPlayed > 0) {
            System.out.printf("Average attempts per round: %.2f\n", (double) totalAttempts / roundsPlayed);
        }
        
        scanner.close();
    }
    
    public static int playGame(Scanner scanner, Random random) {
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;
        System.out.println("I've picked a random number between 1 and 100. Try to guess it!");
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (1-100): ");
            int guess = scanner.nextInt();
            attempts++;
            
            String result = evaluateGuess(randomNumber, guess);
            if (result.equals("correct")) {
                System.out.println("Well done! You guessed the number correctly in " + attempts + " attempts.");
                return attempts;
            } else {
                System.out.println("Your guess is " + result + ".");
            }
        }
        
        System.out.println("Unfortunately, you've exhausted all " + maxAttempts + " attempts. The number was " + randomNumber + ".");
        return attempts;
    }
    
    public static String evaluateGuess(int randomNumber, int guess) {
        if (guess < randomNumber) {
            return "too low";
        } else if (guess > randomNumber) {
            return "too high";
        } else {
            return "correct";
        }
    }
}


  