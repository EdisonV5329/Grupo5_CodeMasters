
import UserInterface.Form.LoginPanel;
import UserInterface.Form.SplashScreenForm;
import UserInterface.Form.MainForm;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;


public class App {
    public static void main(String[] args) throws Exception {

    // SplashScreenForm.show();

    FlatLightLaf.setup();
    FlatLightLaf.supportsNativeWindowDecorations();
    try {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
    } catch (UnsupportedLookAndFeelException e) {
        e.printStackTrace();
    } 
        SplashScreenForm.show();
        MainForm frmMain = new MainForm("PoliTinder");
    }
}
