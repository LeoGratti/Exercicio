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
public class Author {
    private String name;
    private int auID;

    public int getAuID() {
        return auID;
    }

    public void setAuID(int auID) {
        this.auID = auID;
    }  
    
    public String getName() {        
        return name;
    }
    
    public void setName(String name) {
        if(name != null){
            this.name = name;
        }else{
           this.name = "Autor desconhecido"; 
        }
        
    }  
        
}
