import java.util.Scanner;

import BusinessLogic.EstatusBL;
import BusinessLogic.RegistroHorarioBL;
import DataAccess.DTO.EstatusDTO;

public class App {
    public static Scanner sc = new Scanner(System.in);

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


        RegistroHorarioBL  regHoraBl = new RegistroHorarioBL();
        System.out.println(regHoraBl.getByIdEmpleado(1));
    }
}
