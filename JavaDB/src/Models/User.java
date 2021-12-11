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
public class User extends Order{
    private int usID;
    private String name;
    

    public int getUsID() {
        return usID;
    }

    public void setUsID(int usID) {
        this.usID = usID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
