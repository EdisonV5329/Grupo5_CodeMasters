import java.util.Scanner;

import DataAccess.CargoDAO;
import DataAccess.DTO.CargoDTO;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        AssistControl AssistControl1 = AssistControl.getInstancia("AssistControl");
        // AssistControl AssistControl2 = AssistControl.getInstancia("Patricio");
        // AssistControl AssistControl3 = AssistControl.getInstancia("Mateo");

        System.out.println(AssistControl.getNombre());
        AssistControl1.iniciarPrograma();
        // System.out.println(AssistControl2.getNombre());
        // System.out.println(AssistControl3.getNombre());
        
           
        
    }



}
