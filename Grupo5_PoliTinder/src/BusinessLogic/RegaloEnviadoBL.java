/*
|----------------------------------------------------|
| (©) COPYRIGHT (©) 2024 EPN-FIS.                    |
|             Todos los derechos reservados.         | 
| andree.silva@epn.edu.ec   Andree Silva             |
|  © © © © © © © © © © © © © © © © © © © © © © © © © |
|----------------------------------------------------|
Autor: Andree Silva
Fecha: 25.feb.2024
src: Creación de la clase RegaloEnviadoBL
*/


package BusinessLogic;

import java.util.List;
import DataAccess.RegaloEnvioDAO;
import DataAccess.DTO.RegaloEnvioDTO;

public class RegaloEnviadoBL {

    private RegaloEnvioDTO regaloenviado;
    private RegaloEnvioDAO rgenvDAO = new RegaloEnvioDAO();

    public RegaloEnviadoBL(){

    }

    public List<RegaloEnvioDTO> getAll() throws Exception{
        return rgenvDAO.readAll();
    }

    public RegaloEnvioDTO getBy(int idRegaloEnviado) throws Exception{
        regaloenviado = rgenvDAO.readBy(idRegaloEnviado);
        return regaloenviado;
    }

    public boolean add(String Nombre, int idPersonaEnvia, int idPersonaRecibe, int idRegalo) throws Exception{
        regaloenviado = new RegaloEnvioDTO();
        regaloenviado.setNombre (Nombre );
        regaloenviado.setIdPersonaEnvia (idPersonaEnvia );
        regaloenviado.setIdPersonaEnvia (idPersonaRecibe );
        regaloenviado.setIdRegalo (idRegalo );
        return rgenvDAO.create(regaloenviado);
    }

    public boolean update(int idRegaloEnviado, String Nombre, int idPersonaEnvia, int idPersonaRecibe, int idRegalo) throws Exception{
        regaloenviado = new RegaloEnvioDTO();
        regaloenviado.setIdRegalo(idRegaloEnviado);
        regaloenviado.setIdPersonaEnvia (idPersonaEnvia );
        regaloenviado.setIdPersonaEnvia (idPersonaRecibe );
        regaloenviado.setIdRegalo (idRegalo );
        return rgenvDAO.update(regaloenviado);
    }

    public boolean delete(int idRegaloEnviado) throws Exception {
        return rgenvDAO.delete(idRegaloEnviado);
    }
    public boolean restore(int idRegaloEnviado) throws Exception {
        return rgenvDAO.restore(idRegaloEnviado);
    }
    
}
