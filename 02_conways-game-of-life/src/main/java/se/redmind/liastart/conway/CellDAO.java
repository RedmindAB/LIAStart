package se.redmind.liastart.conway;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CellDAO {
    private int columns = 24;
    private int rows = 12;
    private int numberOfCells = columns * rows;
    Cell[] allCells = new Cell[numberOfCells];

    public CellDAO() {
        createCells();
    }

    public void createCells() {
        Random random = new Random();
        String[] backgroundColor = new String[]{"#000000", "#ffffff"};

        int c = 0;
        
        for (int x = 0; x < columns; x++) {

            for (int y = 0; y < rows; y++) {

                boolean randomLiveOrDeadBool = random.nextBoolean();
                Cell cell = new Cell(randomLiveOrDeadBool, x, y);
                cell.setMaxSize(5, 5);
                String cellColor = (randomLiveOrDeadBool) ? backgroundColor[0] : backgroundColor[1];
                cell.setStyle("-fx-background-color:" + cellColor);
                allCells[c] = cell;
                c++;
            }
        }
        
        Collections.shuffle(Arrays.asList(allCells));
    }

    public Cell[] getAllCells() {
        return allCells;
    }

    public void setAllCells(Cell[] allCells) {
        this.allCells = allCells;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

    public void setNumberOfCells(int numberOfCells) {
        this.numberOfCells = numberOfCells;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

}
