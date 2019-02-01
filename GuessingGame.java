package RNGG;

import java.util.Scanner;

public class GuessingGame {
	private static int guess;
	private static boolean isGuessed = false;
	private static int numGuesses = 0;
	private static int numRand = (int)(Math.random() * 1001);
	private static String playAgain = "";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Welcome to the Random Number Guessing Game!\n\nInstructions:\nThe computer has generated a random integer from 0 to 1000, inclusive. It is up to you to guess the number in the least number of tries. You will be notified whether your guess is too low or too high.");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");

		while(!isGuessed) {
			guessLoop();
		}

		System.out.println("Congratulations!\nIt took you " + numGuesses + " guesses.\n");

		while(!playAgain.equals("Y") || !playAgain.equals("y") || !playAgain.equals("N") || !playAgain.equals("n")) {
			System.out.print("Would you like to play again? (Y/N): ");

			playAgain = scan.next();

			if(playAgain.equals("Y") || playAgain.equals("y")) {
				isGuessed = false;
				numGuesses = 0;
				numRand = (int)(Math.random() * 1001);

				System.out.println();

				while(!isGuessed) {
					guessLoop();
				}

				System.out.println("Congratulations!\nIt took you " + numGuesses + " guesses.\n");
			} else if(playAgain.equals("N") || playAgain.equals("n")) {
				System.out.println("\nThank you for playing!\n\nThe Random Number Guessing Game by Kyle Hanson\nCreated on 2/25/2018\n");
				break;
			} else {
				System.out.println("\nYou must type 'Y' or 'N'. Try again.\n");
			}
		}
		
		scan.close();
	}

	public static void guessLoop() {
		while(true) {
			Scanner in = new Scanner(System.in);
			guess = 0;
			System.out.print("Enter your guess: ");
	
			try {
				guess = in.nextInt();
			} catch(Exception e) {
				System.out.println("Your guess must be an integer. Try again.\n");
				break;
			}

			if(guess < 0 || guess > 1000) {
				System.out.println("Your guess must be between 0 and 1000, inclusive. Try again.\n");
				break;
			}

			numGuesses++;

			System.out.println(guessVerdict());

			break;
		}
	}

	public static String guessVerdict() {
		if(guess < numRand) {
			return "Too Low\n";
		} else if(guess > numRand) {
			return "Too High\n";
		} else {
			isGuessed = true;
			return "";
		}
	}
}