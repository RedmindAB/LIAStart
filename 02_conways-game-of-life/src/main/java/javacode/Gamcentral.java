/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Julia
 */
public class Gamcentral extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel totalP = new JPanel();
    JPanel again = new JPanel();
    JPanel pane = new JPanel();
    JTextArea area = new JTextArea("Click buttons to create life." + "\nClick 'next' to see happening!");
    JButton next = new JButton("Next");
    JButton stop = new JButton("Stop");
    JButton[][] button = null;
    Color color = new Color(238, 238, 238);
    Timer timer = new Timer();
    public Gamcentral() {

        int n = 10;
        button = createButton(n);
        totalP.setLayout(new BorderLayout());
        again.setLayout(new GridLayout(10, 1));
        again.setBorder(new EmptyBorder(5, 5, 5, 5));
        again.add(area);
        again.add(next);
        again.add(stop);
        stop.setEnabled(false);
        pane.setLayout(new GridLayout(n, n));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pane.add(button[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                button[i][j].addActionListener(this);
            }
        }

//        
        next.addActionListener(ae -> {   //Lamda  
            next.setEnabled(false);
            stop.setEnabled(true);
            start(n);
        });
        stop.addActionListener(ae -> {   //Lamda  
            next.setEnabled(true);
            stop.setEnabled(false);
            stop();
        });

        pane.setPreferredSize(new Dimension(600, 600));
        totalP.add(pane, BorderLayout.CENTER);
        totalP.add(again, BorderLayout.WEST);

        frame.add(totalP);
        frame.pack();
        frame.setLocation(600, 50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }   //konstruktur
    
    public void start(int n){
        timer = new Timer();
        TimerTask dostuff = new TimerTask(){
            @Override
            public void run() {
                next(n);
            }           
        };
        timer.scheduleAtFixedRate(dostuff, 2000, 2000);
    }
    public void stop(){
        timer.cancel();
    }

    public void next(int n) {
        change(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String text = button[i][j].getText();
                int first = Integer.parseInt(text.substring(0, 1));
                int last = Integer.parseInt(text.substring(1));
                if (first == 1) {
                    if (last >= 2 && last <= 3) {
                        button[i][j].setText("10");
                    } else {
                        button[i][j].setText("00");
                    }
                } else {
                    if (last == 3) {
                        button[i][j].setText("10");
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String text = button[i][j].getText();
                int first = Integer.parseInt(text.substring(0, 1));
                if (first == 1) {
                    button[i][j].setBackground(Color.red);
                } else {
                    button[i][j].setBackground(color);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((button[i][j].getText()).startsWith("1")) {
                    button[i][j].setForeground(Color.red);
                } else {
                    button[i][j].setForeground(color);
                }

            }
        }
        pane.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        String text = jb.getText();
        String first = text.substring(0, 1);
        String last = text.substring(1);
        switch (first) {
            case "1":
                text = 0 + last;
                jb.setText(text);
                jb.setBackground(color);
                jb.setForeground(color);
                break;
            default:
                text = 1 + last;
                jb.setText(text);
                jb.setBackground(Color.red);
                jb.setForeground(Color.red);
        }

    }

    public static JButton[][] createButton(int n) {
        JButton[][] button = new JButton[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String ss = "00";
                button[i][j] = new JButton(ss);
                button[i][j].setBackground(new Color(238, 238, 238));
                button[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                button[i][j].setForeground(new Color(238, 238, 238));
            }
        }
        return button;
    }

    public void change(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi][indexj + 1].getText();
                        String t2 = button[indexi + 1][indexj + 1].getText();
                        String t3 = button[indexi + 1][indexj].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int total = numt1 + numt2 + numt3;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("uppLC");
                    } else if (j == button.length - 1) {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi][indexj - 1].getText();
                        String t2 = button[indexi + 1][indexj - 1].getText();
                        String t3 = button[indexi + 1][indexj].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int total = numt1 + numt2 + numt3;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("uppRC");                            
                    } else {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi][indexj - 1].getText();
                        String t2 = button[indexi][indexj + 1].getText();
                        String t3 = button[indexi + 1][indexj - 1].getText();
                        String t4 = button[indexi + 1][indexj].getText();
                        String t5 = button[indexi + 1][indexj + 1].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int numt4 = Integer.parseInt(t4.substring(0, 1));
                        int numt5 = Integer.parseInt(t5.substring(0, 1));
                        int total = numt1 + numt2 + numt3 + numt4 + numt5;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("uppM");                                                        
                    }
                } else if (i > 0 && i < button.length - 1) {
                    if (j == 0) {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi - 1][indexj].getText();
                        String t2 = button[indexi - 1][indexj + 1].getText();
                        String t3 = button[indexi][indexj + 1].getText();
                        String t4 = button[indexi + 1][indexj].getText();
                        String t5 = button[indexi + 1][indexj + 1].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int numt4 = Integer.parseInt(t4.substring(0, 1));
                        int numt5 = Integer.parseInt(t5.substring(0, 1));
                        int total = numt1 + numt2 + numt3 + numt4 + numt5;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("LeftM");                                                                                   
                    } else if (j == button.length - 1) {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi - 1][indexj].getText();
                        String t2 = button[indexi - 1][indexj - 1].getText();
                        String t3 = button[indexi][indexj - 1].getText();
                        String t4 = button[indexi + 1][indexj].getText();
                        String t5 = button[indexi + 1][indexj - 1].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int numt4 = Integer.parseInt(t4.substring(0, 1));
                        int numt5 = Integer.parseInt(t5.substring(0, 1));
                        int total = numt1 + numt2 + numt3 + numt4 + numt5;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("RightM");                                                                                                               
                    } else {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi - 1][indexj].getText();
                        String t2 = button[indexi - 1][indexj - 1].getText();
                        String t3 = button[indexi - 1][indexj + 1].getText();
                        String t4 = button[indexi][indexj - 1].getText();
                        String t5 = button[indexi][indexj + 1].getText();
                        String t6 = button[indexi + 1][indexj - 1].getText();
                        String t7 = button[indexi + 1][indexj].getText();
                        String t8 = button[indexi + 1][indexj + 1].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int numt4 = Integer.parseInt(t4.substring(0, 1));
                        int numt5 = Integer.parseInt(t5.substring(0, 1));
                        int numt6 = Integer.parseInt(t6.substring(0, 1));
                        int numt7 = Integer.parseInt(t7.substring(0, 1));
                        int numt8 = Integer.parseInt(t8.substring(0, 1));
                        int total = numt1 + numt2 + numt3 + numt4 + numt5 + numt6 + numt7 + numt8;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("Middle");                                                                                                                                           
                    }
                } else {
                    if (j == 0) {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi][indexj + 1].getText();
                        String t2 = button[indexi - 1][indexj + 1].getText();
                        String t3 = button[indexi - 1][indexj].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int total = numt1 + numt2 + numt3;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("downLC");                                                                                                                                                                      
                    } else if (j == button.length - 1) {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi][indexj - 1].getText();
                        String t2 = button[indexi - 1][indexj - 1].getText();
                        String t3 = button[indexi - 1][indexj].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int total = numt1 + numt2 + numt3;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("downRC");                                                                                                                                                                      
                    } else {
                        int indexi = i;
                        int indexj = j;
                        String t1 = button[indexi][indexj - 1].getText();
                        String t2 = button[indexi][indexj + 1].getText();
                        String t3 = button[indexi - 1][indexj - 1].getText();
                        String t4 = button[indexi - 1][indexj].getText();
                        String t5 = button[indexi - 1][indexj + 1].getText();
                        String text = button[i][j].getText();
                        int numt1 = Integer.parseInt(t1.substring(0, 1));
                        int numt2 = Integer.parseInt(t2.substring(0, 1));
                        int numt3 = Integer.parseInt(t3.substring(0, 1));
                        int numt4 = Integer.parseInt(t4.substring(0, 1));
                        int numt5 = Integer.parseInt(t5.substring(0, 1));
                        int total = numt1 + numt2 + numt3 + numt4 + numt5;
                        text = text.substring(0, 1) + total;
                        button[i][j].setText(text);
//                            button[i][j].setText("downM");                                                                                                                                                                      
                    }
                }
            }
        }
        pane.setVisible(true);
    }
}
