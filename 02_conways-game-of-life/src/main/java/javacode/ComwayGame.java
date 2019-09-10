/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;

import javax.swing.SwingUtilities;

/**
 *
 * @author Julia
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
