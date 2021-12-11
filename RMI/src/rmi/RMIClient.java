package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.DAORMIClientInterface;


public class RMIClient {
    static DAORMIClientInterface mensagem;
    
    public static void conectar() throws NotBoundException, MalformedURLException, RemoteException{
        
        System.setProperty("java.security.policy","file:./politicas.policy");
      //  if (System.getSecurityManager() == null)
      //      System.setSecurityManager(new RMISecurityManager());
        
        
        Registry registry =LocateRegistry.getRegistry("127.0.0.1", 5003);
        mensagem=(DAORMIClientInterface) registry.lookup("MensagemService");
        
        //lista os servicos
        /*String[] servicos=registry.list();
        for(int i=0;i<servicos.length;i++){
            System.out.println(servicos[i]);
        }*/
        
        //System.out.println(mensagem.Hello());
    }   
    
    public DAORMIClientInterface getMensagemBuffer(){
        return mensagem;
    }
}

