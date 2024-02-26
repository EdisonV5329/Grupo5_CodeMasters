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
import BusinessLogic.EmpleadoHorarioBL;
import BusinessLogic.EstatusBL;
import DataAccess.DTO.CargoDTO;
import DataAccess.DTO.EmpleadoDTO;
import DataAccess.DTO.EmpleadoHorarioDTO;
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
    

    public void verRegistroAsistencias(){
        
    }

    public void modificarAsistencia(){

    }
    // CRUD para Cargo desde el admin
    public boolean anadirCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        EmpleadoHorarioBL empleadoHorarioBL = new EmpleadoHorarioBL();
        System.out.println("Cargos existentes");
        System.out.println("Nombres:");
        for (CargoDTO s : cargoBL.getAll()) {
            System.out.println("\t" + s.getNombre());        
        }
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
        System.out.println("Horarios Existentes");
        System.out.println("IdHorarios\t|Horario");
        for (EmpleadoHorarioDTO s : empleadoHorarioBL.getAll()) {
            System.out.println(s.toString());        
        }
        System.out.print("Elija un horario(seleccione el Id): ");
            int idEmpleadoHorario = scanner.nextInt();
        return cargoBL.add(nombre, idCargoPadre, idEmpleadoHorario);
    }

    public boolean modificarCargo() throws Exception{
        CargoBL cargoBL = new CargoBL();
        EmpleadoHorarioBL empleadoHorarioBL = new EmpleadoHorarioBL();
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
        System.out.println("Horarios Existentes");
        System.out.println("IdHorarios\t|Horario");
        for (EmpleadoHorarioDTO s : empleadoHorarioBL.getAll()) {
            System.out.println(s.toString());        
        }
        System.out.print("Elija el nuevo horario(seleccione el Id): ");
            int idEmpleadoHorario = scanner.nextInt();
        return cargoBL.update(idCargo, nombre, idCargoPadre, idEmpleadoHorario);
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
        LectorHuellaDigital lhd = new LectorHuellaDigital();
            String huellaDigital = lhd.enviarHuella();
        return empleadoBL.add(nombre, apellido, cargo, cedula, huellaDigital);
    }

    public boolean modificarEmpleado() throws Exception{
        EmpleadoBL empleadoBL = new EmpleadoBL();
        System.out.println("Lista de empleados:");
        System.out.println("IdEmpleado  | Nombre");
        for (EmpleadoDTO s : empleadoBL.getAll()) {
            if(s.getEstado().equals("A"))
                System.out.println(s.getIdEmpleado() + " \t\t| " + s.getNombre() + " " + s.getApellido());
        }
        System.out.print("Empleado a modificar(seleccione el Id): ");
            int idEmpleado = scanner.nextInt();
            System.out.println("Informacion Actual del empleado:");
            System.out.println(empleadoBL.getBy(idEmpleado));
        System.out.println("Ingresar la nueva informacion del empleado");
        System.out.print("Nombre: ");
            String nombre = scanner.next();
        System.out.print("Apellido: ");
            String apellido = scanner.next();
        System.out.print("Cargo: ");
            int cargo = scanner.nextInt();
        return empleadoBL.update(nombre, apellido, cargo, idEmpleado);
    }

    public boolean borrarEmpleado() throws Exception{
        EmpleadoBL empleadoBL = new EmpleadoBL();
        System.out.println("Empleados existentes");
        System.out.println("IdEstatus  | Nombre     | Apellido      | Cedula");
        for (EmpleadoDTO s : empleadoBL.getAll()) {
            if(s.getEstado().equals("A"))
                System.out.println(s.getIdEmpleado() + " \t| " + s.getNombre() + " \t| " 
                                 + s.getApellido() + " \t| " + s.getCedula());
        }
        System.out.print("Empleado a eliminar(seleccione el Id): ");
            int idEstatus = scanner.nextInt();
        return empleadoBL.delete(idEstatus);
    }

    public boolean recuperarEmpleado() throws Exception{
        EmpleadoBL empleadoBL = new EmpleadoBL();
        System.out.println("Empleados existentes");
        System.out.println("IdEmpleado  | Nombre     | Apellido      | Cedula");
        for (EmpleadoDTO s : empleadoBL.getAll()) {
            if(s.getEstado().equals("X"))
                System.out.println(s.getIdEmpleado() + " \t| " + s.getNombre() + " \t| " 
                                 + s.getApellido() + " \t| " + s.getCedula());
        }
        System.out.print("Empleado a eliminar(seleccione el Id): ");
            int idEstatus = scanner.nextInt();
        return empleadoBL.restore(idEstatus);
    }
}
