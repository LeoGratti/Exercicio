package BLL;

import DAL.DAOBook;
import DAL.DAOOrder;
import Models.Order;
import Models.Book;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Venda {
    public void RealizarVenda (Order order, int quantidade) throws Exception{
        DAOBook Ebook = new DAOBook();
        DAOOrder Eorder = new DAOOrder();        
     
        try{
            if(order.getItem().getQuantidade()>0){
        
            //try{
                if(order.checkAvailability(order.getItem(), quantidade)==false) return;
                order.getItem().setQuantidade(order.getItem().getQuantidade());              
                Eorder.RealizarVenda(order);                
                System.out.println("Venda");        }
        
            } catch (Exception e) {
                Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
    
