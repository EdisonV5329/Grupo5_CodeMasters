/*
|----------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.             |
| estefano.santacruz@epn.edu.ec   Estefano Santacruz |
|----------------------------------------------------|
Autor: Estefano Santacruz
Fecha: 25.feb.2k24
src: Creacion de la clase relaciontipoBL
*/

package BusinessLogic;

import  java.util.List;

import  DataAccess.RelacionTipoDAO;
import  DataAccess.DTO.RelacionTipoDTO;

public class RelacionTipoBL {
    private RelacionTipoDTO relaciontipo;
    private RelacionTipoDAO rtDAO = new RelacionTipoDAO();

    public RelacionTipoBL(){}

    public List<RelacionTipoDTO> getAll() throws Exception{
        return rtDAO.readAll();
    }

    public RelacionTipoDTO getBy(int idRelacionTipo) throws Exception{
        relaciontipo = rtDAO.readBy(idRelacionTipo);
        return relaciontipo;
    }

    public boolean add(RelacionTipoDTO relaciontipo) throws Exception{
        return rtDAO.create(relaciontipo);
    }

    public boolean update(RelacionTipoDTO relaciontipo) throws Exception{
        return rtDAO.update(relaciontipo);
    }

    public boolean delete(int idRelacionTipo) throws Exception {
        return rtDAO.delete(idRelacionTipo);
    }
    public boolean restore(int idRelacionTipo) throws Exception {
        return rtDAO.restore(idRelacionTipo);
    }
    public Integer getMaxRow() throws Exception{
        return rtDAO.getMaxRow();
    }
    
}
