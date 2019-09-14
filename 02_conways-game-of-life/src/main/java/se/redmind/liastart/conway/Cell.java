package se.redmind.liastart.conway;

import javafx.scene.control.Button;

public class Cell extends Button {

    private boolean alive;
    private boolean nextState;
    private int x;
    private int y;
    
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(boolean live, int x, int y) {
        this.alive = live;
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
        return alive;
    }

    public void setLive(boolean live) {
        this.alive = live;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isNextState() {
        return nextState;
    }

    public void setNextState(boolean nextState) {
        this.nextState = nextState;
    }

}
