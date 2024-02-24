/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase Admin
*/
import java.util.Scanner;

import BusinessLogic.CargoBL;
import DataAccess.DTO.CargoDTO;

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
        System.out.println("Elija de que empleado quiere modificar la informacion");
    }

    public void eliminarEmpleado(){

    }

    public void verRegistroAsistencias(){

    }

    public void modificarAsistencia(){

    }

    public boolean anadirCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba la informacion del nuevo cargo");
        System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
        System.out.println("Cargos existentes");
        System.out.println("IdCargo\t|Nombre");
        for (CargoDTO s : cargoBL.getAll()) {
            System.out.println(s.getIdCargo() + " \t| " + s.getNombre());        
        }
        System.out.print("Jefe del nuevo cargo(seleccione el Id): ");
            int idCargoPadre = scanner.nextInt();
        scanner.close();
        return cargoBL.add(nombre, idCargoPadre);
    }

    public boolean modificarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cargos existentes");
        System.out.println("IdCargo\t|Nombre");
        for (CargoDTO s : cargoBL.getAll()) {
            System.out.println(s.getIdCargo() + " \t| " + s.getNombre());        
        }
        System.out.print("Cargo a modificar(seleccione el Id): ");
            int idCargo = scanner.nextInt();
        System.out.print("Nuevo Jefe del cargo(seleccione el Id): ");
            int idCargoPadre = scanner.nextInt();
        System.out.print("Nuevo Nombre: ");
            String nombre = scanner.next();
        scanner.close();
        return cargoBL.update(idCargo, nombre, idCargoPadre);
    }

    public boolean borrarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cargos existentes");
        System.out.println("IdCargo\t|Nombre");
        for (CargoDTO s : cargoBL.getAll()) {
            if(s.getEstado().equals("A"))
                System.out.println(s.getIdCargo() + " \t| " + s.getNombre());
        }
        System.out.print("Cargo a eliminar(seleccione el Id): ");
            int idCargo = scanner.nextInt();
        scanner.close();
        return cargoBL.delete(idCargo);
    }

    public boolean recuperarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cargos inactivos");
        System.out.println("IdCargo\t|Nombre");
        for (CargoDTO s : cargoBL.getAll()) {
            if(s.getEstado().equals("X"))
                System.out.println(s.getIdCargo() + " \t| " + s.getNombre());        
        }
        System.out.print("Cargo a recuperar(seleccione el Id): ");
            int idCargo = scanner.nextInt();
        scanner.close();
        return cargoBL.restore(idCargo);
    }

}
