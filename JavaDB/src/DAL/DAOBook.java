package DAL;

import Models.Author;
import Models.Book;
import static java.awt.Event.INSERT;
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

    static DAOBook consultaPorID(Book b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Connection conection = null;
    
    public void conectar() {
        Properties prop = new Properties();
        prop.setProperty("user", "root");
        prop.setProperty("password", "123");
        try {
            conection = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306", prop);
            conection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //incluir
    public void incluir(Book book) throws SQLException {
        conectar();

        String query = "INSERT INTO livraria.livros (titulo, autor, email, numPags, quantidade) "
                + "VALUES (?,?,?,?,?)";
        PreparedStatement prep = conection.prepareStatement(
                query,
                Statement.RETURN_GENERATED_KEYS);
        prep.setString(1, book.getTitle());
        prep.setString(2, book.getAuthor().getName());
        prep.setString(3, book.getMail());
        prep.setInt(4, book.getNumPags());
        prep.setInt(5, book.getQuantidade());
        prep.execute();
        
        ResultSet idOrdemCompra=prep.getGeneratedKeys();
        idOrdemCompra.next();
        System.out.println("Valor gerado: "+idOrdemCompra.getInt(1));
        
        conection.commit();
        conection.close();
    }

    //alterar - a model deve estar com o id preenchido
    public void alterar(Book book) throws SQLException {
        conectar();
        try {
            String query = "UPDATE livraria.livros "
                    + "SET titulo=?, autor=?, email=?, numPags = ?, quantidade=?, WHERE id=?";
            //PreparedStatement prep = cdb.getconection.prepareStatement(query);
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setInt(6, book.getBoID());
            prep.setString(1, book.getTitle());
            prep.setString(2, book.getAuthor().getName());
            prep.setString(3, book.getMail());
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
        conectar();
        try {
            String query = "DELETE FROM livraria.livros "
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
        String query = "SELECT * from livraria.livros "
                + "WHERE titulo = ?";
        try {
            PreparedStatement prep = conection.prepareStatement(query);
            prep.setString(1, book.getTitle());

            ResultSet list = prep.executeQuery();

            while (list.next()) {
                idTmp = list.getInt("id");
                String tmpTitle = list.getString("name");
                book.setBoID(list.getInt("id"));
                book.setTitle(list.getString("titulo"));
                book.setTitle(list.getString("autor"));
                book.setTitle(list.getString("email"));
                book.setTitle(list.getString("publisher"));
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
        book.setBoID(idTmp);
        return idTmp;
    }

    public List listar(String params) {
        conectar();
        List<Book> listaLivros = new ArrayList<>();
        String query = "SELECT * from livraria.livros " + params;

        try {
            PreparedStatement prep = conection.prepareStatement(query);
            ResultSet lista = prep.executeQuery();

            while (lista.next()) {
                Book book = new Book();
                book.setBoID(lista.getInt("id"));
                book.setTitle(lista.getString("titulo"));
                Author author = new Author();
                author.setName(lista.getString("autor"));
                book.setAuthor(author);
                book.setMail(lista.getString("email"));
                book.setNumPags(lista.getInt("numPags"));
                book.setQuantidade(lista.getInt("quantidade"));
                book.setTitle(lista.getString("publisher"));
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
        return listaLivros;
    }   

    void setInt(int i, int boID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ResultSet execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
