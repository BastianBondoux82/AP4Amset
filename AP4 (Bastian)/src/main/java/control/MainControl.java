/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import view.MainView;
import model.UserListModel;
import view.CreateUserDialog;
import view.DeleteUserDialog;
import view.UpdateUserDialog;

/**
 *
 * @author t.xiong
 */
public class MainControl implements PropertyChangeListener{
    
    /**
     * attributs 
     */
    private MainView view = new MainView();
    private UserListModel userListModel;
    
    private CreateUserDialog createUserDialog;
    private UpdateUserDialog updateUserDialog;
    private DeleteUserDialog deleteUserDialog;
    
    

    /**
     * Methodes
     * 
     */
    public MainControl(MainView v)  {
        this.userListModel = new UserListModel();
        
        this.view = v;
        this.view.addPropertyChangeListener(this);
        this.view.setTableModel(userListModel);
        
        this.createUserDialog = new CreateUserDialog(this.view, true);
        this.createUserDialog.addPropertyChangeListener(this);
        
        this.updateUserDialog = new UpdateUserDialog(this.view, true);
        this.updateUserDialog.addPropertyChangeListener(this);
        
        this.deleteUserDialog = new DeleteUserDialog(this.view, true);
        this.deleteUserDialog.addPropertyChangeListener(this);
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "btnClick":
                JOptionPane.showMessageDialog(this.view, this.view.message("clic utilisateur !"));
                break;  
            case "validSuppUser":
                int supp = this.view.getSelectedId();
                userListModel.userDelete(supp);
                
                break;
        }
    }
    
}
