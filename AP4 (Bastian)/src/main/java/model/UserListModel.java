/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.UserDao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author t.xiong
 */
public class UserListModel extends AbstractTableModel {
    
    //Attributs
    
    private UserDao userdao = new UserDao();
    //Column name in a String array
    String[] columnNames = {"Id_utilisateur", "Identifiant", "Mot de passe", "role"};
    
    
    
    private ArrayList<User> usersList = new ArrayList<User>();

    public UserListModel() {
        this.usersList = userdao.getAll();
//        this.usersList.add(new User(1,"Xiong","Teddy","t.xiong@gmail.com"));
//        this.usersList.add(new User(2,"Sage","Mateo","m.sage@gmail.com"));
//        this.usersList.add(new User(3,"Ethane","Zimmermann","e.zimmermann@gmail.com"));
    }
    
    public String getColumnName(int column){
        return this.columnNames[column];
    }
    
    public int getRowCount(){
        return this.usersList.size();
    }
    
    public int getColumnCount(){
        return this.columnNames.length;
    }
    
    public void userDelete(int id){
    this.userdao.deleteUser(id);
    this.fireTableDataChanged();
    this.usersList = userdao.getAll();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User i = usersList.get(rowIndex);
        switch (columnIndex) {
            case 0 :
                return i.getId();
            case 1 :
                return i.getIdentifant();
            case 2 :
                return i.getMdp();
            case 3 :
                return i.getRole();
        }
        return null;
    }
}
