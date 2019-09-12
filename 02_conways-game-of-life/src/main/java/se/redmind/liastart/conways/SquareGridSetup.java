package se.redmind.liastart.conways;

public class SquareGridSetup {

    public String[][] setUpGrid(String[][] squares) {
        // Put an • in all squares
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = " • ";
            }
        }

        // Squares that are alive
        squares[2][10] = " o ";
        squares[2][11] = " o ";
        squares[2][12] = " o ";
        squares[6][13] = " o ";
        squares[7][13] = " o ";
        squares[8][13] = " o ";
        squares[15][14] = " o ";
        squares[15][15] = " o ";
        squares[15][16] = " o ";
        squares[16][13] = " o ";
        squares[16][14] = " o ";
        squares[16][15] = " o ";
        squares[10][4] = " o ";
        squares[10][5] = " o ";
        squares[11][4] = " o ";
        squares[11][5] = " o ";
        squares[12][6] = " o ";
        squares[12][7] = " o ";
        squares[13][6] = " o ";
        squares[13][7] = " o ";
        
        return squares;
    }

    public void printGrid(String[][] squares) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                System.out.print(squares[i][j]);
                if (j == 24) {
                    System.out.println();
                }
            }
        }
    }
}
