/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase AssistControl
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import BusinessLogic.EmpleadoBL;
import BusinessLogic.EstatusBL;
import BusinessLogic.RegistroHorarioBL;
import DataAccess.CargoDAO;
import DataAccess.EmpleadoDAO;
import DataAccess.EstatusDAO;
import DataAccess.DTO.EstatusDTO;
import DataAccess.DTO.RegistroHorarioDTO;

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

        // Empleado empleado  = new Empleado();

        // Administrador.anadirEmpleado(empleado);
        // System.out.println(empleado.toString());
        // Administrador.modificarEmpleado(empleado);

        // if(Administrador.borrarCargo())
        //     System.out.println("cargo borrado con exito");
        
        // if(Administrador.recuperarCargo())
        //     System.out.println("cargo recuperado con exito");
        
        
        // CargoDAO eDAO = new CargoDAO();
        
        // System.out.println(eDAO.readBy(2).toString());
        
        // if(Administrador.anadirEstatus())
        //     System.out.println("estatus ingresado con exito");
        
        // if(Administrador.modificarEstatus())
        //     System.out.println("estatus modificado con exito");
        
        // if(Administrador.borrarEstatus())
        //     System.out.println("estatus eliminado con exito");
    
        // if(Administrador.recuperarEstatus())
        //     System.out.println("estatus recuperado con exito");
    
        // if(Administrador.anadirEmpleado())
        //     System.out.println("empleado ingresado con exito");
        
        // if(Administrador.modificarEstatus())
        //     System.out.println("estatus modificado con exito");
        
        // if(Administrador.borrarEstatus())
        //     System.out.println("estatus eliminado con exito");
    
        // if(Administrador.recuperarEstatus())
        //     System.out.println("estatus recuperado con exito");
    
        
        
    }
}
