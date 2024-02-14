import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int number;
        int guess;
        int attempts;
        int rounds;
        int score;
        boolean playing;
        String choice;

        attempts = 0;
        rounds = 0;
        score = 0;
        playing = true;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I will generate a random number between 1 and 100, and you have to guess it.");
        System.out.println("You have 10 attempts to guess the number. If you guess correctly, you win the round and get a point.");
        System.out.println("If you run out of attempts, you lose the round and get no points.");
        System.out.println("You can play as many rounds as you want. Your score will be displayed at the end of each round.");
        System.out.println("Let's begin!");

        while (playing) {
            number = random.nextInt(100) + 1;
            attempts = 0;
            rounds++;

            System.out.println("\nRound " + rounds);

            do {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("You got it! The number was " + number + ".");
                    System.out.println("You took " + attempts + " attempts to guess the number.");
                    score++;
                    break;
                } else if (guess > number) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                if (attempts == 10) {
                    System.out.println("You have no more attempts left. You lose this round.");
                    System.out.println("The number was " + number + ".");
                }
            } while (attempts < 10);

            System.out.println("Your score is " + score + " out of " + rounds + ".");

            System.out.print("Do you want to play again (Y/N)? ");
            choice = scanner.next();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("OK, let's play again!");
            } else {
                System.out.println("Thank you for playing the Guessing Game. Goodbye!");
                playing = false;
            }
        }

        scanner.close();
    }
}
