package se.redmind.liastart.conways;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.redmind.liastart.conways.NextGeneration;

public class NextGenerationTest {

    NextGeneration ng = new NextGeneration();
    String[][] squaresTestArr = new String[25][25];
    String[][] changesTestArr = new String[25][25];

    @Test
    public void nextGenerationOfSquaresTest() {
        createSquareArray();
        ng.nextGenerationOfSquares(squaresTestArr);
        changesTestArr = ng.getSquareChanges();
        assertEquals(changesTestArr[3][14], " o ");
        assertEquals(changesTestArr[4][14], " o ");
        assertEquals(changesTestArr[5][14], " o ");
    }
    
    
    @Test
    public void squaresSurroundingTest(){
        createSquareArray();
        assertEquals(ng.squaresSurrounding(squaresTestArr, 4, 13), 1);
        assertEquals(ng.squaresSurrounding(squaresTestArr, 4, 14), 2);
        assertEquals(ng.squaresSurrounding(squaresTestArr, 4, 15), 1);
        assertEquals(ng.squaresSurrounding(squaresTestArr, 3, 14), 3);
        assertEquals(ng.squaresSurrounding(squaresTestArr, 5, 14), 3);
    }
    
    public void createSquareArray(){
        // Array with dead cells
        for (int i = 0; i < squaresTestArr.length; i++) {
            for (int j = 0; j < squaresTestArr[i].length; j++) {
                squaresTestArr[i][j] = " • ";
            }
        }
        // A few living cells
        squaresTestArr[4][13] = " o ";
        squaresTestArr[4][14] = " o ";
        squaresTestArr[4][15] = " o ";
    }

}
