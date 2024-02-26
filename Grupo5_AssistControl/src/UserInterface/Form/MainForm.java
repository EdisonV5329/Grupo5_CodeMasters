/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase MainForm
*/
package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainForm extends JFrame {
    MenuPanel  pnlMenu = new MenuPanel();
    JPanel  pnlMain = new MainPanel();

    public MainForm(String tittleApp){
        customizeComponent(tittleApp);
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new MainPanel())); 
        pnlMenu.btnLogin.addActionListener(     e -> setPanel(new LoginPanel()));
        pnlMenu.btnEmpleado.addActionListener( e -> setPanel(new EmpleadoPanel())); 

        // pnlMenu.btnSexo.addActionListener(      e -> setPanel(new SexoPanel()));  
        // pnlMenu.btnLocalidad.addActionListener( e -> setPanel(new MainPanel())); 
        //agregar
        // pnlMenu.btnTest.addActionListener( e -> { ACStyle.showMsgError("mensaje de error");})
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }   
}
