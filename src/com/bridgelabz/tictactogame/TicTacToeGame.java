package com.bridgelabz.tictactogame;

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
		Scanner userInput=new Scanner(System.in);
		char[] gameBoard=createGameBoard();
		char userLetter = chooseUserLetter(userInput);
		char computerLetter=(userLetter=='X')? 'O' : 'X';
		showBoard(gameBoard);
		userMove(userInput,gameBoard,userLetter);
		
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
	//UC3 Displaying Board
	public static void showBoard(char[] gameBoard) {
		System.out.println("Displaying Board");
		System.out.println(" "+gameBoard[1]+"|"+gameBoard[2]+"|"+gameBoard[3]);
		System.out.println("-------");
		System.out.println(" "+gameBoard[4]+"|"+gameBoard[5]+"|"+gameBoard[6]);
		System.out.println("-------");
		System.out.println(" "+gameBoard[7]+"|"+gameBoard[8]+"|"+gameBoard[9]);
	}
	//UC4 User making move
	public static void userMove(Scanner userInput, char[] gameBoard, char userLetter) {
		while(true) {
			System.out.println("Enter user position");
			int userPosition=userInput.nextInt();
			if(gameBoard[userPosition]==' ')
				gameBoard[userPosition]=userLetter;
			else
				System.out.println("Position is already filled");
			showBoard(gameBoard);
		}
	}
}
