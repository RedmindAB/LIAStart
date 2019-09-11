/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */


public class Square {
    
    int x;
    int y;
    boolean active;
    boolean activate=false;
    boolean deactive=false;

    public Square() {
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(int x, int y, boolean active) {
        this.x = x;
        this.y = y;
        this.active = active;
        
    }
    public void touch(){
        if(active)
            active=false;
        else
            active=true;
    }

    @Override
    public String toString() {
        return "Square{" + "x=" + x + ", y=" + y + ", active=" + active + ", activate=" + activate + ", deactive=" + deactive + '}';
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public boolean isDeactive() {
        return deactive;
    }

    public void setDeactive(boolean deactive) {
        this.deactive = deactive;
    }
    

}
