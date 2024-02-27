package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CustomeControls.*;


public class MenuPanel extends JPanel{
    public  Button   
            btnHome         = new Button("Home"),
            btnLogin        = new Button("Login"),
            btnSexo         = new Button("Sexo"),
            btnPersonaRol   = new Button("PersonaRol"),
            btnRegaloTipo   = new Button("RegaloTipo"),
            btnLocalidad    = new Button("Localidad"),
            btnTest         = new Button("btnTest");
    public Object btnEmpleado;

    public MenuPanel(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight())); 

        // add-logo
        try {
            Image logo = ImageIO.read(Style.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add-botones
        add(btnHome);
        add(btnLogin);
        add(btnSexo);
        add(btnPersonaRol);
        add(btnRegaloTipo);
        add(btnLocalidad);
        add(btnTest);
        
        // add-copyright
    }
    
}

