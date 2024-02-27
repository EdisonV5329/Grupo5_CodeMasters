/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase SplashScreenForm
*/
package UserInterface.Form;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import UserInterface.ACStyle;

public abstract class SplashScreenForm {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoaging;
    private static ImageIcon    icoImagen ;
    private static JLabel       lblSplash ;

    public static void show () {
        icoImagen  = new ImageIcon(ACStyle.URL_SPLASH);        
        lblSplash  = new JLabel(icoImagen);
        prbLoaging = new JProgressBar(0, 100);

        prbLoaging.setStringPainted(true);
        
        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        // frmSplash.add(prbLoaging, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
        frmSplash.setSize(650, 650);
        frmSplash.setLocationRelativeTo(null); // Centrar en la pantalla
       
        frmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // prbLoaging.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}
