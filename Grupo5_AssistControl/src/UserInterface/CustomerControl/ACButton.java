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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import UserInterface.ACStyle;

import javax.swing.ImageIcon;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



    public class ACButton extends JButton implements MouseListener {
        private Timer timer;
        private float alpha = 1f;

        public ACButton(String text){
            customizeComponent(text);
            setupAnimation();
        }
        public ACButton(String text, String iconPath){
            customizeComponent(text, iconPath);
            setupAnimation();
        }
        

        private void setupAnimation() {
            timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    alpha += -0.05f;
                    if (alpha <= 0) {
                        alpha = 0;
                        timer.stop();
                    }
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.SrcOver.derive(alpha));
            super.paintComponent(g2);
            g2.dispose();
        }
    

    public void customizeComponent(String text, String iconPath){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20); 
        
        setIcon(new ImageIcon(iconPath));
        setFont(ACStyle.FONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(true);
        setContentAreaFilled(false);
        setForeground(ACStyle.COLOR_FONT);
        setHorizontalAlignment(ACStyle.ALIGNMENT_LEFT);
        setFont(ACStyle.FONT);
        
        setCursor(ACStyle.CURSOR_HAND);
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
        setForeground(ACStyle.Color_Hover);
        setCursor(ACStyle.CURSOR_HAND);
        timer.start();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(ACStyle.COLOR_FONT);
        setCursor(ACStyle.CURSOR_DEFAULT);
        alpha = 1f;
        repaint();
    } 
}
