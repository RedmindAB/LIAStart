
package se.redmind.liastart.conways;


public class Main {

    public static void main(String[] args) {
        
        GameLogic gl = new GameLogic();
        
        System.out.println("Genereation 1: ");
        gl.setUpGrid();
        gl.printGrid();
        
        System.out.println("Generation 2: ");
        gl.nextGenerationOfSquares();
        gl.updateSquaresArray();
        gl.printGrid();

    }

}
