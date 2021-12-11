package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class ServidorRMI {
    
        public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, InterruptedException, IOException {
            MensagemRMI_Imp msg = new MensagemRMI_Imp("");
            RMIServer_Mensagem srv_msg = new RMIServer_Mensagem(msg);

            List<String> buffer = new ArrayList<String>();
            String msg_cliente = "";
            
            while (true) {
                buffer.add(srv_msg.msgBuffer.get_mensagem());
                Thread.sleep(1000);
                buffer.add(srv_msg.msgBuffer.get_mensagem());
                if(buffer.get(0) == buffer.get(1))
                {
                    buffer.clear();
                }
                else
                {
                    msg_cliente = buffer.get(1);
                    System.out.println(msg_cliente);
                    buffer.clear();
                }
                // System.out.println(buffer.toString());
                // Scanner input = new Scanner(new InputStreamReader(System.in, "UTF-8"));
                // String texto = input.nextLine();
                // srv_msg.msgBuffer.put_mensagem("@Servidor: " + texto);
            }
        /*DAORMIClient msg=new DAORMIClient("Ola mundo cruel");
        RMIServer sv=new RMIServer(msg);   
        
        //enviar e receber mensagem
        //msg.put("servidor na parada mandando pro cliente");
        
        Thread.sleep(15000); //uma espera para poder enviar ao cliente
        
        //System.out.println(""+msg.get()); //um recebimento*/
    }
}

