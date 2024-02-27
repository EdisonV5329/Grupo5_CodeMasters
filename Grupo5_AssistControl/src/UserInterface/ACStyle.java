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
Clase: Creacion de la clase ACStyle
*/
package UserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class ACStyle {
    public static final Color COLOR_FONT = new Color(0, 108, 255); //(218, 8, 40)
    public static final Color COLOR_FONT_LIGHT = new Color(0, 181, 109);
    public static final Color COLOR_CURSOR = new Color(24, 45, 92);
    public static final Color COLOR_BORDER = new Color(158, 199, 0);
    public static final Color Color_Background = new Color(0, 0, 0); //Color del fondo
    public static final Color Color_Highlight = new Color(0, 204, 153); // Color de resaltado
    public static final Color Color_Hover = new Color(0, 204, 153); // Color de resaltado al pasar el mouse por encima
    public static final Color Color_Default = new Color(86, 86, 86); // Color por defecto para los campos vacíos

    public static final Font FONT = new Font("Kode Mono", Font.PLAIN, 14); //Fuente del texto
    public static final Font FONT_BOLD = new Font("Kode Mono", Font.BOLD| Font.PLAIN, 14); //Fuente del texto en negrita 
    public static final Font FONT_SMALL = new Font("Kode Mono", Font.PLAIN| Font.PLAIN, 14); //Fuente del texto pequeño
    public static final Font FONT_LARGE = new Font("Kode Mono", Font.PLAIN, 18); // Fuente grande
    public static final Font FONT_ITALIC = new Font("Kode Mono", Font.ITALIC, 14); // Fuente cursiva

    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);
    public static final Cursor CURSOR_CROSSHAIR= new Cursor(Cursor.CROSSHAIR_CURSOR);


    public static final URL URL_MAIN  = ACStyle.class.getResource("/UserInterface/Resource/Img/human-profile-monochromatic (2) (1).png");
    public static final URL URL_LOGO  = ACStyle.class.getResource("/UserInterface/Resource/Img/Logo.png");
    public static final URL URL_SPLASH= ACStyle.class.getResource("/UserInterface/Resource/Img/Splash.gif");

    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.lightGray),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "🤖 AssistControl", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "👾 AssistControl", JOptionPane.OK_OPTION);
    }

    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "🤔 AssistControl", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
