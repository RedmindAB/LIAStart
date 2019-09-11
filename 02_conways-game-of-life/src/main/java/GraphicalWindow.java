
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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


public class GraphicalWindow implements ActionListener{

    Engine engine;
    
    JFrame frame = new JFrame();
    Label grid = new Label();
    JLabel buttonLabel = new JLabel();
    
    JButton start = new JButton("start");
    JButton stop = new JButton("stop");
    JButton faster = new JButton("faster");
    JButton slower = new JButton("slower");
    JButton add10 = new JButton("add 10 random square");
    JTextField speedCheck = new JTextField("600.00");
    
    
    
    public GraphicalWindow(Engine engine) {
        this.engine=engine;
        //buttonLabel.add(stop);
        buttonLabel.add(start);
        buttonLabel.add(stop);
        buttonLabel.add(faster);
        buttonLabel.add(slower);
        buttonLabel.add(add10);
        buttonLabel.add(speedCheck);
        
        start.addActionListener(this);
        stop.addActionListener(this);
        faster.addActionListener(this);
        slower.addActionListener(this);
        add10.addActionListener(this);
        
        buttonLabel.setLayout(new FlowLayout());
        start.setEnabled(true);
        start.setVisible(true);  
        start.setSize(new Dimension(65,35));
        stop.setSize(new Dimension(65,35));
        
        
        frame.setSize(1200,900);
        frame.setLayout(new FlowLayout());
       
        grid.setOpaque(true);
        grid.setLayout(new FlowLayout());
        grid.setBackground(Color.white);
        grid.setBorder(BorderFactory.createLineBorder(Color.black));
        grid.setPreferredSize(new Dimension(900,900));
        frame.add(grid);
        grid.setVisible(true);
        
        
        
        buttonLabel.setForeground(Color.blue);
        buttonLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonLabel.setPreferredSize(new Dimension (300,900));
        frame.add(buttonLabel);
        buttonLabel.setVisible(true);
        
        
        
        
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
    
    public Label getGrid(){
        return grid;
    }

    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==start){
             engine.start();
         }
          else if (e.getSource()==stop){
              engine.pause();
          }
         else if (e.getSource()==faster){
              engine.faster();
              speedCheck.setText(Integer.toString(engine.speed));
          }
         else if (e.getSource()==slower){
              engine.slower();
              speedCheck.setText(Integer.toString(engine.speed));
          }
         else if (e.getSource()==add10){
              grid.add10();
          }
    }

}
