/*
|----------------------------------------------------|
| (©) COPYRIGHT (©) 2024 EPN-FIS.                    |
|             Todos los derechos reservados.         | 
| andree.silva@epn.edu.ec   Andree Silva             |
|  © © © © © © © © © © © © © © © © © © © © © © © © © |
|----------------------------------------------------|
Autor: Andree Silva
Fecha: 25.feb.2024
src: Creación de la clase RegaloBL
*/

package BusinessLogic;

import java.util.List;
import DataAccess.RegaloDAO;
import DataAccess.DTO.RegaloDTO;

public class RegaloBL {

    private RegaloDTO regalo;
    private RegaloDAO rgDAO = new RegaloDAO();

    public RegaloBL(){
        
    }

    public List<RegaloDTO> getAll() throws Exception{
        return rgDAO.readAll();
    }

    public RegaloDTO getBy(int idRegalo) throws Exception{
        regalo = rgDAO.readBy(idRegalo);
        return regalo;
    }

    public boolean create(RegaloDTO regaloDTO) throws Exception{
        return rgDAO.create(regaloDTO);
    }

    public boolean update(RegaloDTO regaloDTO) throws Exception{
        return rgDAO.update(regaloDTO);
    }

    public boolean delete(int idRegalo) throws Exception {
        return rgDAO.delete(idRegalo);
    }
    public boolean restore(int idRegalo) throws Exception {
        return rgDAO.restore(idRegalo);
    }
    
    public Integer getMaxRow() throws Exception{
        return rgDAO.getMaxRow();
    }
}
