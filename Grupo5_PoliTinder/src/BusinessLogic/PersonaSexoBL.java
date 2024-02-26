/*
|----------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.             |
| estefano.santacruz@epn.edu.ec   Estefano Santacruz |
|----------------------------------------------------|
Autor: Estefano Santacruz
Fecha: 25.feb.2k24
src: Creacion de la clase PersonaSexoBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.PersonaSexoDAO;
import DataAccess.DTO.PersonaSexoDTO;


public class PersonaSexoBL {
     private PersonaSexoDTO personasexo;
    private PersonaSexoDAO psDAO = new PersonaSexoDAO();

    public PersonaSexoBL(){}

    public List<PersonaSexoDTO> getAll() throws Exception{
        return psDAO.readAll();
    }

    public PersonaSexoDTO getBy(int idPersonaSexo) throws Exception{
        personasexo = psDAO.readBy(idPersonaSexo);
        return personasexo;
    }

    public boolean add(String Nombre) throws Exception{
        personasexo = new PersonaSexoDTO();
        personasexo.setNombre(Nombre);
        return psDAO.create(personasexo);
    }

    public boolean update(int idPersonaSexo, String Nombre) throws Exception{
        personasexo = new PersonaSexoDTO();
        personasexo.setIdPersonaSexo(idPersonaSexo);
        personasexo.setNombre(Nombre);
        return psDAO.update(personasexo);
    }

    public boolean delete(int idPersonaSexo) throws Exception {
        return psDAO.delete(idPersonaSexo);
    }
    public boolean restore(int idPersonaSexo) throws Exception {
        return psDAO.restore(idPersonaSexo);
    }
    
}
