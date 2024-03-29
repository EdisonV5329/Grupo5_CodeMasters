/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase MenuPanel 
*/
package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.ACStyle;
import UserInterface.CustomerControl.ACButton;

public class MenuPanel extends JPanel{
    public  ACButton   
            btnHome     = new ACButton("Home"),
            btnLogin    = new ACButton("Admin"),
            btnEmpleado = new ACButton("Empleado");
            // btnSexo     = new ACButton("Sexo"),
            // btnLocalidad= new ACButton("Localidad"),
            // btnTest     = new ACButton("btnTest");

    public MenuPanel(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight())); 

        // add-logo
        try {
            Image logo = ImageIO.read(ACStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add-botones
        add(btnHome);
        add(btnLogin);
        add(btnEmpleado);
        // add(btnSexo);
        // add(btnLocalidad);
        // add(btnTest);

        // add-copyright
        add(new JLabel("\u00A9 2024 CodeMasters"));
    }
}
