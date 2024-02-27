/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase ACLabelText
*/
package UserInterface.CustomerControl;

import javax.swing.*;

import UserInterface.ACStyle;

import java.awt.*;

public class ACLabelText extends JPanel{
    private ACLabel    lblEtiqueta = new ACLabel();
    private ACTextBox  txtContenido= new ACTextBox();

    public ACLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            ACStyle.FONT_SMALL, 
                                            ACStyle.COLOR_FONT_LIGHT, 
                                            ACStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
