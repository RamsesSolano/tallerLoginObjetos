package controllers;

import javax.swing.JOptionPane;

import models.User;
import models.UserConnection;
import models.UserDAO;
import views.frmlogin;
import views.frmregistro;

public class LoginController {
    private frmlogin view;
    private UserConnection userConnection;

    public LoginController(frmlogin view) {
        this.userConnection = new UserConnection();
        this.view = view;
        this.initController();
    }

    private void initController() {
        this.view.getLoginButton().addActionListener(e -> validateLogin());
        this.view.getRegisterButton().addActionListener(e -> registerUser());
    }

    private void validateLogin() {
        String username = this.view.getEmailField().getText();
        String password = this.view.getPasswordField().getText();

        UserDAO userInformation = this.userConnection.getUserByEmail(username);
        User user = new User(userInformation.getEmail(), userInformation.getPassword());
        System.out.println("Validando usuario: " + username + " con contraseña: " + password);
        if (user.authenticate(password, username)) {
            JOptionPane.showMessageDialog(
                    null,
                    userInformation.getName() + userInformation.getLastName(),
                    "Bienvenido",
                    JOptionPane.INFORMATION_MESSAGE);
            this.view.dispose();
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Datos de ingreso incorrectos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void registerUser() {
        this.view.dispose();
        frmregistro registerView = new frmregistro();
        RegisterController registerController = new RegisterController(registerView);
        registerView.setVisible(true);
        System.out.println("Abriendo formulario de registro");
        System.out.println(registerController);
    }

}
