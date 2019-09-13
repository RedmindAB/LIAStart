package se.redmind.liastart;

public class ConwayGame implements Runnable {

    private final int width;
    private final int size;
    private final int height;
    private final int seed = 9000;
    int[] board;
    public int[] postBoard;

    public ConwayGame() {
        this(100,100);
    }

    public ConwayGame(int width, int height) {
        this.width = width;
        this.height = height;
        this.size = width * height;
        board = new int[size];
    }
    //Updates the board for the next board

    // if alive return 1 else if dead return 0
    protected int alive(int x, int y, int[] board) {
        int alive = 0;
        int currentDot = y * width + x;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                int pos = j * width + i;
                if (pos >= 0 && pos < size - 1 && pos != currentDot) {
                    if (board[pos] == 1) {
                        alive++;
                    }
                }
            }
        }
        if (board[currentDot] == 0) {
            if (alive == 3) {
                System.out.print("*");
                return 1;
            }
            System.out.print(".");
            return 0;
        } else {
            if (alive < 2 || alive > 3) {//Dies
                System.out.print(".");
                return 0;
            }
            System.out.print("*");
            return 1;
        }
    }
    public void startGame() {
        randomsStart();
        new Thread(this).start();
    }
    //randomizes the starting position
    public void randomsStart() {
        for (int i = 0; i < seed; i++) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            board[y * width + x] = 1;
        }
    }
    public void update() {
        int[] previousBoard = new int[size];
        System.arraycopy(board, 0, previousBoard, 0, size);
        postBoard = new int[size];

        for (int i = 0; i < width; i++) {
            System.out.println("");
            for (int j = 0; j < height; j++) {
                int type = alive(i, j, previousBoard);
                if (type > 0) {
                    postBoard[j * width + i] = 1;
                } else {
                    postBoard[j * width + i] = 0;
                }
            }
        }
        System.arraycopy(postBoard, 0, board, 0, size);
    }
    public void run() {
        update();
        System.out.println();
        update();
    }
}