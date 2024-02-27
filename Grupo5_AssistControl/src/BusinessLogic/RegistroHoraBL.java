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

import DataAccess.RegistroHoraDAO;
import DataAccess.DTO.RegistroHoraDTO;

public class RegistroHoraBL {
    private RegistroHoraDAO rhDAO = new RegistroHoraDAO();
    public RegistroHoraBL() {};
    
    public List<RegistroHoraDTO> getAll() throws Exception{
        return rhDAO.readAll();
    }
    
    public List<RegistroHoraDTO> getAllATiempo() throws Exception{
        return rhDAO.readAllEstructura("A Tiempo");
    }
    
    public List<RegistroHoraDTO> getAllAtrasado() throws Exception{
        return rhDAO.readAllEstructura("Atrasado");
    }
    public List<RegistroHoraDTO> getAllEnfermedad() throws Exception{
        return rhDAO.readAllEstructura("Enfermedad");
    }
    public List<RegistroHoraDTO> getAllVacaciones() throws Exception{
        return rhDAO.readAllEstructura("Vacaciones");
    }
    public List<RegistroHoraDTO> getAllInasistencia() throws Exception{
        return rhDAO.readAllEstructura("Inasistencia");
    }

    public RegistroHoraDTO getById(int id) throws Exception{
        return rhDAO.readBy(id);
    }
   

}
