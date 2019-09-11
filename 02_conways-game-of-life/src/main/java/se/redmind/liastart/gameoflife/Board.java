package se.redmind.liastart.gameoflife;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {

    private GridPane grid;

    private int rows;
    private int columns;
    private ArrayList<Cell> cells;
    private int cellSize;
    
    private boolean randomStartingBoard;
    
    private int nw, n, ne, w, e, sw, s, se;

    public Board(int rows, int columns, ArrayList<Cell> cells, int cellSize, boolean randomStartingBoard) {
        this.rows = rows;
        this.columns = columns;
        this.cells = cells;
        this.cellSize = cellSize;
        this.randomStartingBoard = randomStartingBoard;
        
        nw = - columns - 1;
        n = - columns;
        ne = -columns + 1;
        w = -1;
        e= +1;
        sw = columns - 1;
        s = columns;
        se = columns + 1;
    }

    public GridPane resetBoard() {
        Random rand = new Random();

        grid = new GridPane();
        cells = new ArrayList();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Cell cell = new Cell(new Position(r, c));
                
                if (randomStartingBoard) {
                    cell.setCurrentState(rand.nextBoolean());
                }               
                
                cells.add(cell);
                
                Rectangle rec = new Rectangle(cellSize, cellSize);
                rec.setStroke(Color.GREY);
//                rec.setStrokeWidth(0.1); // change the stroke width
                

                if (cell.getCurrentState()) {
                    rec.setFill(Color.BLACK);
                } else {
                    rec.setFill(Color.WHITE);
                }

                grid.add(rec, r, c);

                rec.setOnMouseClicked((event) -> {
                    cell.switchCurrentState();
                    if (cell.getCurrentState()) {
                        rec.setFill(Color.BLACK);
                    } else {
                        rec.setFill(Color.WHITE);
                    }
                });
            }
        }

        return grid;
    }
    
    public void next(GridPane board) {
        for (int i = 0; i < cells.size(); i++) {
            int aliveNeighbours = countAliveNeighbours(i);
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                cells.get(i).setNextState(false);
            } else if (aliveNeighbours == 3) {
                cells.get(i).setNextState(true);
            } else if (aliveNeighbours == 2) {
                cells.get(i).setNextState(cells.get(i).getCurrentState());
            }
        }

        for (int i = 0; i < cells.size(); i++) {
            cells.get(i).updateState();
            Rectangle rec = (Rectangle) grid.getChildren().get(i);
            if (cells.get(i).getCurrentState()) {
                rec.setFill(Color.BLACK);
            } else {
                rec.setFill(Color.WHITE);
            }
        }
    }

    
    public int countAliveNeighbours(int i) {
        int aliveNeighbours = 0;
        Position p = cells.get(i).getPosition();
        //NorthWest
        if (p.getRow() != 0 && p.getColumn() != 0) {
            if (isCellAlive(i + nw)) {
                aliveNeighbours++;
            }
        }
        //North
        if (p.getRow() != 0) {
            if (isCellAlive(i + n)) {
                aliveNeighbours++;
            }
        }
        //NorthEast
        if (p.getRow() != 0 && p.getColumn() != columns - 1) {
            if (isCellAlive(i + ne)) {
                aliveNeighbours++;
            }
        }
        //West
        if (p.getColumn() != 0) {
            if (isCellAlive(i + w)) {
                aliveNeighbours++;
            }
        }
        //East
        if (p.getColumn() != columns - 1) {
            if (isCellAlive(i + e)) {
                aliveNeighbours++;
            }
        }
        //SouthWest
        if (p.getRow() != rows - 1 && p.getColumn() != 0) {
            if (isCellAlive(i + sw)) {
                aliveNeighbours++;
            }
        }
        //South
        if (p.getRow() != rows - 1) {
            if (isCellAlive(i + s)) {
                aliveNeighbours++;
            }
        }
        //SouthWest
        if (p.getRow() != rows - 1 && p.getColumn() != columns - 1) {
            if (isCellAlive(i + se)) {
                aliveNeighbours++;
            }
        }

        return aliveNeighbours;
    }

    public boolean isCellAlive(int position) {
        return cells.get(position).getCurrentState();
    }

    

}
