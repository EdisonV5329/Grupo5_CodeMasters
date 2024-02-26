/*
|----------------------------------------------------|
| (©) COPYRIGHT (©) 2024 EPN-FIS.                    |
|             Todos los derechos reservados.         | 
| andree.silva@epn.edu.ec   Andree Silva             |
|  © © © © © © © © © © © © © © © © © © © © © © © © © |
|----------------------------------------------------|
Autor: Andree Silva
Fecha: 25.feb.2024
src: Creación de la clase RelacionBL
*/

package BusinessLogic;


import java.util.List;
import DataAccess.RelacionDAO;
import DataAccess.DTO.RelacionDTO;

public class RelacionBL {
    
 private RelacionDTO relacion;
    private RelacionDAO relDAO = new RelacionDAO();

    public RelacionBL(){
        
    }

    public List<RelacionDTO> getAll() throws Exception{
        return relDAO.readAll();
    }

    public RelacionDTO getBy(int idRelacion) throws Exception{
        relacion = relDAO.readBy(idRelacion);
        return relacion;
    }

    public boolean add(String Nombre) throws Exception{
        relacion = new RelacionDTO();
        return relDAO.create(relacion);
    }

    public boolean update(int idRelacion, String Nombre) throws Exception{
        relacion = new RelacionDTO();
        relacion.setIdRelacion(idRelacion);
        return relDAO.update(relacion);
    }

    public boolean delete(int idRelacion) throws Exception {
        return relDAO.delete(idRelacion);
    }
    public boolean restore(int idRelacion) throws Exception {
        return relDAO.restore(idRelacion);
    }


}
