package se.redmind.liastart;

public class Game implements Runnable {

    private final int width;
    private final int height;
    private final int size;
    private final int seed = 9000;
    int[] board;
    public int[] nextBoard;

    public Game() {
        this(100,100);
    }

    public Game(int width, int height) {

        this.width = width;
        this.height = height;
        this.size = width * height;
        board = new int[size];

    }
    
    //Updates the board for the next generation
    public void update() {

        int[] prevBoard = new int[size];
        System.arraycopy(board, 0, prevBoard, 0, size);
        nextBoard = new int[size];

        for (int i = 0; i < width; i++) {
            System.out.println("");
            for (int j = 0; j < height; j++) {
                int type = alive(i, j, prevBoard);
                if (type > 0) {
                    nextBoard[j * width + i] = 1;
                } else {
                    nextBoard[j * width + i] = 0;
                }
            }
        }
        System.arraycopy(nextBoard, 0, board, 0, size);
    }

  
    // Returns 0 if dead and 1 if alive
    protected int alive(int x, int y, int[] board) {
        int aliveNeighbours = 0;
        int current = y * width + x;
        for (int i = x - 1; i <= x + 1; i++) {            
            for (int j = y - 1; j <= y + 1; j++) {
                int pos = j * width + i;
                if (pos >= 0 && pos < size - 1 && pos != current) {
                    if (board[pos] == 1) {
                        aliveNeighbours++;
                    }
                }
            }
        }
        if (board[current] == 0) {           
            if (aliveNeighbours == 3) {
         System.out.print("*");
                return 1;
            }
           System.out.print(".");
            return 0;
        } else {
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {//Dies
              System.out.print(".");
                return 0;
            }
           System.out.print("*");
            return 1;

        }

    }
    
    //sets the board to a random beginning
    public void randomSeed() {
        for (int i = 0; i < seed; i++) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            board[y * width + x] = 1;

        }

    }

    public int[] getBoard() {

        return board;

    }

    public void start(){
        randomSeed();
        new Thread(this).start();
    }
    /*
    run should have a loop to update the board and show the next generation on an on
    but i couldn't get this to work with swing so thats why the update method gets
    called twice here, just to see two generations.
    */
    public void run() {
        
        update();
        System.out.println();
        update();

    }
}
