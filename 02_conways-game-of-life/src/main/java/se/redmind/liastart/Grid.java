/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.redmind.liastart;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author xingao
 */
public class Grid extends JFrame {

    JPanel p = new JPanel();
    JPanel b = new JPanel();
    JButton start = new JButton("Start");
    JButton clear = new JButton("Clear");
    Font fnt = new Font("Serief", Font.BOLD, 30);
    JLabel[][] labArray = new JLabel[30][30];
    JLabel tom = new JLabel();
    Dimension dim = new Dimension();
    HashMap<JLabel, Boolean> labsMap = new HashMap<JLabel, Boolean>();
    HashMap<JLabel, Integer> labsMapN = new HashMap<JLabel, Integer>();

    public Grid() {
        p.setLayout(new GridLayout(30, 30));
        b.setLayout(new GridLayout(1, 2));
        initialize();
        start.addActionListener(l -> {
            findLiveNumber();
            liveOrDie();
        });
        clear.addActionListener(m -> {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {                    
                    labArray[i][j].setBackground(Color.WHITE);                  
                    labsMap.put(labArray[i][j], false);
                    labsMapN.put(labArray[i][j], 0);                   
                }
            }
        });
        b.add(start, CENTER);
        b.add(clear, CENTER);

        this.add(p, CENTER);
        this.add(b, SOUTH);
        pack();
        this.setVisible(true);
        this.setLocation(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    MouseAdapter ml = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int x = 0; x < 30; x++) {
                for (int y = 0; y < 30; y++) {
                    if (e.getComponent() == labArray[x][y]) {
                        labArray[x][y].setBackground(Color.BLACK);
                        labsMap.replace(labArray[x][y], true);
                    }
                }
            }
        }
    };

    public void initialize() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                labArray[i][j] = new JLabel();
                dim.setSize(20, 20);
                labArray[i][j].setPreferredSize(dim);
                labArray[i][j].setOpaque(true);
                labArray[i][j].setBackground(Color.WHITE);
                labArray[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
                labsMap.put(labArray[i][j], false);
                labsMapN.put(labArray[i][j], 0);
                p.add(labArray[i][j], CENTER);
                labArray[i][j].addMouseListener(ml);
            }
        }
    }

    public ArrayList findNeighbors(int x, int y, int n) {
        ArrayList neighbors = new ArrayList(8);
        for (int dx = (x > 0 ? -1 : 0); dx <= (x < n - 1 ? 1 : 0); ++dx) {
            for (int dy = (y > 0 ? -1 : 0); dy <= (y < n - 1 ? 1 : 0); ++dy) {
                if (dx != 0 || dy != 0) {
                    neighbors.add(labArray[x + dx][y + dy]);
                }
            }
        }
        return neighbors;

    }

    public void findLiveNumber() {
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                int n = 0;
                for (int i = 0; i < findNeighbors(x, y, 30).size(); i++) {
                    if (labsMap.get(findNeighbors(x, y, 30).get(i)) == true) {
                        n++;
                    }
                }
                labsMapN.put(labArray[x][y], n);

            }
        }

    }

    public void liveOrDie() {
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                int n = labsMapN.get(labArray[x][y]);
                boolean life = labsMap.get(labArray[x][y]);
                if ((life == true) && n >= 2 && n <= 3) {
                    labArray[x][y].setBackground(Color.BLACK);
                } else if ((life == true) && (n > 3 || n < 2)) {
                    labsMap.put(labArray[x][y], false);
                    labArray[x][y].setBackground(Color.WHITE);

                } else if ((life == false) && n == 3) {
                    labsMap.put(labArray[x][y], true);
                    labArray[x][y].setBackground(Color.BLACK);

                }

            }
        }
    }
}
