package se.redmind.liastart.conway;

import javafx.scene.control.Button;

public class Cell extends Button {

    private boolean live;
    private int x;
    private int y;

    public Cell(boolean live, int x, int y) {
        this.live = live;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

}
