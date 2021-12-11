package javathread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MeuRunnable implements Runnable{
    @Override
    public void run(){
        int i=0;
        while(i<10){
            i++;
            System.out.println("Thread: "+this+""+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MeuRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
