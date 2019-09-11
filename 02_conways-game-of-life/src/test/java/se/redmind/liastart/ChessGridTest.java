package se.redmind.liastart;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessGridTest {

    private ChessGrid chessGrid;

    @Before
    public void setUp() throws Exception {
        chessGrid = new ChessGrid(20, 30);
    }

    @Test
    public void createCells() {
        assertEquals(chessGrid.getCells().length, 20);
        assertEquals(chessGrid.getCells()[1].length, 30);
    }

}