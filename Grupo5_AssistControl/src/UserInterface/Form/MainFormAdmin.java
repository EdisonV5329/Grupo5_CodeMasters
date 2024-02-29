/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase MainFormAdmin 
*/
package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFormAdmin extends JFrame {
    MenuPanelAdmin  pnlMenu = new MenuPanelAdmin();
    JPanel  pnlMain         = new MainPanel();

    public MainFormAdmin(String tittleApp){
        customizeComponent(tittleApp);
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new MainPanel())); 
        pnlMenu.btnCargo.addActionListener(     e -> setPanel(new CargoPanel()));
        pnlMenu.btnEmpleado.addActionListener(e -> setPanel(new EmpleadoPanel()));
        pnlMenu.btnRegistroAsistencia.addActionListener( e -> setPanel(new RegistroHorarioPanel())); 
        pnlMenu.btnMainHome.addActionListener(e -> SwingUtilities.getWindowAncestor((Component)e.getSource()).dispose());
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
