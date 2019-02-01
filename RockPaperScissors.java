package RPS;

import java.util.Scanner;

public class RockPaperScissors {
	private static double compRandNum = Math.random();
	private static String compChoice;
	private static String userChoice;
	private static boolean gameOver = false;
	private static int userScore = 0;
	private static int compScore = 0;
	private static String playAgain;
	private static boolean replayLoop = true;

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\nWelcome to Rock, Paper, Scissors!\n\nInstructions:\nThe computer will randomly choose 'Rock', 'Paper', or 'Scissors'. You will choose one of the three. 'Rock' beats 'Scissors', 'Scissors' beats 'Paper', and 'Paper' beats 'Rock'. You will play Best of Five.\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");

		compChoice();

		while(!gameOver) {
			gameLoop();
			if(userScore == 3) {
				System.out.println("Congratulations! You won the Best out of Five!\n");
				while(replayLoop) {
					playAgain();
				}
			} else if(compScore == 3) {
				System.out.println("You lost the Best out of Five. Better luck next time!\n");
				while(replayLoop) {
					playAgain();
				}
			}
		}

		System.out.println("\nThank you for playing!\n\nRock-Paper-Scissors by Kyle Hanson\nCreated on 3/3/2018\n");
	}

	public static void gameLoop() {
		Scanner in = new Scanner(System.in);

		replayLoop = true;

		while(userScore < 3 && compScore < 3) {
			System.out.println("|Scoreboard|\tUser: " + userScore + "\t\tComputer: " + compScore + "\n");
			System.out.print("Please choose 'Rock', 'Paper', or 'Scissors': ");

			userChoice = in.next();

			if(!userChoice.toLowerCase().equals("rock") && !userChoice.toLowerCase().equals("paper") && !userChoice.toLowerCase().equals("scissors")) {
				System.out.println("\nYou must choose 'Rock', 'Paper', or 'Scissors'.\n");
				break;
			}
			
			userChoice = userChoice.substring(0, 1).toUpperCase() + userChoice.substring(1).toLowerCase();

			System.out.println("\nYou chose '" + userChoice + "'");
			System.out.println("The computer chose '" + compChoice + "'\n");
			System.out.println(compare(compChoice, userChoice) + "\n");
			System.out.println("---------------------------------------------------------");

			compRandNum = Math.random();
			compChoice();
		}
	}

	public static void compChoice() {
		if(compRandNum <= .33) {
			compChoice = "Rock";
		} else if(compRandNum > .33 && compRandNum < .67) {
			compChoice = "Paper";
		} else {
			compChoice = "Scissors";
		}
	}

	public static String compare(String c, String u) {
		if(c.equals(u)) {
			return "It's a tie!";
		} else if(c.equals("Rock")) {
			switch(u) {
				case "Paper":
					userScore++;
					return "'Paper' covers 'Rock'. You win!";
				case "Scissors":
					compScore++;
					return "'Rock' crushes 'Scissors'. The computer wins!";
			}
		} else if(c.equals("Paper")) {
			switch(u) {
				case "Rock":
					compScore++;
					return "'Paper' covers 'Rock'. The computer wins!";
				case "Scissors":
					userScore++;
					return "'Scissors' cuts 'Paper'. You win!";
			}
		} else if(c.equals("Scissors")) {
			switch(u) {
				case "Rock":
					userScore++;
					return "'Rock' crushes 'Scissors'. You win!";
				case "Paper":
					compScore++;
					return "'Scissors' cuts 'Paper'. The computer wins!";
			}
		}

		return "";
	}

	public static void playAgain() {
		Scanner play = new Scanner(System.in);

		while(true) {
			System.out.print("Would you like to play again? (Y/N): ");
			playAgain = play.next();

			if(playAgain.equals("Y") || playAgain.equals("y")) {
				System.out.println();
				userScore = 0;
				compScore = 0;
			} else if(playAgain.equals("N") || playAgain.equals("n")) {
				gameOver = true;
			} else {
				System.out.println("\nYou must type 'Y' or 'N'.\n");
				break;
			}

			replayLoop = false;
			break;
		}
	}
}