package se.redmind.liastart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cell extends JButton {

    private Boolean alive;
    private int locationX;
    private int locationY;


    public Cell(Boolean alive, int locationX, int locationY) {
        this.addActionListener(x -> clickOnCell());
        setAlive(alive);
        this.setOpaque(true);
        this.locationX = locationX;
        this.locationY = locationY;
        this.setBorder(new LineBorder(Color.WHITE));
    }

    public Boolean getAlive() {
        return alive;
    }


    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setAlive(Boolean alive) {
        if(alive){
            this.setBackground(Color.GREEN);
        }
        else{
            this.setBackground(Color.BLACK);
        }
        this.alive = alive;
    }

    public void clickOnCell(){
        System.out.println("HEEEEJ");
    }



}
