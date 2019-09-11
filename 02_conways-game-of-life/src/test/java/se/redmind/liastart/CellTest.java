package se.redmind.liastart;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    private Cell cell;

    @Before
    public void setUp() throws Exception {
        cell = new Cell(false, 0,0);
    }


    @Test
    public void setAlive() {
        assertFalse(cell.getAlive());
        cell.setAlive(true);
        assertTrue(cell.getAlive());

    }

    @Test
    public void clickOnCell() {
        assertFalse(cell.getAlive());
        cell.clickOnCell();
        assertTrue(cell.getAlive());
    }
}