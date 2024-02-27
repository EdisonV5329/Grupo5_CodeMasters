/*
|----------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.             |
| estefano.santacruz@epn.edu.ec   Estefano Santacruz |
|----------------------------------------------------|
Autor: Estefano Santacruz
Fecha: 25.feb.2k24
src: Creacion de la clase PersonaRolBL
*/
package BusinessLogic;

import  java.util.List;

import  DataAccess.PersonaRolDAO;
import  DataAccess.DTO.PersonaRolDTO;

public class PersonaRolBL {
    private PersonaRolDTO personarol;
    private PersonaRolDAO prDAO = new PersonaRolDAO();

    public PersonaRolBL(){}

    public List<PersonaRolDTO> getAll() throws Exception{
        return prDAO.readAll();
    }

    public PersonaRolDTO getBy(Integer idPersonaRol) throws Exception{
        personarol = prDAO.readBy(idPersonaRol);
        return personarol;
    }

    public boolean add(String Nombre, int idPersonaRol_Padre) throws Exception{
        personarol = new PersonaRolDTO();
        personarol.setNombre(Nombre);
        personarol.setIdPersonaRol_Padre(idPersonaRol_Padre);
        return prDAO.create(personarol);
    }

    public boolean update(int idPersonaRol, String Nombre, int idPersonaRol_Padre) throws Exception{
        personarol = new PersonaRolDTO();
        personarol.setIdPersonaRol(idPersonaRol);
        personarol.setNombre(Nombre);
        personarol.setIdPersonaRol_Padre(idPersonaRol_Padre);
        return prDAO.update(personarol);
    }

    public boolean delete(int idPersonaRol) throws Exception {
        return prDAO.delete(idPersonaRol);
    }
    public boolean restore(int idPersonaRol) throws Exception {
        return prDAO.restore(idPersonaRol);
    }

    public Integer getMaxId() throws Exception{
        return prDAO.getMaxIdPersonaRol();
    }
    
}
