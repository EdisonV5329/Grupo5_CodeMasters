import java.util.Scanner;

import BusinessLogic.EstatusBL;
import DataAccess.DTO.EstatusDTO;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        AssistControl AssistControl1 = AssistControl.getInstancia("AssistControl");
        System.out.println(AssistControl.getNombre());
        AssistControl1.iniciarPrograma();

    }
}
