package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer_Mensagem {
    
    MensagemRMI_Imp msgBuffer;

    public RMIServer_Mensagem(MensagemRMI_Imp msgBuffer) throws AlreadyBoundException, MalformedURLException{
        this.msgBuffer=msgBuffer;
        System.setProperty("java.security.policy","file:./politicas.policy");
       // if (System.getSecurityManager() == null)
        //    System.setSecurityManager(new RMISecurityManager());
        
        try{
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
           //MensagemBuffer mensagem=new MensagemBuffer(10);           //serializar
           MensagemRMI_Interface stub=(MensagemRMI_Interface) UnicastRemoteObject.exportObject((Remote) msgBuffer, 0);
           Registry registry=LocateRegistry.createRegistry(5003);
           registry.rebind("MensagemService", stub);
        //    System.out.println("Servidor pronto!");
        }catch(RemoteException re){
            re.getStackTrace();
        }
    }    
}
