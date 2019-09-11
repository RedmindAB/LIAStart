package se.redmind.liastart;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ChessGrid chessGrid = new ChessGrid(20, 20);
		Rules rules = new Rules();
		chessGrid.createCells();

		Scanner scanner = new Scanner(System.in);

		System.out.println("write run when you are ready: ");
		String input = scanner.nextLine();
		if(input.equalsIgnoreCase("run")){
			rules.playGame(chessGrid.getCells());
		}
	}

}
