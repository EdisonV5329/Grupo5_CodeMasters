package UserInterface.CustomeControls;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class TextBox extends JTextField{
    public TextBox(){
        customizeComponent();
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(createBorderRect(Color.RED)); // Cambia el color del borde cuando el TextBox tiene el foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(createBorderRect(Style.Color_Border)); // Cambia el color del borde cuando el TextBox pierde el foco
            }
        });
    }
    
    private void customizeComponent(){
        setFont(Style.FONT_BOLD); // Cambia la fuente a una más atractiva
        setForeground(Style.Color_Font);
        setBorder(createBorderRect(Style.Color_Border));
        setCaretColor(Style.Color_Cursor);
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
            BorderFactory.createMatteBorder(0, 0, size,0, Style.Color_Border)
        );
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, Style.Color_Border) 
        ));
    }
}