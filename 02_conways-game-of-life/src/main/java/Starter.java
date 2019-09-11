
import java.util.Timer;
import java.util.TimerTask;


//import javax.swing.Timer;

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


public class Starter {
    public static void main(String args[]){
        Engine engine = new Engine();
        GraphicalWindow gw = new GraphicalWindow(engine);
        
        
        engine.setGrid(gw.getGrid());
    }

}
