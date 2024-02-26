/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
script: Creacion de la clase ACLabelLink
*/
package UserInterface.CustomerControl;

import javax.swing.ImageIcon;

import UserInterface.ACStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ACLabelLink extends ACLabel implements MouseListener {

    ACLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    ACLabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(ACStyle.COLOR_FONT);
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
        this.setCursor(ACStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(ACStyle.CURSOR_DEFAULT);
    }
}