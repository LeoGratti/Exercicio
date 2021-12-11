/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Author;
import Models.Book;
import Models.Publisher;
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
public class DAOPublisher {

    private Connection conection = null;

    public void conectar() {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "123");
        try {
             
           Class.forName("oracle.jdbc.driver.OracleDriver");  
  

         /* conection=DriverManager.getConnection(  
               "jdbc:oracle:thin:@127.0.0.1:1521:xe",prop);
*/
        conection = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3308", prop);
            conection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //incluir -o objeto book não tem id.

    public void incluir(Publisher publisher) throws SQLException {
        conectar();

        String query = "INSERT INTO livraria.publisher (title, author, email) "
                + "VALUES (?,?,?)";
        PreparedStatement prep = conection.prepareStatement(
                query,
                Statement.RETURN_GENERATED_KEYS);
        prep.setString(1, publisher.getTitle());
        prep.setString(2, publisher.getAuthor().getName());
        prep.setString(3, publisher.getMail());
        prep.execute();
        
        //pega a ultima id gerada
        ResultSet ultimaID=prep.getGeneratedKeys();
        ultimaID.next();
        System.out.println("Valor gerado:"+ultimaID.getInt(1));
        
        
        //query="SELECT LAST_INSERT_ID()";
        conection.commit();

        conection.close();
    }

    //alterar - a model deve estar com o id preenchido
    public void alterar(Book book) throws SQLException {
        conectar();
        try {
            String query = "UPDATE livaria.books "
                    + "SET title=?, author=?, email=? WHERE id=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(4, book.getBoID());
            prep.setString(1, book.getTitle());
            prep.setString(2, book.getAuthor().getName());            
            prep.setString(3, book.getMail());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //excluir --o objeto book precisa do id....
    public void excluir(Book book) {
        conectar();
        try {
            String query = "DELETE FROM livraria.books "
                    + "WHERE id=?";
            PreparedStatement prep = conection.prepareStatement(query);

            prep.setInt(1, book.getBoID());
            prep.execute();

            conection.commit();
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //consultar
    public int consultarPorTitulo(Book book) {
        conectar();
        
        int idTmp = -1;
        String tmpTitle="";
        
        
        String query = "SELECT * from livraria.books "
                + "WHERE title = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setString(1, book.getTitle());

            ResultSet list = prep.executeQuery();

            
            while (list.next()) {
                idTmp = list.getInt("id");
                tmpTitle=list.getString("name");
                break;
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        book.setBoID(idTmp);
        book.setTitle(tmpTitle);
        //... 
        //preencher o objeto inteiro.
        
        return idTmp;
    }

    public List listar(String params) {
        conectar();
        List<Book> listaLivros = new ArrayList<>();
        String query = "SELECT * from livraria.books " + params;

        try {
            PreparedStatement prep = conection.prepareStatement(query);
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                Book book = new Book();
                book.setBoID(lista.getInt("id"));
                book.setTitle(lista.getString("title"));
                Author author = new Author();
                author.setName(lista.getString("autor"));
                book.setAuthor(author);
                book.setNumPags(lista.getInt("numPags"));
                book.setQuantidade(lista.getInt("quantidade"));
                //book.setEmail(lista.getString("email"));
                listaLivros.add(book);
            }
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaLivros;
    }

}
