package DAL;

import BLL.Venda;
import Models.Book;
import Models.Order;
import Models.OrderItens;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class DAOOrder {
    
    private Connection conection = null;   
    
    private void conectar(){
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
    
    //DAOOrder(Order order) throws SQLException{ 
    public void OrdemCompra(Order order)throws SQLException{
        conectar();
        //faz a insercao da ordem de compra 
         String query0 = "INSERT INTO livraria.order (fkiduser, nome) "
                + "VALUES (?,?)";
         PreparedStatement prep0 = conection.prepareStatement(
                            query0,Statement.RETURN_GENERATED_KEYS);    
         prep0.setInt(1, order.getUser().getUsID()); 
         prep0.setString(2, "venda grande");
         prep0.execute();
         
         //pega o id da ordem de compra
         ResultSet idOrdemCompra=prep0.getGeneratedKeys();
         idOrdemCompra.next();
         int idOC = idOrdemCompra.getInt("orid"); 
         
         conection.commit();
            conection.close();
    }
        
        public void lista(OrderItens orderitens) throws SQLException{  
          conectar();
        //varre a lista de livros e prepara a insercao em order_itens
        String query1 = "INSERT INTO livaria.order_itens (fkidorder, fkidproduto, qtde) "
                + "VALUES (?,?,?)";
        PreparedStatement prep1 = conection.prepareStatement(
                             query1,Statement.RETURN_GENERATED_KEYS);
        prep1.setInt(1, orderitens.getFkorID());
        prep1.setInt(2, orderitens.getFkidProduto());
        prep1.setInt(3, orderitens.getQuantidade());
        prep1.execute();
        
        conection.commit();
        conection.close();
        }
        
        public void atualiza(Book book) throws SQLException, SQLException{
            conectar();
        //atualiza a lista de produtos        
        String query2 = "UPDATE livraria.livros " +
                         "SET qtde = ? WHERE id = ?";
               
        PreparedStatement prep2 = conection.prepareStatement(query2);      
        
        prep2.setInt(1, book.getQuantidade());
        prep2.execute();
        
        conection.commit();
            conection.close();
    }
        
        public void consulta(Book book) throws SQLException{
         conectar();
         try {
        //consulta sql do produto
        String queryLivro= "Select * from livraria.livros " +
                         "where id = ?";
               
        PreparedStatement prepLivro = conection.prepareStatement(queryLivro);
        prepLivro.setInt(1, book.getBoID());
        prepLivro.execute();

        conection.commit();
        conection.close();
        
        } catch (SQLException e) {
            e.printStackTrace();        
        }
    }
        
        public void RealizarVenda(Order order) throws SQLException{
            conectar();
            
            String query = "Select * from livraria.order (orID, name, quantidade) " +
                         "VALUES (?, ?, ?)";
            
            try{
                PreparedStatement prep = conection.prepareStatement(query);
                prep.setInt(1, order.getOrID());
                prep.setString(2, order.getName());
                prep.setInt(3, order.getQuantidade());
                prep.execute();                
            }catch(SQLException e){
                Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        public void Produto(Order order)throws SQLException{
        //DAOProduto daoProduto=new DAOProduto();        
        //DAOProduto daoProduto=new DAOProduto();
        for(Book b:order.getBook()){              
        
            String query = "INSERT INTO livraria.orderitens (quantidade) "
                + "VALUES (?)";
            PreparedStatement prepLivro = conection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
           //Produto p=new Produto();
           //p=daoProduto.consultaPorID(b);             
           //faz a consulta no banco pela quantidade do produto
           prepLivro.setInt(1, b.getQuantidade());
           //prepLivro.setInt(1, orderitens.getOiID());
           ResultSet produtoDoBanco = null;
           prepLivro.execute();
           produtoDoBanco.next();
           int qtdeDeLivroNoBanco=produtoDoBanco.getInt("quantidade");
           
            conection.commit();
            conection.close();
             }    
        }              
           
           public void AddProduto(OrderItens orderitens)throws SQLException{
           for(Book b:orderitens.getItem()){
               
           DAOBook p = new DAOBook();
           p=DAOBook.consultaPorID(b);
           
           //faz a consulta no banco pela quantidade do produto
           p.setInt(1, b.getBoID());
           ResultSet produtoDoBanco=p.execute();
           produtoDoBanco.next();
           int qtdeDeLivroNoBanco=produtoDoBanco.getInt("quantidade");
        
           String query = "INSERT INTO livraria.orderitens (oiID,Fkid,quantidade) "
                + "VALUES (?,?,?)";
        PreparedStatement prep1 = conection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
             int idOV = 0;
           //adiciona o produto vinculando no orderitens
           prep1.setInt(1, idOV);
           prep1.setInt(2, b.getBoID());
           prep1.setInt(3, b.getQuantidade());
           //prep1.addBatch();
           prep1.execute();
           prep1.executeBatch();
        }
    }

        /*public void decrementar (Book book) throws SQLException{
            
           //atualiza a tabela de produtos, decrementando o estoque.
           String query = "INSERT INTO livraria.orderitens (oiID,Fkid,quantidade) "
                + "VALUES (?,?,?)";
        PreparedStatement prep2 = conection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
           prep2.setInt(1, qtdDeLivroNoBanco-b.getQuantidade);
           prep2.setInt(2, b.getId());
           prep2.addBatch();
           prep2.executeBatch();
           
        conection.commit();
        conection.close();
        }*/
       
}
        
       
        
        

    
    
    
    
        
     
        

