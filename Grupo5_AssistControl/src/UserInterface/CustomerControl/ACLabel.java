/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase ACLabel
*/
package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import UserInterface.ACStyle;

public class ACLabel extends JLabel {
    public ACLabel(){
        customizeComponent();
    }
    public ACLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), ACStyle.FONT, ACStyle.COLOR_FONT_LIGHT, ACStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}
