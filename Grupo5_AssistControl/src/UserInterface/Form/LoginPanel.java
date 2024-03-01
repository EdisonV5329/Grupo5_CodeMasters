/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase LoginPanel 
*/
package UserInterface.Form;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

import UserInterface.CustomerControl.ACButton;
import UserInterface.CustomerControl.ACLabel;
import UserInterface.CustomerControl.ACTextBox;

public class LoginPanel extends JPanel {
    private ACLabel        lblUsername,
                           lblPassword;
    private ACTextBox      txtUsername;
    private JPasswordField txpPassword;
    private ACButton       btnLogin;
    private MainFormAdmin  frmMainAdmin;

    public LoginPanel() {
        initializeComponents();
        btnLogin.addActionListener(e -> btnLoginClick());  //usando expresiones lambda
    }

    private void btnLoginClick() {
    String username = txtUsername.getText();
    char[] password = txpPassword.getPassword();

    // Validación de usuario y contraseña
    if (username.equals("pat") && Arrays.equals(password, "1234".toCharArray())) {
        JOptionPane.showMessageDialog(LoginPanel.this, "Login Exitoso", "Acceso permitido 😊", JOptionPane.INFORMATION_MESSAGE);
        frmMainAdmin = new MainFormAdmin("Admin");
    } else {
        JOptionPane.showMessageDialog(LoginPanel.this, "Error de inicio de sesion", "Acceso denegado 😈", JOptionPane.ERROR_MESSAGE);
    }
    // Limpiar campos después de la validación
    txtUsername.setText("");
    txpPassword.setText("");
    }

    private void initializeComponents() {
        lblUsername = new ACLabel("Username:");
        lblPassword = new ACLabel("Password:");
        // txtUsername = new ACTextBox();
        txtUsername = new ACTextBox();
        txpPassword = new JPasswordField();
        btnLogin    = new ACButton("Login");

        //txtUsername.setBorder(txtUsername.createBorderLine());
        // txtUsername.setBorderLine();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtUsername, gbc);

        // Etiqueta y campo de texto para la contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txpPassword, gbc);

        // Botón de login en la fila 2
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnLogin, gbc);
        
    }   
}
