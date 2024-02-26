/*
|----------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.             |
| estefano.santacruz@epn.edu.ec   Estefano Santacruz |
|----------------------------------------------------|
Autor: Estefano Santacruz
Fecha: 25.feb.2k24
src: Creacion de la clase CitaBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.CitaDAO;
import DataAccess.DTO.CitaDTO;

public class CitaBL {
    private CitaDTO cita;
     private CitaDAO ciDao = new CitaDAO();

    public CitaBL(){}

    public List<CitaDTO> getAll() throws Exception{
        return ciDao.readAll();
    }

    public CitaDTO getBy(int idCita) throws Exception{
        cita = ciDao.readBy(idCita);
        return cita;
    }

    public boolean add(String Nombre, int idPersona1, int idPersona2) throws Exception{
        cita = new CitaDTO();
        cita.setNombre(Nombre);
        cita.setIdPersona1(idPersona1);
        cita.setIdPersona2(idPersona2);
        return ciDao.create(cita);
    }

    public boolean update(int idCita , String Nombre, int idPersona1, int idPersona2) throws Exception{
        cita = new CitaDTO();
        cita.setidCita(idCita );
        cita.setNombre(Nombre);
        cita.setIdPersona1(idPersona1);
        cita.setIdPersona2(idPersona2);
        return ciDao.update(cita);
    }

    public boolean delete(int idCita ) throws Exception {
        return ciDao.delete(idCita);
    }
    public boolean restore(int idCita) throws Exception {
        return ciDao.restore(idCita);
    }
    
}
