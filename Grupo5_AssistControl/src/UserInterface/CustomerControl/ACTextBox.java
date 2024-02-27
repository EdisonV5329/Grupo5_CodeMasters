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

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import UserInterface.ACStyle;

public class ACTextBox extends JTextField {

    public ACTextBox(){
        customizeComponent();
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(createBorderRect(ACStyle.COLOR_FONT_LIGHT)); // Cambia el color del borde cuando el TextBox tiene el foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(createBorderRect(ACStyle.COLOR_BORDER)); // Cambia el color del borde cuando el TextBox pierde el foco
            }
        });
    }
    
    private void customizeComponent(){
        setFont(ACStyle.FONT_BOLD); // Cambia la fuente a una más atractiva
        setForeground(ACStyle.COLOR_FONT);
        setBorder(createBorderRect(ACStyle.COLOR_BORDER));
        setCaretColor(ACStyle.COLOR_CURSOR);
        setMargin(new Insets(2, 5, 2, 5));
        setOpaque(false);
    }

    private Border createBorderRect(Color color) {
        Border lineBorder = BorderFactory.createLineBorder(color);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        return new CompoundBorder(lineBorder, emptyBorder);
    }

    public Border createBorderLine(){
        int size = 1;
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 0, size, 0),
            BorderFactory.createMatteBorder(0, 0, size,0, ACStyle.COLOR_BORDER)
        );
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, ACStyle.COLOR_BORDER) 
        ));
    }
}