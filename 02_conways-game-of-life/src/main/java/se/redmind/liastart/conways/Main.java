package se.redmind.liastart.conways;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SquareGridSetup sgs = new SquareGridSetup();
        NextGeneration ng = new NextGeneration();
        String[][] squares = new String[25][25];
        
        int amountGenerations = 0;
        boolean go = true;
        while (go) {
            System.out.print("Skriv in antal önskade generationer: ");
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                amountGenerations = in.nextInt();
                if (amountGenerations > 0){
                    go = false;
                }
                else {
                    System.out.println("Siffan måste vara större än 0");
                }
            } else {
                System.out.println("Det måste vara en siffra");
            }
        }

        // Sätter upp generation 1
        System.out.println("Generation 1: ");
        squares = sgs.setUpGrid(squares);
        sgs.printGrid(squares);

        // Genererade generationer
        for (int i = 2; i <= amountGenerations; i++) {
            System.out.println("Generation " + i + ":");
            ng.nextGenerationOfSquares(squares);
            squares = ng.updateSquaresArray(squares);
            sgs.printGrid(squares);
        }
    }
}
