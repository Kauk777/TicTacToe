package com.bridgelabz.tictactoegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	public static List<Integer> playerPositions = new ArrayList<>();
	public static List<Integer> computerPositions = new ArrayList<>();

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		char[] gameBoard = createGameBoard();
		char userLetter = chooseUserLetter(userInput);
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		showBoard(gameBoard);
		String checkFirstPlayer = tossing(userInput);
		System.out.println("First Go: " + checkFirstPlayer);
		if (checkFirstPlayer.equals("User"))
			while (true) {
				int getUserMove = userMove(userInput, gameBoard, userLetter);
				playerPositions.add(getUserMove);
				if(!winningCondition())
					break;
				int getComputerMove = computerMove(gameBoard, computerLetter);
				computerPositions.add(getComputerMove);
				if(!winningCondition())
					break;
			}
		else
			while (true) {
				int getComputerMove = computerMove(gameBoard, computerLetter);
				computerPositions.add(getComputerMove);
				if(!winningCondition())
					break;
				int getUserMove = userMove(userInput, gameBoard, userLetter);
				playerPositions.add(getUserMove);
				if(!winningCondition())
					break;
			}
	}

	// Creating Game Board
	public static char[] createGameBoard() {
		char[] gameBoard = new char[10];
		for (int i = 1; i < gameBoard.length; i++)
			gameBoard[i] = ' ';
		return gameBoard;
	}

	// choosing player symbol
	public static char chooseUserLetter(Scanner userInput) {
		System.out.println("Choose player symbol 'X' or 'O'");
		return userInput.next().toUpperCase().charAt(0);
	}

	// UC3 Displaying Board
	public static void showBoard(char[] gameBoard) {
		System.out.println("Displaying Board");
		System.out.println(" " + gameBoard[1] + "|" + gameBoard[2] + "|" + gameBoard[3]);
		System.out.println("-------");
		System.out.println(" " + gameBoard[4] + "|" + gameBoard[5] + "|" + gameBoard[6]);
		System.out.println("-------");
		System.out.println(" " + gameBoard[7] + "|" + gameBoard[8] + "|" + gameBoard[9]);
	}

	// UC4 User making move
	public static int userMove(Scanner userInput, char[] gameBoard, char userLetter) {
		Integer validCells[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		while (true) {
			System.out.println("Enter user position 1-9");
			System.out.println("Enter the available corner position 1,3,7,9");
			int userPosition = userInput.nextInt();
			if (Arrays.asList(validCells).contains(userPosition) && isPositionFree(gameBoard, userPosition)) {
				gameBoard[userPosition] = userLetter;
				showBoard(gameBoard);
				return userPosition;
			} else if (!Arrays.asList(validCells).contains(userPosition)) {
				System.out.println("Position entered should be between 1-9");
				continue;
			} else {
				System.out.println("Position already filled Renter the postion");
				continue;
			}
		}
	}

	// UC 5 checking empty positon
	public static boolean isPositionFree(char[] gameBoard, int index) {
		return gameBoard[index] == ' ';
	}

	// UC6 checking first turn
	public static String tossing(Scanner userInput) {
		System.out.println("1-Head and 2-Tail");
		System.out.println("Choose head or tail");
		int userToss = userInput.nextInt();
		Random rand = new Random();
		int tossValue = rand.nextInt(2) + 1;
		if (tossValue == userToss)
			return "User";
		else
			return "Computer";
	}

	// UC8 computer move
	public static int computerMove(char[] gameBoard, char computerLetter) {
		while (true) {
			System.out.println("Computer Entered");
			Random rand = new Random();
			int computerPosition = rand.nextInt(9) + 1;
			if (isPositionFree(gameBoard, computerPosition)) {
				gameBoard[computerPosition] = computerLetter;
				showBoard(gameBoard);
				return computerPosition;
			} else {
				System.out.println("Position already filled Renter the postion");
				continue;
			}
		}
	}

	// UC7 winning criteria
	public static boolean winningCondition() {
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> bottomRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 4, 7);
		List<Integer> midCol = Arrays.asList(2, 5, 8);
		List<Integer> rightCol = Arrays.asList(3, 6, 9);
		List<Integer> leftDiagonal = Arrays.asList(1, 5, 9);
		List<Integer> rightDiagonal = Arrays.asList(3, 5, 7);

		List<List> winningList = new ArrayList<>();
		winningList.add(topRow);
		winningList.add(midRow);
		winningList.add(bottomRow);
		winningList.add(leftCol);
		winningList.add(midCol);
		winningList.add(rightCol);
		winningList.add(rightDiagonal);
		winningList.add(leftDiagonal);

		for (List l : winningList) {
			if (playerPositions.containsAll(l)) {
				System.out.println("Player Won!!!");
				return false;
			} else if (computerPositions.containsAll(l)) {
				System.out.println("Computer Won!!!");
				return false;
			}
		}
		return true;
	}
}
