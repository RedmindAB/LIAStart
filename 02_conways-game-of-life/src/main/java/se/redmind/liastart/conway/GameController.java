package se.redmind.liastart.conway;

import javafx.scene.layout.GridPane;

public class GameController {

    Board board;
    Cell[] allCells;
    GridPane gridPane;
    boolean FIRST_CALL = true;

    public GameController(Board board, Cell[] allCells, GridPane gridPane) {
        this.board = board;
        this.allCells = allCells;
        this.gridPane = gridPane;
    }

    public GridPane paintBoard() throws InterruptedException {

        if (!FIRST_CALL) {

            System.out.println("second call");
            return repaintBoard();

        } else {
            System.out.println("first call");

            FIRST_CALL = false;

            for (Cell c : allCells) {
                gridPane.add(c, c.getX(), c.getY());
            }
        }

        return gridPane;

    }

    public GridPane repaintBoard() throws InterruptedException {

        System.out.println("repainting");

        for (int i = 0; i < allCells.length - 1; i++) {

            int livingNeighbours = (countNeighbours(i));

            // Conditions when cell is alive
            if (allCells[i].isAlive()) {

                if (livingNeighbours < 2) {
                    allCells[i].setNextState(false);
                }

                if (livingNeighbours >= 2) {
                    allCells[i].setNextState(true);
                }

                if (livingNeighbours > 3) {
                    allCells[i].setNextState(false);
                }

                // Conditions when cell is dead
            } else if (!allCells[i].isAlive() && livingNeighbours == 3) {
                allCells[i].setNextState(true);
            } else {
                allCells[i].setNextState(false);
            }
        }

        for (Cell c : allCells) {
            gridPane.add(c, c.getX(), c.getY());
        }

        return gridPane;

    }

    public int countNeighbours(int cellId) {

        int livingNeighbours = 0;
        int x = allCells[cellId].getX();
        int y = allCells[cellId].getY();
        final int MAX_COLUMNS = board.getCOLUMNS() - 1;
        final int MAX_ROWS = board.getROWS() - 1;

        // Check top neighbours
        if (x != 0 && y != 0) {

            livingNeighbours += (isNeighbourAlive(x - 1, y - 1)) ? 1 : 0;
            livingNeighbours += (isNeighbourAlive(x - 1, y)) ? 1 : 0;
            livingNeighbours += (isNeighbourAlive(x - 1, y + 1)) ? 1 : 0;
        }

        // Check left and right neighbours
        if (x != 0 && y != MAX_COLUMNS) {

            livingNeighbours += (isNeighbourAlive(x, y - 1)) ? 1 : 0;
            livingNeighbours += (isNeighbourAlive(x, y + 1)) ? 1 : 0;
        }

        // Check bottom neighbours
        if (x != MAX_ROWS && y != MAX_COLUMNS) {

            livingNeighbours += (isNeighbourAlive(x + 1, y - 1)) ? 1 : 0;
            livingNeighbours += (isNeighbourAlive(x + 1, y)) ? 1 : 0;
            livingNeighbours += (isNeighbourAlive(x + 1, y + 1)) ? 1 : 0;

        }
        return livingNeighbours;

    }

    public boolean isNeighbourAlive(int x, int y) {

        for (Cell c : allCells) {
            if (c.getX() == x && c.getY() == y) {
                return c.isAlive();
            }
        }

        return false;
    }
}
