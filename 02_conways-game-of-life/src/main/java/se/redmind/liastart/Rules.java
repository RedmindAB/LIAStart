package se.redmind.liastart;

import java.util.ArrayList;
import java.util.List;

public class Rules {

    private ArrayList<Cell> neighbours = new ArrayList<>();
    private ArrayList<Cell> toBeChanged = new ArrayList<>();


    public void playGame(Cell[][] cells){

        for (int i = 0; i < cells.length; i++) {

            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                getNeighbours(cell.getLocationX(), cell.getLocationY(), cells);
                int amountOfNeighbourCells = getAmountOfNeighbourLivingCells(neighbours);
                decideIfCellShallLive(amountOfNeighbourCells, cell);
            }
        }
        changeStateOfCells();
    }

    public void getNeighbours(int x, int y, Cell[][] cells){

        neighbours = new ArrayList<>();

        try {
            neighbours.add(cells[y - 1][x]);
            neighbours.add(cells[y + 1][x]);
            neighbours.add(cells[y][x - 1]);
            neighbours.add(cells[y][x + 1]);
            neighbours.add(cells[y - 1][x - 1]);
            neighbours.add(cells[y + 1][x + 1]);
            neighbours.add(cells[y + 1][x - 1]);
            neighbours.add(cells[y - 1][x + 1]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("This error is expected due to check outside the game");
        }
    }

    public int getAmountOfNeighbourLivingCells(List<Cell> cells){


        int amountOfNeighbourLivingCells = 0;

        for (Cell cell: cells) {
            if(cell.getAlive()){
                amountOfNeighbourLivingCells++;
            }
        }


        return amountOfNeighbourLivingCells;
    }

    public void decideIfCellShallLive(int amountOfNeighbourLivingCells, Cell cell){

        if((amountOfNeighbourLivingCells <= 1 || amountOfNeighbourLivingCells >= 4) && cell.getAlive()){
            toBeChanged.add(cell);
        }else if(amountOfNeighbourLivingCells == 3 && !cell.getAlive()){
            toBeChanged.add(cell);
        }

    }

    public void changeStateOfCells(){
        toBeChanged.forEach(cell -> cell.clickOnCell());
        toBeChanged = new ArrayList<>();
    }

}
