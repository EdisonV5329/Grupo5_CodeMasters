/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
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

    public boolean add(int IdDiaTrabajo, int IdHoraAmEntrada, int IdHoraAmSalida, int IdHoraPmEntrada,
                       int IdHoraPmSalida) throws Exception{
        empleadoHorarioDTO = new EmpleadoHorarioDTO();
        empleadoHorarioDTO.setIdDiaTrabajo(IdDiaTrabajo);
        empleadoHorarioDTO.setIdHoraAmEntrada(IdHoraAmEntrada);
        empleadoHorarioDTO.setIdHoraAmSalida(IdHoraAmSalida);
        empleadoHorarioDTO.setIdHoraPmEntrada(IdHoraPmEntrada);
        empleadoHorarioDTO.setIdHoraPmSalida(IdHoraPmSalida);
        return empleadoHorarioDAO.create(empleadoHorarioDTO);
    }

    public boolean update(int IdDiaTrabajo, int IdHoraAmEntrada, int IdHoraAmSalida, int IdHoraPmEntrada,
                          int IdHoraPmSalida, int idEmpleadoHorario) throws Exception{
        empleadoHorarioDTO = new EmpleadoHorarioDTO();
        empleadoHorarioDTO.setIdDiaTrabajo(IdDiaTrabajo);
        empleadoHorarioDTO.setIdHoraAmEntrada(IdHoraAmEntrada);
        empleadoHorarioDTO.setIdHoraAmSalida(IdHoraAmSalida);
        empleadoHorarioDTO.setIdHoraPmEntrada(IdHoraPmEntrada);
        empleadoHorarioDTO.setIdHoraPmSalida(IdHoraPmSalida);
        empleadoHorarioDTO.setIdEmpleadoHorario(idEmpleadoHorario);
        return empleadoHorarioDAO.update(empleadoHorarioDTO);
    }

    public boolean delete(int idEmpleadoHorario) throws Exception{
        return empleadoHorarioDAO.delete(idEmpleadoHorario);
    }
    
    public boolean restore(int idEmpleadoHorario) throws Exception{
        return empleadoHorarioDAO.restore(idEmpleadoHorario);
    }
}
