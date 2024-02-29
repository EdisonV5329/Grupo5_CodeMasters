/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
Metodo: Creacion de la clase Style

*/

package UserInterface.CustomeControls;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Cursor;

/**
 * Clase que contiene los estilos de los controles
 */


public class Style {
    public static final Color Color_Cursor = Color.WHITE; //Color del cursor
    public static final Color Color_Border = new Color(255, 255, 255); //Color del borde
    public static final Color Color_Font = new Color(255, 255, 255);
    
    public static final Color Color_Background = new Color(0, 0, 0); //Color del fondo
    public static final Color Color_Highlight = new Color(255, 0, 0); // Color de resaltado

    public static final Font FONT = new Font("Roboto", Font.PLAIN, 14); //Fuente del texto
    public static final Font FONT_BOLD = new Font("Roboto", Font.BOLD| Font.PLAIN, 14); //Fuente del texto en negrita 
    public static final Font FONT_SMALL = new Font("Roboto", Font.PLAIN| Font.PLAIN, 14); //Fuente del texto pequeño
    public static final Font FONT_LARGE = new Font("Roboto", Font.PLAIN, 18); // Fuente grande
    public static final Font FONT_ITALIC = new Font("Roboto", Font.ITALIC, 14); // Fuente cursiva


    public static final int ALIGMENT_LEFT = SwingConstants.LEFT; //Alineación a la izquierda
    public static final int ALIGMENT_CENTER = SwingConstants.CENTER; //Alineación al centro
    public static final int ALIGMENT_RIGHT = SwingConstants.RIGHT; //Alineación a la derecha

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR); //Cursor de la mano
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR); //Cursor por defecto
    public static final Cursor CURSOR_CROSSHAIR = new Cursor(Cursor.CROSSHAIR_CURSOR); // Cursor de mira

    public static final URL URL_MAIN  = Style.class.getResource("/UserInterface/Resource/Img/Main.png");
    public static final URL URL_LOGO  = Style.class.getResource("/UserInterface/Resource/Ico/IconoPolitinder (1).png");
    public static final URL URL_SPLASH= Style.class.getResource("/UserInterface/Resource/Img/IconoPolitinder (1).jpg");

    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
                                                    new EmptyBorder(5, 5, 5, 5));
    }
    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "❤️‍🔥 Politinder", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "❤️‍🔥 Politinder", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "❤️‍🔥 Politinder", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

}