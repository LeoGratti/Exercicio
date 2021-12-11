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
public class Order extends Book{
    private int orID;
    private String name;
    public String Item;
    private int fkusID;
    private int fkiduser;
    //private String user; //alterar para objeto user - set e get
    private User user;    
    private int quantidade;
    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }  
    
    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }
    
   /* private String Books;

    public String getBooks() {
        return Books;
    }

    public void setBooks(String Books) {
        this.Books = Books;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
      

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

    public int getFkiduser() {
        return fkiduser;
    }

    public void setFkiduser(int fkiduser) {
        this.fkiduser = fkiduser;
    }

    public int getOrID() {
        return orID;
    }

    public void setOrID(int orID) {
        this.orID = orID;
    }

    public int getFkusID() {
        return fkusID;
    }

    public void setFkusID(int fkusID) {
        this.fkusID = fkusID;
    }   

    public boolean checkAvailability(String item, int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<Book> getBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
