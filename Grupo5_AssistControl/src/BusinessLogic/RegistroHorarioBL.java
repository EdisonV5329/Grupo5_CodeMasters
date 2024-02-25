/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 25.feb.2k24
script: Creacion de la clase RegistroHorarioDAO
*/
package BusinessLogic;

import java.util.List;

import DataAccess.RegistroHorarioDAO;
import DataAccess.DTO.RegistroHorarioDTO;

public class RegistroHorarioBL {
    private RegistroHorarioDAO rDAO = new RegistroHorarioDAO();

    public RegistroHorarioBL() {};

    public boolean create(RegistroHorarioDTO registroHorarioDTO) throws Exception{   
        return rDAO.create(registroHorarioDTO);
    }

    public boolean update(RegistroHorarioDTO registroHorarioDTO) throws Exception{
        return rDAO.update(registroHorarioDTO);
    }

    public List<RegistroHorarioDTO> getAll() throws Exception{
        return rDAO.readAll();
    }

    public RegistroHorarioDTO getByIdEmpleado(int idEmpleado) throws Exception{
        return rDAO.readByIdEmpleado(idEmpleado);
    }

    public Integer getMaxRow() throws Exception{
        return rDAO.getMaxRow();
    }

}
