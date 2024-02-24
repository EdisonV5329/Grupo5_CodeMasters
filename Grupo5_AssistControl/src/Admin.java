/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase Admin
*/
import java.util.List;
import java.util.Scanner;

public class Admin extends Usuario {
    private static String usuario;
    private static String clave;
    private static Admin instancia;

    private Admin(String nombre, String apellido){
        super(nombre, apellido);
    }

    protected Admin(Admin admin){
        if(admin != null)
            instancia = admin; 
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getClave() {
        return clave;
    }

    public static Admin getInstancia(String usuario, String clave, String nombre, String apellido){
        if(instancia == null){
            instancia = new Admin(nombre, apellido);
            Admin.usuario = usuario;
            Admin.clave = clave;
        }
        return instancia;
    }

    public Empleado anadirEmpleado(Empleado empleado){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar la informacion del nuevo empleado");
        System.out.print("Nombre: ");
            empleado.setNombre(App.sc.nextLine());
        System.out.print("Apellido: ");
            empleado.setApellido(App.sc.nextLine());
        System.out.print("Cargo: ");
            empleado.setCargo(App.sc.nextLine());
        System.out.print("Hora Entrada AM: ");
            empleado.setHoraAmEntradaFijo(App.sc.nextLine());
        System.out.print("Hora Salida AM: ");
            empleado.setHoraAmSalidaFijo(App.sc.nextLine());
        System.out.print("Hora Entrada PM: ");
            empleado.setHoraPmEntradaFijo(App.sc.nextLine());
        System.out.print("Hora Salida PM: ");
            empleado.setHoraPmSalidaFijo(App.sc.nextLine());
        scanner.close();
        return empleado;
    }

    public void modificarEmpleado(Empleado empleado){
        System.out.println("Informacion Actual");
        System.out.println(empleado.toString());
    }

    public void eliminarEmpleado(){

    }

    public void verRegistroAsistencias(){

    }

    public void modificarAsistencia(){

    }

}
