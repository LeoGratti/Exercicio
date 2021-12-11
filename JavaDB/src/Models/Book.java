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
public class Book {
    private int boID;
    private String title;
    private Author author;
    public String mail;
    private Publisher publisher;
    private int fkpuID;
    private int fkauID;
    private int numPags;
    private int quantidade;   
    
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }  
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public int getBoID() {
        return boID;
    }

    public void setBoID(int boID) {
        this.boID = boID;
    }

    public int getFkpuID() {
        return fkpuID;
    }

    public void setFkpuID(int fkpuID) {
        this.fkpuID = fkpuID;
    }

    public int getFkauID() {
        return fkauID;
    }

    public void setFkauID(int fkauID) {
        this.fkauID = fkauID;
    }

    public int getNumPags() {
        return numPags;
    }

    public void setNumPags(int numPags) {
        this.numPags = numPags;
    }

    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }         
}
