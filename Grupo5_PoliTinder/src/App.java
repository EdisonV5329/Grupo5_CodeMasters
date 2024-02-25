
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

        // System.out.println("info de la base RegaloTipo");
        // RegaloTipoDAO oRegaloTipo = new RegaloTipoDAO();
        // for(RegaloTipoDTO s : oRegaloTipo.readAll()){
        //     System.out.println(s.toString());
        // }
        // System.out.println();



        // System.out.println("info de la base RelacionTipo");
        // RelacionTipoDAO oRelacionTipo = new RelacionTipoDAO();
        // for(RelacionTipoDTO s : oRelacionTipo.readAll()){
        //     System.out.println(s.toString());
        // }
        // System.out.println();
        
        

        // System.out.println("info de la base Regalo");
        // RegaloDAO oRegalo = new RegaloDAO();
        // for(RegaloDTO s : oRegalo.readAll()){
        //         System.out.println(s.toString());
        // }
        // System.out.println();



        // System.out.println("info de la base Persona");
        // PersonaDAO oPersona = new PersonaDAO();
        // for(PersonaDTO s : oPersona.readAll()){
        //     System.out.println(s.toString());
        // }
        // System.out.println();
        
        
        
        // System.out.println("info de la base RegaloEnvio");        
        // RegaloEnvioDAO oRegaloEnvio = new RegaloEnvioDAO();
        // for(RegaloEnvioDTO s : oRegaloEnvio.readAll()){
        //     System.out.println(s.toString());
        // }
        // System.out.println();



        // System.out.println("info de la base PersonaSexo");
        // // SexoDTO s = new SexoDTO();
        // // s.setIdSexo(3);
        // // s.setNombre("Hibrido");
        // PersonaSexoDAO oS = new PersonaSexoDAO();
        // // oS.create(s);   
        // // oS.update(s);   
        // // System.out.println(oS.readBy(3).toString());
        // for (PersonaSexoDTO s : oS.readAll()) {
        //     System.out.println(s.toString());
        // }
        // System.out.println();

        // System.out.println("info de la base PersonaRol");

        // PersonaRolDAO oPR = new PersonaRolDAO();


        // for (PersonaRolDTO r : oPR.readAll()) {
        //     System.out.println(r.toString());
        // }
        // System.out.println();

        // System.out.println("info de la base Relacion");

        // RelacionDAO rD = new RelacionDAO();


        // for (RelacionDTO r : rD.readAll()) {
        //     System.out.println(r.toString());
        // }
        // System.out.println();

        // System.out.println("info de la base Cita");

        // CitaDAO c = new CitaDAO();

        // for (CitaDTO cD : c.readAll()) {
        //     System.out.println(cD.toString());
        // }

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
