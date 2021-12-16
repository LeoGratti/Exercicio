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
public class Review {
    private String text;
    private Reviewer reviewer;

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }  
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }   
}

