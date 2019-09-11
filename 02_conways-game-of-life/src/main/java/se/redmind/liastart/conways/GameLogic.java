package se.redmind.liastart.conways;

public class GameLogic {

    String[][] squares = new String[25][25];
    String[][] squareChanges = new String[25][25];

    public void setUpGrid() {
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
    }

    public void printGrid() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                System.out.print(squares[i][j]);
                if (j == 24) {
                    System.out.println();
                }
            }
        }
    }

    public void nextGenerationOfSquares() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                int surroundingLiveCells = squaresSurrounding(squares, i, j);

                // Any live cell with two or three live neighbours lives on to the next generation.
                if(squares[i][j] == " o " && (2 == surroundingLiveCells || 3 == surroundingLiveCells)){
                    squareChanges[i][j] = " o ";
                } 
                // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                if (squares[i][j] == " o " && surroundingLiveCells < 2) {
                    squareChanges[i][j] = " • ";
                }
                // Any live cell with more than three live neighbours dies, as if by overpopulation.
                if (squares[i][j] == " o " && surroundingLiveCells > 3) {
                    squareChanges[i][j] = " • ";
                }
                // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                if (squares[i][j] == " • " && surroundingLiveCells == 3) {
                    squareChanges[i][j] = " o ";
                }
            }
        }
    }

    public int squaresSurrounding(String[][] squares, int i, int j) {
        int counter = 0;
        
        // collects the surrounding squares in an array
        if (i > 0 && i < 24 && j > 0 && j < 24) {
            String[][] surrounding = {
                {squares[i - 1][j - 1], squares[i - 1][j], squares[i - 1][j + 1]},
                {squares[i][j - 1], squares[i][j + 1]},
                {squares[i + 1][j - 1], squares[i + 1][j], squares[i + 1][j + 1]}
            };

            for (int x = 0; x < surrounding.length; x++) {
                for (int y = 0; y < surrounding[x].length; y++) {
                    if (surrounding[x][y].equals(" o ")) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    
    public void updateSquaresArray(){
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squareChanges[i][j] != null){
                    String newSquareContent = squareChanges[i][j];
                    squares[i][j] = newSquareContent;
                }
            }
        }
    }
    
    
}
