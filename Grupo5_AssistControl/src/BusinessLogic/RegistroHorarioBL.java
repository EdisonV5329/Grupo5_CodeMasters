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

    public List<RegistroHorarioDTO> getAll() throws Exception{
        return rDAO.readAll();
    }
    
    public List<RegistroHorarioDTO> getAllPuntual() throws Exception{
        return rDAO.readAllEstructura("A tiempo");
    }
    
    public List<RegistroHorarioDTO> getAllAtraso() throws Exception{
        return rDAO.readAllEstructura("Atrasado");
    }

    public RegistroHorarioDTO getByIdEmpleado(int idEmpleado) throws Exception{
        return rDAO.readByIdEmpleado(idEmpleado);
    }

    public Integer getMaxRow() throws Exception{
        return rDAO.getMaxRow();
    }

}
