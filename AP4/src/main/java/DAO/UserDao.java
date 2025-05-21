/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MySQLConnection;
import model.User;

/**
 *
 * @author t.xiong
 */
public class UserDao {

    private final Connection connexion;

    public UserDao() {
        this.connexion = MySQLConnection.getConnexion();
    }

    /**
     * Methode qui retourne une liste de 'User' Récupère tout les données de la
     * table 'utilisateur'
     */
    public ArrayList<User> getAll() {
        try {
            String query = "SELECT * FROM utilisateur;";

            PreparedStatement ps = this.connexion.prepareStatement(query);
            ResultSet res = ps.executeQuery();

            ArrayList<User> userList = new ArrayList<User>();

            while (res.next()) {
                int id = res.getInt("ID_Utilisateur");
                String identifant = res.getString("IDENTIFIANT");
                String prenom = res.getString("PRENOM");
                String email = res.getString("EMAIL");
                String motDePasse = res.getString("MOT_DE_PASSE");

                userList.add(new User(id, identifant, prenom, email, motDePasse));
            }

            return userList;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public User insertUser(User user) {
        try {
            String query = "insert into utilisateur(ID_UTILISATEUR, IDENTIFIANT, PRENOM, EMAIL, MOT_DE_PASSE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, null);
            ps.setString(2, user.getIdentifant());
            ps.setString(3, user.getPrenom());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getMotDePasse());
            int n = ps.executeUpdate();
            // n contient l'id généré lors de l'insertion en base
            // ici on le récupère car c'est un insert (inutile dans le cas d'un update ou d'un delete)
            user.setId(n);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public User updateUser(User user) {
        try {
            String query = "UPDATE utilisateur SET IDENTIFIANT = ?, PRENOM = ?, EMAIL = ?, MOT_DE_PASSE = ? WHERE ID_UTILISATEUR = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setString(1, user.getIdentifant());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getMotDePasse());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
    public void deleteUser(int id){
        try {
            String query = "DELETE FROM utilisateur WHERE ID_UTILISATEUR = ?";
            PreparedStatement ps = this.connexion.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException ex){
        Logger.getLogger(
                UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
