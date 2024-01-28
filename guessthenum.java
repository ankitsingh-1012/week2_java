import java.util.Random;
import java.util.Scanner;

class Game {
    private int secretNumber;
    private int numberOfTries;
    private boolean gameOver;

    public Game() {
        // Initialize the game
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
        numberOfTries = 0;
        gameOver = false;
    }

    public void play() {
        while (!gameOver) {
            int userGuess = getUserGuess();
            numberOfTries++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + numberOfTries + " tries.");
                gameOver = true;
            } else {
                System.out.println("Wrong guess. Try again!");
                if (userGuess < secretNumber) {
                    System.out.println("Hint: The secret number is greater than your guess.");
                } else {
                    System.out.println("Hint: The secret number is less than your guess.");
                }
            }
        }
    }

    private int getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess (between 1 and 100): ");
        while (true) {
            try {
                int guess = Integer.parseInt(scanner.nextLine());
                if (guess >= 1 && guess <= 100) {
                    return guess;
                } else {
                    System.out.println("Please enter a valid number between 1 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

public class guessthenum {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("Try to guess the secret number between 1 and 100.");

        Game game = new Game();
        game.play();
    }
}
