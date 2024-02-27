/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.        |
| francisco.torres@epn.edu.ec   Francisco Torres |
|------------------------------------------------|
Autor: Francisco Torres
Fecha: 24.feb.2k24
script: Creacion de la clase RegistroHorarioBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.RegistroHorarioDAO;
import DataAccess.DTO.RegistroHorarioDTO;

public class RegistroHorarioBL {
    private RegistroHorarioDAO rhDAO = new RegistroHorarioDAO();
    public RegistroHorarioBL() {};
    
    public List<RegistroHorarioDTO> getAll() throws Exception{
        return rhDAO.readAll();
    }
    
    public List<RegistroHorarioDTO> getAllATiempo() throws Exception{
        return rhDAO.readAllEstructura("A Tiempo");
    }
    
    public List<RegistroHorarioDTO> getAllAtrasado() throws Exception{
        return rhDAO.readAllEstructura("Atrasado");
    }
    public List<RegistroHorarioDTO> getAllEnfermedad() throws Exception{
        return rhDAO.readAllEstructura("Enfermedad");
    }
    public List<RegistroHorarioDTO> getAllVacaciones() throws Exception{
        return rhDAO.readAllEstructura("Vacaciones");
    }
    public List<RegistroHorarioDTO> getAllInasistencia() throws Exception{
        return rhDAO.readAllEstructura("Inasistencia");
    }

    public RegistroHorarioDTO getById(int id) throws Exception{
        return rhDAO.readBy(id);
    }
   

}
