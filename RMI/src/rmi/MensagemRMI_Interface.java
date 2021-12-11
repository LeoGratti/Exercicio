package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MensagemRMI_Interface extends Remote {    
    
    public void put_mensagem(String txt) throws RemoteException;
    public String get_mensagem() throws RemoteException;
}
