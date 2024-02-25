package UserInterface.CustomeControls;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Label extends JLabel {
    public Label(){
        customizeComponent();
    }

    public Label(String text){
        super(text);
        customizeComponent();
    }

    private void customizeComponent(){
        setCustomizeComponent(getText(), Style.FONT_BOLD, Style.Color_Font,
                             Style.ALIGMENT_LEFT);
    } 
    
    public void setCustomizeComponent(String text, java.awt.Font font, java.awt.Color color, int aligment){
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(aligment);
        setBorder(createShadowBorder()); // Agrega un borde de sombra
    }

    // Crea un borde de sombra
    private Border createShadowBorder() {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
    }
}