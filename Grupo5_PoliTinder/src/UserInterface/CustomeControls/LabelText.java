/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
Metodo: Creacion de la clase LabelText

*/
package UserInterface.CustomeControls;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;

public class LabelText extends JPanel {
    private Label lblEtiqueta = new Label();
    private TextBox txtContenido = new TextBox();    

    public LabelText(String etiqueta){
        setLayout(new BorderLayout(10, 10)); // Agrega un espaciado de 10 entre los componentes
        lblEtiqueta.setCustomizeComponent(etiqueta, 
                                          Style.FONT_BOLD, // Cambia la fuente a una más atractiva
                                          Style.Color_Font,
                                          Style.ALIGMENT_LEFT);
        txtContenido.setBorder(txtContenido.createBorderLine());
        add(lblEtiqueta, BorderLayout.WEST); // Añade el label al oeste
        add(txtContenido, BorderLayout.CENTER); // Añade el textbox al centro
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega un borde alrededor del panel
    }
}
