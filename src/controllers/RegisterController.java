package controllers;

import javax.swing.JOptionPane;

import models.User;
import models.UserConnection;
import models.UserDAO;
import views.frmlogin;
import views.frmregistro;

public class RegisterController {
    private frmregistro view;
    private UserConnection userConnection;

    public RegisterController(frmregistro view) {
        this.view = view;
        this.userConnection = new UserConnection();
        this.initController();
    }

    private void initController() {
        this.view.getUserTypeComboBox().addItem("Admin");
        this.view.getUserTypeComboBox().addItem("User");
        this.view.getSubmitButton().addActionListener(e -> submitRegistration());
    }

    private void submitRegistration() {
        String name = this.view.getNameField().getText();
        String lastName = this.view.getLastNameField().getText();
        String email = this.view.getEmailField().getText();
        String password = this.view.getPasswordField().getText();
        String userType = (String) this.view.getUserTypeComboBox().getSelectedItem();
        UserDAO newUser = new UserDAO();

        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setPassword(password);
        newUser.setTypeLevel(userType);
        newUser.setEmail(email);

        UserDAO userRegisted = this.userConnection.addUser(newUser);

        if (userRegisted == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ha ocurrido un error. No se pudo Guardar",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Operación realizada correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            
            this.view.dispose();
            frmlogin loginView = new frmlogin();
            LoginController loginController = new LoginController(loginView);
            loginView.setVisible(true);
        }
    }
}
