package javathread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MinhaThread extends Thread{
    String nome="";
    
    public MinhaThread(String nome){
        this.nome=nome;
    }      
    //metodo padrao - o que estiver dentro do run executa em paralelo
    @Override
    public void run(){
        int i=0;
        while(i<10){
            System.out.println(nome + ": "+i);
            i++;
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
