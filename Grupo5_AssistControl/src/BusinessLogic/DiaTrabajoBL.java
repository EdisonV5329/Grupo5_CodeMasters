/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
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

    public boolean add(String nombre) throws Exception{
        diaTrabajoDTO = new DiaTrabajoDTO();
        diaTrabajoDTO.setNombre(nombre);
        return diaTrabajoDAO.create(diaTrabajoDTO);
    }

    public boolean update(int idDiaTrabajo, String nombre) throws Exception{
        diaTrabajoDTO = new DiaTrabajoDTO();
        diaTrabajoDTO.setNombre(nombre);
        diaTrabajoDTO.setIdDiaTrabajo(idDiaTrabajo);
        return diaTrabajoDAO.update(diaTrabajoDTO);
    }

    public boolean delete(int idDiaTrabajo) throws Exception{
        return diaTrabajoDAO.delete(idDiaTrabajo);
    }

    public boolean restore(int idDiaTrabajo) throws Exception{
        return diaTrabajoDAO.restore(idDiaTrabajo);
    }
    
}
