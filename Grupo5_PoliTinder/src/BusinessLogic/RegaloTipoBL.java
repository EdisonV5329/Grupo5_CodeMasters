/*
|----------------------------------------------------|
| (©) COPYRIGHT (©) 2024 EPN-FIS.                    |
|             Todos los derechos reservados.         | 
| andree.silva@epn.edu.ec   Andree Silva             |
|  © © © © © © © © © © © © © © © © © © © © © © © © © |
|----------------------------------------------------|
Autor: Andree Silva
Fecha: 25.feb.2024
src: Creación de la clase RegaloTipoBL
*/


package BusinessLogic;

import java.util.List;
import DataAccess.RegaloTipoDAO;
import DataAccess.DTO.RegaloTipoDTO;

public class RegaloTipoBL {

    private RegaloTipoDTO regalotipo;
    private RegaloTipoDAO rgtipoDAO = new RegaloTipoDAO();

    public RegaloTipoBL(){
        
    }

    public List<RegaloTipoDTO> getAll() throws Exception{
        return rgtipoDAO.readAll();
    }

    public RegaloTipoDTO getBy(int idRegaloTipo) throws Exception{
        regalotipo = rgtipoDAO.readBy(idRegaloTipo);
        return regalotipo;
    }

    public boolean add(String Nombre) throws Exception{
        regalotipo = new RegaloTipoDTO();
        regalotipo.setNombre(Nombre);
        return rgtipoDAO.create(regalotipo);
    }

    public boolean update(int idRegaloTipo, String Nombre) throws Exception{
        regalotipo = new RegaloTipoDTO();
        regalotipo.setIdRegaloTipo(idRegaloTipo);
        regalotipo.setNombre(Nombre);
        return rgtipoDAO.update(regalotipo);
    }

    public boolean delete(int idRegaloTipo) throws Exception {
        return rgtipoDAO.delete(idRegaloTipo);
    }
    public boolean restore(int idRegaloTipo) throws Exception {
        return rgtipoDAO.restore(idRegaloTipo);
    }
    
}
