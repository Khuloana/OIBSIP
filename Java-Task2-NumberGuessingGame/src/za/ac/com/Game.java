/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.com;

import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);
    Random random = new Random();
    Player player = new Player();

    public void start() {

        char playAgain = 'Y';

        do {

            player.playedGame();

            System.out.println("==============================");
            System.out.println("     NUMBER GUESSING GAME");
            System.out.println("==============================");

            System.out.println("\nChoose Difficulty");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            int maxNumber = 100;
            int maxAttempts = 7;

            switch (choice) {

                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            int guess = 0;
            int attempts = 0;

            System.out.println("\nI have chosen a number between 1 and " + maxNumber + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                guess = input.nextInt();
                
                if (guess < 1 || guess > maxNumber) {
                System.out.println("Please enter a number between 1 and " + maxNumber + ".");
                continue;
                }
                
                attempts++;

                if (guess > secretNumber) {

                    System.out.println("Too High!");

                } else if (guess < secretNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Correct!");
                    break;

                }

                System.out.println("Attempts Remaining: " + (maxAttempts - attempts));
            }

            if (guess == secretNumber) {

                player.wonGame();

                System.out.println("\nCongratulations!");
                System.out.println("You guessed the number correctly!");
                System.out.println("Attempts Used: " + attempts);

            } else {

                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + secretNumber);

            }

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = input.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n========== GAME STATISTICS ==========");
        System.out.println("Games Played: " + player.getGamesPlayed());
        System.out.println("Games Won: " + player.getGamesWon());
        double winRate = (double) player.getGamesWon() / player.getGamesPlayed() * 100;
        System.out.printf("Win Rate: %.2f%%\n", winRate);
        System.out.println("Thank you for playing!");
        input.close();

    }

}