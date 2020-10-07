package com.bridgelabz.tictactogame;

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
		Scanner userInput=new Scanner(System.in);
		char[] gameBoard=createGameBoard();
		char userLetter = chooseUserLetter(userInput);
		char computerLetter=(userLetter=='X')? 'O' : 'X';
		int userCell=showBoard(userInput);
		
	}
	//Creating Game Board
	public static char[] createGameBoard() {
		char[] gameBoard=new char[10];
		for(int i=1;i<gameBoard.length;i++)
			gameBoard[i]=' ';
		return gameBoard;
	}
	//choosing player symbol
	public static char chooseUserLetter(Scanner userInput) {
		System.out.println("Choose player symbol 'X' or 'O'");
		return userInput.next().toUpperCase().charAt(0);
	}
	// UC3 choosing User Cell
	public static int showBoard(Scanner userInput) {
		System.out.println("choose valid cell 1-9");
		return userInput.nextInt();
	}
}
