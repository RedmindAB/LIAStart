package Conways;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class Simulator {
    private Model model;
    private int lifeChance = 30; //percentage alive at start
    private boolean[][] gameBoard;
    private boolean[][] nextBoard;

    private GraphicsContext gc;


    public Simulator(Model model, GraphicsContext gc) {
        this.model = model;
        this.gameBoard = new boolean[model.getBoardWidth()][model.getBoardHeight()];
        this.nextBoard = new boolean[model.getBoardWidth()][model.getBoardHeight()];
        this.gc = gc;

    }

    public void play() {
        int cs = model.getCellSize();
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(model.getFrameDuration()), event -> {


            nextGeneration();
            swapBoards();


        }));
        timeline1.setCycleCount(100);
        timeline1.play();

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(model.getFrameDuration()), event -> {

            gc.clearRect(0, 0, model.getScreenWidth(), model.getScreenHeight());
            for (int x = 0; x < model.getBoardWidth(); x++) {
                for (int y = 0; y < model.getBoardHeight(); y++) {
                    if (gameBoard[x][y]) {
                        gc.fillRect(x * cs, y * cs, cs, cs);
                    }
                }
            }


        }));
        timeline2.setCycleCount(100);
        timeline2.play();
    }

    public void nextGeneration() {
        int numAdjacent;
        for (int x = 0; x < model.getBoardWidth(); x++) {
            for (int y = 0; y < model.getBoardHeight(); y++) {
                numAdjacent = checkAdjacent(gameBoard, x, y);
                //4 because it counts itself
                nextBoard[x][y] = numAdjacent == 3 || (numAdjacent == 4 && gameBoard[x][y]);
            }
        }
    }

    public void swapBoards() {
        boolean[][] swapBoard = gameBoard;
        gameBoard = nextBoard;
        nextBoard = swapBoard;
    }

    public int checkAdjacent(boolean[][] board, int x, int y) {
        int counter = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                counter += checkPoint(board, x + i, y + j);
            }
        }
        return counter;
    }

    public int checkPoint(boolean[][] board, int x, int y) {
        return (x >= 0 && x < model.getBoardWidth() &&
                y >= 0 && y < model.getBoardHeight() &&
                board[x][y])
                ? 1 : 0;
    }

    public void randomPlay() {

        for (int x = 0; x < model.getBoardWidth(); x++) {
            for (int y = 0; y < model.getBoardHeight(); y++) {
                double random = Math.random() * 100;
                gameBoard[x][y] = random <= lifeChance;
            }
        }

        play();
    }
    public void setGameBoard(boolean[][] gameBoard) {
        this.gameBoard = gameBoard;
    }


}
