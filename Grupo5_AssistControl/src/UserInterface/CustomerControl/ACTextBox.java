/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase ACTextBox
*/
package UserInterface.CustomerControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import UserInterface.ACStyle;

public class ACTextBox extends JTextField {
    public ACTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(ACStyle.FONT);  
        setForeground(ACStyle.COLOR_FONT_LIGHT);  
        setCaretColor(ACStyle.COLOR_CURSOR);    // Color del cursor
        setMargin(new Insets(5, 5, 5, 5));      // Ajusta los márgenes
        setOpaque(false);                       // Fondo transparente
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(ACStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, ACStyle.COLOR_BORDER) 
        ));
    }
}
