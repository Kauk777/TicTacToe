package com.bridgelabz.tictactogame;

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
		Scanner userInput=new Scanner(System.in);
		char[] gameBoard=createGameBoard();
		char userLetter = chooseUserLetter(userInput);
		char computerLetter=(userLetter=='X')? 'O' : 'X';
		showBoard(gameBoard);
		
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
	// UC3 Displaying Board
	public static void showBoard(char[] gameBoard) {
		System.out.println("Displaying Board");
		System.out.println(gameBoard[1]+"|"+gameBoard[2]+"|"+gameBoard[3]);
		System.out.println("_"+" "+"_"+" "+"_");
		System.out.println(gameBoard[4]+"|"+gameBoard[5]+"|"+gameBoard[6]);
		System.out.println("_"+" "+"_"+" "+"_");
		System.out.println(gameBoard[7]+"|"+gameBoard[8]+"|"+gameBoard[9]);
	}
}
