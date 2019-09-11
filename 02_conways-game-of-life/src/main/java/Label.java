
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javax.swing.JLabel;

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


public class Label extends JLabel implements MouseListener{

    Square square[][];
    
    List<Square> squaresToStartActive = new ArrayList();
    List<Square> activeSquares = new ArrayList();
        
    int squareSize = 20;
    int amountOfSquares=45;
    
    public Label() {
        addMouseListener(this);
        square = new Square[amountOfSquares][amountOfSquares];
        for(int x=0; x<amountOfSquares; x++){
            for(int y=0; y<amountOfSquares; y++){
                square[x][y]=new Square(x,y,false);
            }
        }
        square[30][30].touch();
        square[31][30].touch();
        square[30][31].touch();
        square[31][31].touch();
        
        
        square[10][10].touch();
        square[10][11].touch();
        square[10][12].touch();
        square[9][12].touch();
        square[8][11].touch();
        
        
    }
    
    public void doStuff(){
        int a = (int)(Math.random()*amountOfSquares);
        int b = (int)(Math.random()*amountOfSquares);
        square[a][b].touch();
        repaint();
    }
    
    public void tick(){
        
        //here we go through all squares
        for(int x=1; x<amountOfSquares-1; x++){
            for(int y=1; y<amountOfSquares-1; y++){
                //active is how many neighbours to the square that are active
                int neighbours=0;
                //these 2 for loops go through all squares around the square
                //but also itself, that's why the if that checks if the loop is looking 
                //at itself, if so it doesn't increase the active-variable
                for(int i=x-1; i<=x+1; i++){
                    for(int ii=y-1; ii<=y+1; ii++){
                        if(square[i][ii].active){
                            if(!(i== x && y == ii)){
                                neighbours++;
                            }
                        }
                            
                    }
                }
                if(neighbours<2 && square[x][y].active){
                    square[x][y].setDeactive(true);
                }
                else if(neighbours > 3 && square[x][y].active){
                    square[x][y].setDeactive(true);
                }
                else if(neighbours == 3 && !square[x][y].active){
                    square[x][y].setActivate(true);
                }
            }
        }
        //the above loops marks the squares for activation/inactivation
        //the below loops then actually activates/deactivates them
        for(int x=1; x<amountOfSquares-1; x++){
            for(int y=1; y<amountOfSquares-1; y++){
                if(square[x][y].activate){
                    square[x][y].setActive(true);
                    square[x][y].setActivate(false);
                    square[x][y].setDeactive(false);
                }
                else if (square[x][y].deactive){
                    square[x][y].setActive(false);
                    square[x][y].setDeactive(false);
                    square[x][y].setActivate(false);
                }
            }
        }
        repaint();
    }

    public void add10(){
        for(int x=0; x<10; x++){
            int a = (int)(Math.random()*(amountOfSquares-1))+1;
            int b = (int)(Math.random()*(amountOfSquares-1))+1;
            square[a][b].touch();
            
        }
        repaint();
    }
    
    
    
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            
            
            for(int horizontal=0; horizontal<amountOfSquares; horizontal++){
                for(int vertical=0; vertical<amountOfSquares; vertical++){
                    
                    g.setColor(java.awt.Color.gray);
                    g.drawRect((horizontal*squareSize), (vertical*squareSize), squareSize, squareSize);
                    
//                    
                    if(square[horizontal][vertical].active){
                        g.setColor(java.awt.Color.black);
                        g.fillRect((horizontal*squareSize), (vertical*squareSize), squareSize, squareSize);
                    }
                }
            }
            g2d.dispose();
        }

    public void mouseClicked(MouseEvent e) {
        System.out.println("klickade pa ruta!");
        square[(int)((e.getPoint().getX()/squareSize))][(int)((e.getPoint().getY())/squareSize)].touch();
        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    

    
    
    
}
