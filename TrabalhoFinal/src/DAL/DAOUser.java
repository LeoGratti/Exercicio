/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.User;
import Models.Author;
import Models.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Leo
 */
public class DAOUser {
    private Connection conection;
    
    public static void main(String[] args) throws SQLException {       
          
    //public void conectar() {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "123");
        try {           
            Connection conection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306", prop);
            conection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }            

    //incluir
    public void incluir(User user) throws SQLException {        

        String query = "INSERT INTO livraria.user (name) "
                + "VALUES (?)";
        PreparedStatement prep = conection.prepareStatement(
                query,
                Statement.RETURN_GENERATED_KEYS);
        prep.setString(1, user.getName());
     
        prep.execute();
        
        /*ResultSet idOrdemCompra=prep.getGeneratedKeys();
        idOrdemCompra.next();
        System.out.println("Valor gerado: "+idOrdemCompra.getInt(1));*/
        
        conection.commit();
        conection.close();
    }

    //alterar - a model deve estar com o id preenchido
    public void alterar(User user) throws SQLException {
        
        try {
            String query = "UPDATE livraria.user "
                    + "SET name=? WHERE id=?";
            //PreparedStatement prep = cdb.getconection.prepareStatement(query);
            PreparedStatement prep = conection.prepareStatement(query);
            
            prep.setString(1, user.getName());                 
            
            prep.execute();

            conection.commit();
            conection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //excluir
    public void excluir(User user) {
        
        try {
            String query = "DELETE FROM livraria.user "
                    + "WHERE id=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(1, user.getUsID());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //consultar
    public int consultarPorUsuario(User user) {
        
        int idTmp = -1;
        String query = "SELECT * from livraria.user "
                + "WHERE usuario = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setString(1, user.getName());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("id");
                String tmpUsuario = list.getString("name");
                user.setUsID(idTmp);
                user.setUser(user);
                
                /*Author author = new Author();
                author.setName(list.getString("autor"));
                book.setAutor(author);
                Publisher publisher = new Publisher();
                publisher.setName(list.getString("publisher"));
                book.setPublisher(publisher);*/
                break;
            }            
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setUsID(idTmp);
        return idTmp;
    }

    public List listar(String params) {
        
        List<User> listaUsuarios = new ArrayList<>();
        //String query = "SELECT * from livraria.user " + params;
        String query = "SELECT name from user " + params;
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                User user  = new User();
                user.setUsID(lista.getInt("id"));
                user.setName(lista.getString("name"));
                
                //Author autor = new Author();
                //autor.setName(lista.getString("autor"));
                //book.setAuthor(autor);
                //Publisher publisher = new Publisher();
                //publisher.setName(list.getString("publisher"));
                //book.setPublisher(publisher);
                
                //listaLivros.add(book);
                /*book.setAuthor(lista.getString("autor"));
                book.setEmail(lista.getString("email"));
                listaLivros.add(book);*/
            }            
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }             
        return listaUsuarios;
    }       
}
