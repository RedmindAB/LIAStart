package se.redmind.liastart;

import javax.swing.*;
import java.awt.*;

public class ChessGrid extends JFrame {


    private Cell[][] cells;
    private int rows;
    private int columns;
    private JPanel jPanel;

    public ChessGrid(int rows, int columns){
        this.setVisible(true);
        this.rows = rows;
        this.columns = columns;
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.cells = new Cell[rows][columns];
        this.jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(rows, columns));
        this.add(jPanel);
    }

    public void createCells(){

        for (int i = 0; i < rows ; i++) {

            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(false, j, i);
                jPanel.add(cells[i][j]);
            }
        }
        jPanel.revalidate();
        jPanel.repaint();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }
}
