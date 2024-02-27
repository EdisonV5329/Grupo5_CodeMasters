/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec               |
| matheus.velasco@epn.edu.ec             |
|----------------------------------------|
|    mateitopro y MATHEUSX               |
|----------------------------------------|
Autor: mateitopro y MATHEUSX   
Fecha: 26.feb.2k24
Clase: Creacion de la clase ACButton
*/

package UserInterface.CustomerControl;

import javax.swing.BorderFactory;
import UserInterface.ACStyle;
import javax.swing.JPanel;
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
        txtContenido.setBorder(txtContenido.createBorderLine());
        add(lblEtiqueta, BorderLayout.WEST); // Añade el label al oeste
        add(txtContenido, BorderLayout.CENTER); // Añade el textbox al centro
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega un borde alrededor del panel
    }
}

