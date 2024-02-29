
import UserInterface.Form.SplashScreenForm;
import UserInterface.Form.MainForm;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import BusinessLogic.PersonaRolBL;
import BusinessLogic.RegaloTipoBL;
import DataAccess.DTO.PersonaRolDTO;


public class App {
    public static void main(String[] args) throws Exception {
       
    PersonaRolDTO p = new PersonaRolDTO();
    

    PersonaRolBL p1 = new PersonaRolBL();
    System.out.println("aqui:" + p1.getBy(1).getNombre());
    FlatLightLaf.setup();
    FlatLightLaf.supportsNativeWindowDecorations();
    try {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
    } catch (UnsupportedLookAndFeelException e) {
        e.printStackTrace();
    } 
<<<<<<< HEAD

   //SplashScreenForm.show();
   MainForm frmMain = new MainForm("PoliTinder");
=======
        SplashScreenForm.show();
        MainForm frmMain = new MainForm("PoliTinder");
>>>>>>> 1c5ec06c43c321d456224e980413f2c79e91567f
    }

    
}
