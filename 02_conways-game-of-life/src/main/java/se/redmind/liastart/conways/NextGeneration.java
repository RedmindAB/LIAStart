
package se.redmind.liastart.conways;


public class NextGeneration {
    
    String[][] squareChanges = new String[25][25];
    
    public void nextGenerationOfSquares(String[][] squares) {
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
        if (i > 0 && i < squares.length-1 && j > 0 && j < squares.length-1) {
            String[][] surrounding = {
                {squares[i - 1][j - 1], squares[i - 1][j], squares[i - 1][j + 1]},
                {squares[i][j - 1], squares[i][j + 1]},
                {squares[i + 1][j - 1], squares[i + 1][j], squares[i + 1][j + 1]}
            };
            // counts the living squares
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

    public String[][] updateSquaresArray(String[][] squares){
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squareChanges[i][j] != null){
                    String newSquareContent = squareChanges[i][j];
                    squares[i][j] = newSquareContent;
                }
            }
        }
        return squares;
    }

    public String[][] getSquareChanges() {
        return squareChanges;
    }
}
