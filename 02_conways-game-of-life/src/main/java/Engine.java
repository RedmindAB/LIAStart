
import java.util.Timer;
//import javax.swing.Timer;
import java.util.TimerTask;

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


public class Engine {
    
    Label grid;
    
    int ticks = 0;
    int speed=600;
    
    Timer timer = new Timer();
    

    
    public void start(){
        timer = new Timer();
        TimerTask doStuff = new TimerTask(){
            public void run(){
                ticks++;
                grid.tick();
                System.out.println("Iteration #:" + ticks);
            }
        };
        timer.scheduleAtFixedRate(doStuff, 200, speed);
            
    }
    public void pause() {
        this.timer.cancel();
    }
    public void faster(){
        if(speed>250){
            speed-=200;
            pause();
            timer = new Timer();
            start();
        }
    }
    public void slower(){
        speed+=200;
        pause();
        timer = new Timer();
        start();
    }
    
    public void setGrid(Label grid){
        this.grid=grid;
    }

}
