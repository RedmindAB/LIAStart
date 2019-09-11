package se.redmind.liastart.gameoflife;

public class Cell {

    private boolean currentState;
    private boolean newState;
    private Position position;

    public Cell() {
        currentState = false;
        newState = currentState;
    }
    public Cell(Position position) {
        this.position = position;
    }

    public Cell(boolean currentState) {
        this.currentState = currentState;
        newState = currentState;
    }

    public Cell(boolean currentState, Position position) {
        this.currentState = currentState;
        this.position = position;
    }

    public void setCurrentState(boolean currentState) {
        this.currentState = currentState;
    }

    public boolean getCurrentState() {
        return currentState;
    }

    public void updateState() {
        this.currentState = newState;
    }

    public void setNextState(boolean nextState) {
        this.newState = nextState;
    }

    public Position getPosition() {
        return position;
    }
    
    public int getArrayPosition() {
        int p = (position.getRow()*10) + position.getColumn();
        return p;
    }

    public void switchCurrentState() {
        currentState = !currentState;
        newState = currentState;
    }


}
