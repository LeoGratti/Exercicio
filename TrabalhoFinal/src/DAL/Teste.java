package DAL;

import Models.Book;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Leo
 */
public class Teste {
    public static void main(String[] args) throws SQLException{
        Book b1=new Book();
        b1.setName("Castelo Rá-Tim-Bum");
        //b1.setAuthor("Nino");
        
        try{
        DAOBook db=new DAOBook();
        db.incluir(b1);
        
        List<Book> books=db.listar("");      
                       
        for(Book b:books){
            System.out.println(b.getBoID());
            System.out.println(b.getName());
        }
        
        Book b2=new Book();
        b2.setTitle("Castelo Rá-Tim-Bum");
        int id=db.consultarLivro(b2);
        db.excluir(b2);            
        
        for(Book b:books){
            System.out.println(b.getBoID());
            System.out.println(b.getName());
        }               
        
        for(Book b:books){
            System.out.println(b.getBoID());
            System.out.println(b.getName());
        }        
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
