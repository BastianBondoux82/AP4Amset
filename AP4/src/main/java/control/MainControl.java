/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DAO.UserDao;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import model.User;
import view.MainView;
import model.UserListModel;
import view.CreateUserDialog;
import view.DeleteUserDialog;
import view.UpdateUserDialog;

/**
 *
 * @author t.xiong
 */
public class MainControl implements PropertyChangeListener {

    /**
     * attributs
     */
    private MainView view = new MainView();
    private UserListModel userListModel;

    private CreateUserDialog createUserDialog;
    private UpdateUserDialog updateUserDialog;
    private DeleteUserDialog deleteUserDialog;

    private UserDao userdao = new UserDao();

    public MainControl(MainView v) {
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
        switch (evt.getPropertyName()) {
            case "OpenDialogAjoutUser":
                this.createUserDialog.setDefaultData();
                this.createUserDialog.setVisible(true);
                break;

            case "ValideAjoutUser":
                switch (this.createUserDialog.verifForm()) {
                    case 1:
                        this.createUserDialog.erreurChamps();
                        break;
                    case 2:
                        this.createUserDialog.erreurMDP();
                        break;
                    case 3:
                        this.userListModel.addUserList(
                                this.createUserDialog.getIdentifiantUser(),
                                this.createUserDialog.getPrenomUser(),
                                this.createUserDialog.getEmailUser(),
                                this.createUserDialog.getMotDePasseUser());
                        this.createUserDialog.setVisible(false);
                        break;
                }
                break;

            case "OpenDialogModifUser":
                this.updateUserDialog.setIdUser(view.getSelectedId());
                this.updateUserDialog.setIdentifiantUser(view.getSelectedIdentifant());
                this.updateUserDialog.setPrenomUser(view.getSelectedPrenom());
                this.updateUserDialog.setEmailUser(view.getSelectedEmail());
                this.updateUserDialog.setMotDePasseUser(view.getSelectedMotDePasse());

                this.updateUserDialog.setDefaultData();

                this.updateUserDialog.setVisible(true);
                break;

            case "ValideModifUser":
                switch (this.updateUserDialog.verifForm()) {
                    case 1 :
                        this.updateUserDialog.erreurChamps();
                        break;
                    case 2 :
                        this.updateUserDialog.erreurMDP();
                        break;
                    case 3 :
                        this.userListModel.updateUser(
                                this.updateUserDialog.getIdUser(),
                                this.updateUserDialog.getIdentifiantUser(),
                                this.updateUserDialog.getPrenomUser(),
                                this.updateUserDialog.getEmailUser(),
                                this.updateUserDialog.getMotDePasseUser());
                        this.updateUserDialog.setVisible(false);
                        break;
                }
                break;

            case "validSuppUser":
                this.userListModel.userDelete(this.view.getSelectedId());
                break;
        }
    }

}
