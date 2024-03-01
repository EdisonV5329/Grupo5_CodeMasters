/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: MATHEUSX y mateitopro
Fecha: 25.feb.2k24
script: Creacion de la clase DiaTrabajoBL
versión: 1.0
---------------------------------------*/
package BusinessLogic;

import java.util.List;

import DataAccess.DiaTrabajoDAO;
import DataAccess.DTO.DiaTrabajoDTO;

public class DiaTrabajoBL {
    private DiaTrabajoDTO diaTrabajoDTO;
    private DiaTrabajoDAO diaTrabajoDAO = new DiaTrabajoDAO();

    public DiaTrabajoBL(){}

    public List<DiaTrabajoDTO> getAll() throws Exception{
        return diaTrabajoDAO.readAll();
    }

    public DiaTrabajoDTO getBy(int idDiaTrabajo) throws Exception{
        diaTrabajoDTO = diaTrabajoDAO.readBy(idDiaTrabajo);
        return diaTrabajoDTO;
    }

    public boolean add(DiaTrabajoDTO diaTrabajoDTO) throws Exception{
        return diaTrabajoDAO.create(diaTrabajoDTO);
    }

    public boolean update(DiaTrabajoDTO diaTrabajoDTO) throws Exception{
        return diaTrabajoDAO.update(diaTrabajoDTO);
    }

    public boolean delete(int idDiaTrabajo) throws Exception{
        return diaTrabajoDAO.delete(idDiaTrabajo);
    }

    public boolean restore(int idDiaTrabajo) throws Exception{
        return diaTrabajoDAO.restore(idDiaTrabajo);
    }
    
    public Integer getMaxRow() throws Exception{
        return diaTrabajoDAO.getMaxRow();
    }
}
