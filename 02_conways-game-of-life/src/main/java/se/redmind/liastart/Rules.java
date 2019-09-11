package se.redmind.liastart;

import java.util.List;

public class Rules {


    public void playGame(Cell[][] cells){

        for (int i = 0; i < cells.length; i++) {

            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                decideIfCellShallLive(getAmountOfNeighbourLivingCells(cells, cell), cell);
            }
        }


    }

    public int getAmountOfNeighbourLivingCells(Cell[][] cells, Cell cell){

        int locationX = cell.getLocationX();
        int locationY = cell.getLocationY();
        int amountOfNeighbourLivingCells = 0;

        try {
            //Direkt ovanför
            if (cells[locationX][locationY - 1].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Diagonalt upp höger
            else if (cells[locationX + 1][locationY - 1].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Direkt till vänster
            else if (cells[locationX + 1][locationY].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Diagonalt ned höger
            else if (cells[locationX + 1][locationY + 1].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Direkt nedanför
            else if (cells[locationX][locationY + 1].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Diagonalt ned vänster
            else if (cells[locationX - 1][locationY + 1].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Direkt till vänster
            else if (cells[locationX - 1][locationY].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
            //Diagonalt upp vänster
            else if (cells[locationX - 1][locationY - 1].getAlive()) {
                amountOfNeighbourLivingCells++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("This error is expected due to check outside the game");
        }
        return amountOfNeighbourLivingCells;
    }

    public void decideIfCellShallLive(int amountOfNeighbourLivingCells, Cell cell){

        if(cell.getAlive() && amountOfNeighbourLivingCells < 2){
            cell.setAlive(false);
        }
        else if(cell.getAlive() && amountOfNeighbourLivingCells > 3){
            cell.setAlive(false);
        }
        else if(!cell.getAlive() && amountOfNeighbourLivingCells == 3){
            cell.setAlive(true);
        }
    }

}
