/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
Metodo: Creacion de la clase LabelLink

*/
package UserInterface.CustomeControls;

import javax.swing.ImageIcon;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LabelLink extends Label implements MouseListener {

    LabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    LabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(Style.Color_Font);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(Style.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(Style.CURSOR_DEFAULT);
    }
}

