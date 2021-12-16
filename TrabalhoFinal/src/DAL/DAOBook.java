package DAL;

import Models.Author;
import Models.Book;
//import static java.awt.Event.INSERT;
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
public class DAOBook {      
  
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
    public void incluir(Book book) throws SQLException {        

        String query = "INSERT INTO livraria.book (boId, name, numPags, quantidade) "
                + "VALUES (?,?,?,?)";
        PreparedStatement prep = conection.prepareStatement(
                query,
                Statement.RETURN_GENERATED_KEYS);
        prep.setInt(1, book.getBoID());
        prep.setString(2,book.getName());        
        prep.setInt(3,book.getNumPags());
        prep.setInt(4,book.getQuantidade());
        prep.execute();
        
        ResultSet idOrdemCompra=prep.getGeneratedKeys();
        idOrdemCompra.next();
        System.out.println("Valor gerado: "+idOrdemCompra.getInt(1));
        
        conection.commit();
        conection.close();
    }

    //alterar - a model deve estar com o id preenchido
    public void alterar(Book book) throws SQLException {
        
        try {
            String query = "UPDATE livraria.book "
                    + "SET name=?, numPags = ?, quantidade=?, WHERE id=?";
            //PreparedStatement prep = cdb.getconection.prepareStatement(query);
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setInt(6, book.getBoID());            
            prep.setString(2, book.getName());            
            prep.setInt(4, book.getNumPags());
            prep.setInt(5, book.getQuantidade());
            
            prep.execute();

            conection.commit();
            conection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //excluir
    public void excluir(Book book) {
        
        try {
            String query = "DELETE FROM livraria.book "
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
    public int consultarLivro(Book book) {
        
        int idTmp = -1;
        String query = "SELECT * from livraria.book "
                + "WHERE titulo = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setString(1, book.getTitle());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("id");
                String tmpTitulo = list.getString("titulo");
                book.setBoID(idTmp);                             
                               
                break;
            }            
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        book.setBoID(idTmp);
        return idTmp;
    }

    public List listar(String params) {
        
        List<Book> listaLivros = new ArrayList<>();
        String query = "SELECT * from livraria.books " + params;

        try {
            PreparedStatement prep = conection.prepareStatement(query);
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                Book book = new Book();
                book.setBoID(lista.getInt("id"));
                book.setTitle(lista.getString("titulo"));  
                book.setName(lista.getString("name"));
                book.setNumPags(lista.getInt("numPags"));
                book.setQuantidade(lista.getInt("quantidade"));                
                
                
                //listaLivros.add(book);
                /*book.setAuthor(lista.getString("autor"));
                book.setEmail(lista.getString("email"));
                listaLivros.add(book);*/
            }            
            conection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaLivros;
    }    
}
