/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase AssistControl
*/

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

        
        // if(Administrador.anadirHora())
        //     System.out.println("hora modificado con exito");
        // if(Administrador.modificarHora())
        //     System.out.println("hora modificado con exito");

            // if(Administrador.borrarHora())
            // System.out.println("hora borrada con exito");
            // if(Administrador.recuperarHora())
            // System.out.println("hora recuperada con exito");

        
        // if(Administrador.anadirDiaTrabajo())
        //     System.out.println("dia trabajo agrgado con exito");
        
        // if(Administrador.borrarEmpleado())
        //     System.out.println("empleado borrado con exito");
        
        // if(Administrador.recuperarEmpleado())
        //     System.out.println("empleado recuperado con exito");
        
        
        
        
        
        
        
    }
}
