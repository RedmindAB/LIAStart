package Conways;

public class Model {
    private int cellSize;
    private int boardWidth;
    private int boardHeight;
    private int screenWidth;
    private int screenHeight;
    private Double frameDuration;
    private boolean[][] startBoard;



    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
        screenHeight=cellSize*boardHeight;
        screenWidth=cellSize*boardWidth;
        startBoard = new boolean[boardWidth][boardHeight];
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Double getFrameDuration() {
        return frameDuration;
    }

    public void setFrameDuration(int frameRate) {
        this.frameDuration = 1D/frameRate;
    }

    public boolean[][] getStartBoard() {
        return startBoard;
    }

    public void setStartBoard(boolean[][] startBoard) {
        this.startBoard = startBoard;
    }
}
