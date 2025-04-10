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
    private String mdp;
    private String role;

    public User(int id, String identifant, String mdp, String role) {
        this.id = id;
        this.identifant = identifant;
        this.mdp = mdp;
        this.role = role;
    }
    
    public User(String identifant, String mdp, String role) {
        this.identifant = identifant;
        this.mdp = mdp;
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
    public String getIdentifant() {
        return identifant;
    }
    public void setIdentifant(String identifant) {
        this.identifant = identifant;
    }

    
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    
}
