/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: Francisco Torres y mateitopro
Fecha: 24.feb.2k24
script: Creacion de la clase EstatusBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.EstatusDAO;
import DataAccess.DTO.EstatusDTO;

public class EstatusBL {
    private EstatusDTO estatus;
    private EstatusDAO eDAO = new EstatusDAO();

    public EstatusBL(){}

    public List<EstatusDTO> getAll() throws Exception{
        return eDAO.readAll();
    }

    public EstatusDTO getBy(int idEstatus) throws Exception{
        estatus = eDAO.readBy(idEstatus);
        return estatus;
    }

    public boolean add(EstatusDTO estatus) throws Exception{
        return eDAO.create(estatus);
    }

    public boolean update(EstatusDTO estatus) throws Exception{
        return eDAO.update(estatus);
    }

    public boolean delete(int idEstatus) throws Exception {
        return eDAO.delete(idEstatus);
    }
    public boolean restore(int idEstatus) throws Exception {
        return eDAO.restore(idEstatus);
    }

    public Integer getMaxRow() throws Exception{
        return eDAO.getMaxRow();
    }
}
