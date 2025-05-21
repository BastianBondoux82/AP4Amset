/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author t.xiong
 */
public class User {
    
    private int id;
    private String identifant;
    private String prenom;
    private String email;
    private String motDePasse;

    public User(int id, String identifant, String prenom, String email, String motDePasse) {
        this.id = id;
        this.identifant = identifant;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }
    
    public User(String identifant, String prenom, String email, String motDePasse) {
        this.identifant = identifant;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }
    
    public User(){};

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
    public String getIdentifant() {
        return this.identifant;
    }
    public void setIdentifant(String identifant) {
        this.identifant = identifant;
    }

    
    public String getPrenom() {
        return this.prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    
    public String getMotDePasse(){
        return this.motDePasse;
    }
    public void setMotDepasse(String motDePasse){
        this.motDePasse = motDePasse;
    }
    
    
}
