import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;

import UserInterface.Form.MainForm;

public class App {
    // public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        // AssistControl AssistControl1 = AssistControl.getInstancia("AssistControl");
        // System.out.println(AssistControl.getNombre());
        // AssistControl1.iniciarPrograma();
        // EstatusBL bl = new EstatusBL();
        // System.out.println(bl.getBy(4));

        // for (EstatusDTO dto : bl.getAll()) {
        //     System.out.println(dto.toString());
        // }
        // bl.add("Enfermedad");

        
        // RegistroHorarioBL  regHoraBl = new RegistroHorarioBL();
        // System.out.println(regHoraBl.getByIdEmpleado(1));

        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDateTime now = LocalDateTime.now();
        // System.out.println(now.getDayOfWeek());

        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
            // FlatGradiantoDeepOceanIJTheme()
            // FlatGradiantoMidnightBlueIJTheme()
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 

    //  SplashScreenForm.show();
       MainForm frmMain = new MainForm("AssistControl");

    
        
    }
}
