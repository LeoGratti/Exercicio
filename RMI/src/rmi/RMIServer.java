package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    
    DAORMIClient msgBuffer;

    public RMIServer(DAORMIClient msgBuffer) throws AlreadyBoundException, MalformedURLException{
        this.msgBuffer=msgBuffer;
        System.setProperty("java.security.policy","file:./politicas.policy");
       // if (System.getSecurityManager() == null)
        //    System.setSecurityManager(new RMISecurityManager());
        
        try{
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
           //System.setProperty("java.rmi.server.hostname","192.168.0.94");
           //MensagemBuffer mensagem=new MensagemBuffer(10);           //serializar
           DAORMIClientInterface stub=(DAORMIClientInterface) UnicastRemoteObject.exportObject(msgBuffer, 0);
           Registry registry=LocateRegistry.createRegistry(5003);
           registry.rebind("MensagemService", stub);
           System.out.println("Servidor pronto!");
        }catch(RemoteException re){
            re.getStackTrace();
        }
    }     
}

