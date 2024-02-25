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
import DataAccess.EmpleadoDAO;
import DataAccess.DTO.CargoDTO;
import DataAccess.DTO.EmpleadoDTO;

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
        Admin Administrador = Admin.getInstancia("dsn_vr", "Ve2300@", "Edison", "Vera");

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
    
        // EmpleadoDTO e = new EmpleadoDTO();
        // e.setNombre("Emilio");
        // e.setApellido("Gavilanez");
        // e.setIdCargo(5);
        // // e.setCedula("2109876543");
        // e.setHoraAmEntrada("08:00:00");
        // e.setHoraAmSalida("12:00:00");
        // e.setHoraPmEntrada("13:00:00");
        // e.setHoraPmSalida("17:00:00");
        // e.setIdEmpleado(1);

        
        // EmpleadoDAO oE = new EmpleadoDAO();
        // // oE.create(e);
        // // oE.update(e);
        // System.out.println(oE.readBy(1));
        // // oE.delete(1);
        // oE.restore(1);

        // // for (EmpleadoDTO s : oE.readAll()) {
        // //     System.out.println(s.toString());
        // // }
    }
}
