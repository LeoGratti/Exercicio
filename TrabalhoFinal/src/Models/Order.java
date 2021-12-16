/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Leo
 */
public class Order{
    private int orID;
    private String name; 
    private Order order;
    private int fkusID;
    private int fkiduser;
    //private String user; //alterar para objeto user - set e get
    private User user;        
    private int quantidade;
    private int item;
    
    public int getOrID() {
        return orID;
    }

    public void setOrID(int orID) {
        this.orID = orID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }     

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    
    public int getFkusID() {
        return fkusID;
    }

    public void setFkusID(int fkusID) {
        this.fkusID = fkusID;
    }  
    
    public int getFkiduser() {
        return fkiduser;
    }

    public void setFkiduser(int fkiduser) {
        this.fkiduser = fkiduser;
    } 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }  
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Iterable<Book> getBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    

  

     

    
    
    
}
