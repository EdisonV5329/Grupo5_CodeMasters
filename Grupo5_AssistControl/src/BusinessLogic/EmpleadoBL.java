/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase EmpleadoBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.EmpleadoDAO;
import DataAccess.DTO.EmpleadoDTO;

public class EmpleadoBL {
    private EmpleadoDTO  empleadoDTO;
    private EmpleadoDAO  empleadoDAO = new EmpleadoDAO();

    public EmpleadoBL(){}

    public List<EmpleadoDTO> getAll() throws Exception{
        return empleadoDAO.readAll();
    }
    
    public EmpleadoDTO getBy(Integer idEmpleado) throws Exception{
        empleadoDTO = empleadoDAO.readBy(idEmpleado);
        return empleadoDTO;
    }

    public boolean add(String nombre,String apellido, int idCargo, String cedula, String HuellaDigital) throws Exception{
        empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombre(nombre);
        empleadoDTO.setApellido(apellido);
        empleadoDTO.setCedula(cedula);
        empleadoDTO.setHuellaDigital(HuellaDigital);
        empleadoDTO.setIdCargo(idCargo);
        return empleadoDAO.create(empleadoDTO);
    }

    public boolean update(String nombre,String apellido, int idCargo, int idEmpleado) throws Exception{
        empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombre(nombre);
        empleadoDTO.setApellido(apellido);
        empleadoDTO.setIdCargo(idCargo);
        empleadoDTO.setIdEmpleado(idEmpleado);
        return empleadoDAO.update(empleadoDTO);
    }

    public boolean delete(int idEmpleado) throws Exception{
        return empleadoDAO.delete(idEmpleado);
    }
    
    public boolean restore(int idEmpleado) throws Exception{
        return empleadoDAO.restore(idEmpleado);
    }

    public Integer getMaxId() throws Exception{
        return empleadoDAO.getMaxIdEmpleado();
    }   
}