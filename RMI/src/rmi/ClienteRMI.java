package rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


public class ClienteRMI {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        RMIClient cliente=new RMIClient();
        cliente.conectar();
        
        cliente.getMensagemBuffer().incluir(0, "Leozim");
        cliente.getMensagemBuffer().incluir(1, "Leonardo");
        
        cliente.getMensagemBuffer().alterar(0,"Do");
        
        cliente.getMensagemBuffer().excluir(1);
        
        List<String> listagem=cliente.getMensagemBuffer().consultarPorNome("Do");
        
        for(String linha:listagem){
            System.out.println(linha);
        }
    }
}

