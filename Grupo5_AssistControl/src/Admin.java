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
import BusinessLogic.EmpleadoBL;
import BusinessLogic.EstatusBL;
import DataAccess.DTO.CargoDTO;
import DataAccess.DTO.EmpleadoDTO;
import DataAccess.DTO.EstatusDTO;

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

    Scanner scanner = new Scanner(System.in);
    public Empleado anadirEmpleado(Empleado empleado){
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
        // scanner.close();
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
    // CRUD para Cargo desde el admin
    public boolean anadirCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        // Scanner scanner = new Scanner(System.in);
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
        // scanner.close();
        return cargoBL.add(nombre, idCargoPadre);
    }

    public boolean modificarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        // Scanner scanner = new Scanner(System.in);
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
        // scanner.close();
        return cargoBL.update(idCargo, nombre, idCargoPadre);
    }

    public boolean borrarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Cargos existentes");
        System.out.println("IdCargo\t|Nombre");
        for (CargoDTO s : cargoBL.getAll()) {
            if(s.getEstado().equals("A"))
                System.out.println(s.getIdCargo() + " \t| " + s.getNombre());
        }
        System.out.print("Cargo a eliminar(seleccione el Id): ");
            int idCargo = scanner.nextInt();
        // scanner.close();
        return cargoBL.delete(idCargo);
    }

    public boolean recuperarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Cargos inactivos");
        System.out.println("IdCargo\t|Nombre");
        for (CargoDTO s : cargoBL.getAll()) {
            if(s.getEstado().equals("X"))
                System.out.println(s.getIdCargo() + " \t| " + s.getNombre());        
        }
        System.out.print("Cargo a recuperar(seleccione el Id): ");
            int idCargo = scanner.nextInt();
        // scanner.close();
        return cargoBL.restore(idCargo);
    }

    // CRUD para Estatus desde el admin
    public boolean anadirEstatus() throws Exception{
        EstatusBL estatusBL = new EstatusBL();
        System.out.println("Escriba la informacion del nuevo estatus");
        System.out.print("Nombre: ");
            String nombre = scanner.next();
        // // scanner.close();
        return estatusBL.add(nombre);
    }

    public boolean modificarEstatus() throws Exception{
        EstatusBL estatusBL = new EstatusBL();
        // Scanner scanner = new Scanner(System.in);
        System.out.println("Estatus existentes");
        System.out.println("IdEstatus  |Nombre");
        for (EstatusDTO s : estatusBL.getAll()) {
            System.out.println(s.getIdEstatus() + " \t| " + s.getNombre());        
        }
        System.out.print("Estatus a modificar(seleccione el Id): ");
            int idEstatus = scanner.nextInt();
        System.out.print("Nuevo Nombre: ");
            String nombre = scanner.next();
        // // scanner.close();
        return estatusBL.update(idEstatus, nombre);
    }

    public boolean borrarEstatus() throws Exception{
        EstatusBL estatusBL = new EstatusBL();
        // // Scanner scanner = new Scanner(System.in);
        System.out.println("Estatus existentes");
        System.out.println("IdEstatus  | Nombre");
        for (EstatusDTO s : estatusBL.getAll()) {
            if(s.getEstado().equals("A"))
                System.out.println(s.getIdEstatus() + " \t| " + s.getNombre());
        }
        System.out.print("Estatus a eliminar(seleccione el Id): ");
            int idEstatus = scanner.nextInt();
        // // scanner.close();
        return estatusBL.delete(idEstatus);
    }

    public boolean recuperarEstatus() throws Exception{
        EstatusBL estatusBL = new EstatusBL();
        // // Scanner scanner = new Scanner(System.in);
        System.out.println("Estatus inactivos");
        System.out.println("IdEstatus  | Nombre");
        for (EstatusDTO s : estatusBL.getAll()) {
            if(s.getEstado().equals("X"))
                System.out.println(s.getIdEstatus() + " \t| " + s.getNombre());        
        }
        System.out.print("Estatus a recuperar(seleccione el Id): ");
            int idEstatus = scanner.nextInt();
        return estatusBL.restore(idEstatus);
    }
    
    // CRUD para Empleados desde el admin
    public boolean anadirEmpleado() throws Exception{
        EmpleadoBL empleadoBL = new EmpleadoBL();
        System.out.println("Ingresar la informacion del nuevo empleado");
        System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
        System.out.print("Cedula: ");
            String cedula = scanner.nextLine();
        System.out.print("Cargo: ");
            int cargo = scanner.nextInt();
        System.out.print("Hora Entrada AM: ");
            String horaAmEntrada = scanner.next();
        System.out.print("Hora Salida AM: ");
            String horaAmSalida = scanner.next();
        System.out.print("Hora Entrada PM: ");
            String horaPmEntrada = scanner.next();
        System.out.print("Hora Salida PM: ");
            String horaPmSalida = scanner.next();
        System.out.print("Huella Digital: ");
        LectorHuellaDigital lhd = new LectorHuellaDigital();
            String huellaDigital = lhd.enviarHuella();
        return empleadoBL.add(nombre, apellido, cargo, horaAmEntrada, horaAmSalida, horaPmEntrada, 
                              horaPmSalida, cedula, huellaDigital);
    }

    public boolean modificarEmpleado() throws Exception{
        EmpleadoBL empleadoBL = new EmpleadoBL();
        System.out.println("Lista de empleados:");
        System.out.println("IdEmpleado  | Nombre");
        for (EmpleadoDTO s : empleadoBL.getAll()) {
            if(s.getEstado().equals("X"))
                System.out.println(s.getIdEmpleado() + " \t\t| " + s.getNombre() + " " + s.getApellido());
        }
        System.out.print("Empleado a modificar(seleccione el Id): ");
            int idEmpleado = scanner.nextInt();
            System.out.println("Informacion Actual del empleado:");
            System.out.println(empleadoBL.getBy(idEmpleado));
        System.out.println("Ingresar la nueva informacion del empleado");
        System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
        System.out.print("Cargo: ");
            int cargo = scanner.nextInt();
        System.out.print("Hora Entrada AM: ");
            String horaAmEntrada = scanner.next();
        System.out.print("Hora Salida AM: ");
            String horaAmSalida = scanner.next();
        System.out.print("Hora Entrada PM: ");
            String horaPmEntrada = scanner.next();
        System.out.print("Hora Salida PM: ");
            String horaPmSalida = scanner.next();
        return empleadoBL.update(nombre, apellido, cargo, horaAmEntrada, horaAmSalida, horaPmEntrada, horaPmSalida);
    }

    // public boolean borrarEmpleado() throws Exception{
    //     EmpleadoBL empleadoBL = new EmpleadoBL();
    //     // // Scanner scanner = new Scanner(System.in);
    //     System.out.println("Estatus existentes");
    //     System.out.println("IdEstatus  | Nombre");
    //     for (EmpleadoDTO s : empleadoBL.getAll()) {
    //         if(s.getEstado().equals("A"))
    //             System.out.println(s.getIdEstatus() + " \t| " + s.getNombre());
    //     }
    //     System.out.print("Estatus a eliminar(seleccione el Id): ");
    //         int idEstatus = scanner.nextInt();
    //     // // scanner.close();
    //     return empleadoBL.delete(idEstatus);
    // }

    // public boolean recuperarEmpleado() throws Exception{
    //     EmpleadoBL empleadoBL = new EmpleadoBL();
    //     // // Scanner scanner = new Scanner(System.in);
    //     System.out.println("Estatus inactivos");
    //     System.out.println("IdEstatus  | Nombre");
    //     for (EmpleadoDTO s : empleadoBL.getAll()) {
    //         if(s.getEstado().equals("X"))
    //             System.out.println(s.getIdEstatus() + " \t| " + s.getNombre());        
    //     }
    //     System.out.print("Estatus a recuperar(seleccione el Id): ");
    //         int idEstatus = scanner.nextInt();
    //         return empleadoBL.restore(idEstatus);
    // }
}
