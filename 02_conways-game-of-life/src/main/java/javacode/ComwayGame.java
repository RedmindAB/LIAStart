/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author Julia
 * 
 * This game is intererting. I think this is not so difficult
 * Because it only has two state: to be or not to be 
 * They depend on different conditions. It will be more difficult if we add more states and conditions
 * Maybe the big-data will help to perfect comways module, or use some intelligent programming can build module smart
 * 
 * I think this module can be used in many places
 * Like commercial investment, this module can help investor to analyze faster and do market-position precisely
 * 
 * Also I think this module should be dynamic, it needs new data-input to reset the condition
 * That means optimize the module by optimizing the conditions
 * So we can do the best thing in the beat time at the best place !
 * 
 */
public class ComwayGame {

    /**
     * @param args the command line arguments
     */
    public ComwayGame() {
        Gamcentral gc = new Gamcentral();
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComwayGame();
            }
        });
    }
}
