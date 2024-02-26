/*
|----------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.             |
| estefano.santacruz@epn.edu.ec   Estefano Santacruz |
|----------------------------------------------------|
Autor: Estefano Santacruz
Fecha: 25.feb.2k24
src: Creacion de la clase PersonaBL
*/

package BusinessLogic;

import java.util.List;

import DataAccess.PersonaDAO;
import DataAccess.DTO.PersonaDTO;

public class PersonaBL {
   private PersonaDTO persona;
    private PersonaDAO peDAO = new PersonaDAO();

    public PersonaBL(){}

    public List<PersonaDTO> getAll() throws Exception{
        return peDAO.readAll();
    }

    public PersonaDTO getBy(int idPersona) throws Exception{
        persona = peDAO.readBy(idPersona);
        return persona;
    }

    public boolean add(String Nombre, int idPersonaRol, int idPersonaSexo) throws Exception{
        persona = new PersonaDTO();
        persona.setNombre(Nombre);
        persona.setIdPersonaRol(idPersonaRol);
        persona.setIdPersonaSexo(idPersonaSexo);
        return peDAO.create(persona);
    }

    public boolean update(int idPersona, String Nombre, int idPersonaRol, int idPersonaSexo) throws Exception{
        persona = new PersonaDTO();
        persona.setIdPersona(idPersona);
        persona.setNombre(Nombre);
        persona.setIdPersonaRol(idPersonaRol);
        persona.setIdPersonaSexo(idPersonaSexo);
        return peDAO.update(persona);
    }

    public boolean delete(int idPersona) throws Exception {
        return peDAO.delete(idPersona);
    }
    public boolean restore(int idPersona) throws Exception {
        return peDAO.restore(idPersona);
    }
    
}
