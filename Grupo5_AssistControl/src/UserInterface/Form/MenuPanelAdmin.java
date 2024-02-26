package UserInterface.Form;

import java.io.IOException;

import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.ACStyle;
import UserInterface.CustomerControl.ACButton;

public class MenuPanelAdmin extends JPanel {
    public  ACButton   
            btnHome     = new ACButton("Home admin"),
            btnCargo     = new ACButton("Cargos"),
            btnLEmpleado    = new ACButton("Empleados"),
            btnRegistroAsistencia = new ACButton("Registro asistencias");
            // btnSexo     = new ACButton("Sexo"),
            // btnLocalidad= new ACButton("Localidad"),
            // btnTest     = new ACButton("btnTest");

    public MenuPanelAdmin(){
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
        add(btnCargo);
        add(btnLEmpleado);
        add(btnRegistroAsistencia);
        // add(btnSexo);
        // add(btnLocalidad);
        // add(btnTest);

        // add-copyright
        add(new JLabel("\u00A9 2024 CodeMasters"));
    }    
}
