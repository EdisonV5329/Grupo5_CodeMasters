/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase AssistControl
*/
import BusinessLogic.CargoBL;
import DataAccess.CargoDAO;
import DataAccess.DTO.CargoDTO;

public class AssistControl {
    private static String nombre;
    private static AssistControl instancia;
    
    public static String getNombre() {
        return nombre;
    }
    
    private AssistControl(){}

    protected AssistControl(AssistControl assistControl){
        if(assistControl != null)
            instancia = assistControl;
    }

    public static AssistControl getInstancia(String nombre){
        if(instancia == null){
            instancia = new AssistControl();
            AssistControl.nombre = nombre;
        }
        return instancia;
    }

    public void iniciarPrograma() throws Exception{
        Admin Administrador = Admin.getInstancia("dsn_vr", "Ve230027@", "Edison", "Vera");
        // Admin Admin2 = Admin.getInstancia("pat_mic", "Vedisoñ230027", "Patricio", "Paccha");
        // Admin Admin3 = Admin.getInstancia("mateito_pro", "Vedisoñ2300@", "Mateo", "Simbana");

        // System.out.println(Administrador.getNombre() + " | " + Administrador.getUsuario());
        // System.out.println(Admin2.getNombre() + " | " + Admin2.getUsuario());
        // System.out.println(Admin3.getNombre() + " | " + Admin3.getUsuario());
        Empleado empleado  = new Empleado();

        // Administrador.anadirEmpleado(empleado);
        // System.out.println(empleado.toString());
        // Administrador.modificarEmpleado(empleado);

        // if(Administrador.anadirCargo())
        //     System.out.println("cargo ingresado con exito");
        
        // if(Administrador.modificarCargo())
        //     System.out.println("cargo modificado con exito");
        
        // if(Administrador.borrarCargo())
        //     System.out.println("cargo eliminado con exito");
    
            // if(Administrador.recuperarCargo())
            //     System.out.println("cargo recuperado con exito");
    
    

    }
}
