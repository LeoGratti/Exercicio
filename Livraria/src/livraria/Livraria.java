package livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Livraria {

    public static void main(String[] args) throws SQLException { 
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "123");
        try (
            Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306", prop)){
            conn.setAutoCommit(false);
            
            try(Statement stmt = conn.createStatement()){
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.livros (" +
                          "id INT PRIMARY KEY AUTO_INCREMENT," +
                          "titulo VARCHAR(25)," +
                          "autor VARCHAR(25)," +
                          "email VARCHAR(100))" +
                       "ENGINE=InnoDB;");
            }
        }
    
    /*
        Criar um livro.
        Criar um autor, e vincular ao livro
        Criar um publicador, e vincular ao livro
        Criar um usuário(Editorial/Consumidor), e vincular a ordem de compra
        Criar um Entregador.
        Criar InformacoesDeEntrega e vincular o entregador.
        Criar uma conta
        Criar um classe de Informacoes de compra e vincular a Conta
        Vincular tudo acima.
        temos um objeto de venda.
        Criar uma ordem de compra
        */
        //Criar livro
        Book PoderExtrafísico = new Book();        
        
        //Autor
        Author Bruno = new Author();
        PoderExtrafísico.setAuthor(Bruno);
        
        //Publicador
        Publisher PlanetaBrasil = new Publisher();
        PoderExtrafísico.setPublisher(PlanetaBrasil);
        
        //Usuario
        User Leonardo = new User();        
        
        //Criar entregador
        //Criar informações de entrega
        Shipper entregador = new Shipper();
        ShippingInfo entrega = new ShippingInfo();
        entrega.setShipper(entregador);      
                
        //Criar conta
        Account conta = new Account();
        Leonardo.setAccount(conta);
        
        //Criar um classe de informações e vincular a conta
        conta.setEmailAddress("leo@gmail.com");
        conta.setId(1);
        conta.setPassword("111");
        
        BillingInfo Compra = new BillingInfo();
        Compra.setAccount(conta);
        Compra.getText();

        Order compra = new Order();        
        compra.setBook(PoderExtrafísico);
        compra.setShippingInfo(entrega);
        compra.setBillingInfo(Compra);
        compra.setUser(Leonardo);        
        
        if(compra.isFullfilled())
        {
            Scanner scannerId;
            int id = 0;
            String password = "";
            try {
                scannerId = new Scanner(System.in);
                System.out.println("ID");
                id = scannerId.nextInt();
                System.out.println("Senha");
                password = scannerId.next();
            } catch (Exception e) {
                System.out.println("Erro");                
            }
            
            if(compra.getBillingInfo().getAccount().validateLogin(id, password))
            {
                System.out.println("Compra aprovado");
            }
        }
    }  
}
