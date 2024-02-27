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

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import UserInterface.ACStyle;
import javax.swing.border.Border;

public class ACLabel extends JLabel {
    public ACLabel(){
        customizeComponent();
    }
    public ACLabel(String text){
        super(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), ACStyle.FONT_ITALIC, ACStyle.COLOR_FONT_LIGHT, ACStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
        setBorder(createShadowBorder());
    }

    private Border createShadowBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ACStyle.COLOR_BORDER, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
    }
}
