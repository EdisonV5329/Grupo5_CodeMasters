package UserInterface.Form;

import java.awt.*;
import javax.swing.*;

import UserInterface.CustomeControls.Label;
import UserInterface.CustomeControls.TextBox;

public class LoginPanel extends JPanel {
    private Label        lblUsername,
                        lblPassword;
    private TextBox      txtUsername;
    private JPasswordField  txpPassword;
    private JButton         btnLogin;
   

    public LoginPanel() {
        initializeComponents();
        btnLogin.addActionListener(e -> btnLoginClick());  //usando expresiones lambda
       
    }
    private void btnLoginClick() {
        String username = txtUsername.getText();
        char[] password = txpPassword.getPassword();

        JOptionPane.showMessageDialog(LoginPanel.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);

        txtUsername.setText("");
        txpPassword.setText("");
    }

    private void initializeComponents() {
        lblUsername = new Label("Username:");
        lblPassword = new Label("Password:");
        txtUsername = new TextBox();
        txpPassword = new JPasswordField();
        btnLogin    = new JButton("Login");
       

        txtUsername.setBorder(txtUsername.createBorderLine());
       

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