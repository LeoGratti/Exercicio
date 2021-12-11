package javathread;

public class JavaThread {

    public static void main(String[] args) {
        MinhaThread t = new MinhaThread("l");
        t.setPriority(9);
        t.start();       
        
        MinhaThread u = new MinhaThread("e");
        u.setPriority(3);
        u.start();
        
        Runnable ru = new MeuRunnable();
        Thread tr=new Thread(ru);
        tr.start();
        
        Runnable rua = new MeuRunnable();//anonima
        @Override
        public void run(){
            int i = 0;
            while(i<30){
                System.out.println("Ola");
                i++;
            }
        }
    };
     
    Thread trua=new Thread(rua);
    trua.start();
    
    Runnable rual = () -> {
        int i=0;
        while(i<10){
            System.out.println("Lambda");
            i++;
        }        
    };
}
