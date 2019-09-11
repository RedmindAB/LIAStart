package se.redmind.liastart.conway;

import javafx.scene.layout.GridPane;

public class GameController {

    Board board;
    CellDAO cellDAO;
    Cell[] allCells;

    public GameController(Board board, CellDAO cellDAO) {
        this.board = board;
        this.cellDAO = cellDAO;
    }

    public void paintBoard(GridPane gridPane) {

        Cell[] allCells = cellDAO.getAllCells();

        for (Cell c : allCells) {
            gridPane.add(c, c.getX(), c.getY());
        }
    }
}
