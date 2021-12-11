package javasocketexemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        PrintWriter imprimeNoSocket;
        BufferedReader leitor;      
            
        try{    
            //mensagem de entrada
            System.out.println("Cliente tentando conectar");
            
            //cria a conexao com o socket servidor
            Socket tsocket = new Socket("192.168.0.1", 8889);
            
            //Cliente conectado
            System.out.println("Cliente conectado...");
            
            //cria o gerenciador da stream de saída do coscket
            imprimeNoSocket = new PrintWriter(tsocket.getOutputStream());
            
            //cria o gerenciador da stream de entrada e leitura do socket
            leitor = new BufferedReader(new InputStreamReader(tsocket.getInputStream()));
            
            SocketClient c = new SocketClient();            ;
            //envia a palavra "Olá, sou o cliente" para o servidor
                        
            //descarrega a stream no socket
            imprimeNoSocket.flush();

            //recebe os dados do servidor
            String textoDoServidor = leitor.readLine();

            //fecha o socket
            tsocket.close();            
            
            //imprime o que recebeu do servidor
            System.out.println("Recebido do Servidor: " + textoDoServidor);
                        
        } catch (IOException e) {
            System.out.println("Cliente não conseguiu conectar...");
            e.printStackTrace();
        }
    }
}
    
