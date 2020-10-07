package com.bridgelabz.tictactogame;

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
		char[] gameBoard=createGameBoard();
		char playerSymbol=choosePlayerSymbol(); 
		char computerSymbol=chooseComputerSymbol();
	}
	public static char[] createGameBoard() {
		char[] gameBoard=new char[10];
		for(int i=1;i<gameBoard.length;i++)
			gameBoard[i]=' ';
		return gameBoard;
	}
	public static char choosePlayerSymbol() {
		Scanner sc=new Scanner(System.in);
		char choose=sc.next().charAt(0);
		return choose;
	}
	public static char chooseComputerSymbol() {
		char playerSymbol=choosePlayerSymbol();
		if(playerSymbol=='X')
			return 'O';
		else
			return 'X';	
	}
}
