package se.redmind.liastart.conway;

import java.util.Random;

public class CellDAO {

    private Board board;
    private int columns;
    private int rows;
    private int numberOfCells;
    Cell[] allCells;

    public CellDAO(Board board) {
        this.board = board;
        this.columns = board.getCOLUMNS();
        this.rows = board.getROWS();
        this.numberOfCells = columns * rows;
        this.allCells = new Cell[numberOfCells];

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
                String cellColor = (randomLiveOrDeadBool) ? backgroundColor[0] : backgroundColor[1];
                cell.setStyle("-fx-background-color:" + cellColor);
                allCells[c] = cell;
                c++;
            }
        }
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
