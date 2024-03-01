/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: dsn_vr y mateitopro
Fecha: 25.feb.2k24
src: Creacion de la clase EmpleadoHorarioBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.EmpleadoHorarioDAO;
import DataAccess.DTO.EmpleadoHorarioDTO;

public class EmpleadoHorarioBL {
    private EmpleadoHorarioDTO  empleadoHorarioDTO;
    private EmpleadoHorarioDAO  empleadoHorarioDAO = new EmpleadoHorarioDAO();

    public EmpleadoHorarioBL(){}

    public List<EmpleadoHorarioDTO> getAll() throws Exception{
        return empleadoHorarioDAO.readAll();
    }
    
    public EmpleadoHorarioDTO getBy(int idEmpleadoHorario) throws Exception{
        empleadoHorarioDTO = empleadoHorarioDAO.readBy(idEmpleadoHorario);
        return empleadoHorarioDTO;
    }

    public boolean add(EmpleadoHorarioDTO empleadoHorarioDTO) throws Exception{
        return empleadoHorarioDAO.create(empleadoHorarioDTO);
    }

    public boolean update(EmpleadoHorarioDTO  empleadoHorarioDTO) throws Exception{
        return empleadoHorarioDAO.update(empleadoHorarioDTO);
    }

    public boolean delete(int idEmpleadoHorario) throws Exception{
        return empleadoHorarioDAO.delete(idEmpleadoHorario);
    }
    
    public boolean restore(int idEmpleadoHorario) throws Exception{
        return empleadoHorarioDAO.restore(idEmpleadoHorario);
    }

    public Integer getMaxRow() throws Exception{
        return empleadoHorarioDAO.getMaxRow();
    }

}
