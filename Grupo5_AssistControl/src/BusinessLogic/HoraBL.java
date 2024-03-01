/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: MATHEUSX y mateitopro
Fecha: 25.feb.2k24
script: Creacion de la clase HoraBL
versión: 1.0
---------------------------------------*/
package BusinessLogic;

import java.util.List;

import DataAccess.HoraDAO;
import DataAccess.DTO.HoraDTO;

public class HoraBL {
    private HoraDTO horaDTO;
    private HoraDAO horaDAO = new HoraDAO();

    public HoraBL(){}

    public List<HoraDTO> getAll() throws Exception{
        return horaDAO.readAll();
    }

    public HoraDTO getBy(int idHora) throws Exception{
        horaDTO = horaDAO.readBy(idHora);
        return horaDTO;
    }

    public boolean add(HoraDTO horaDTO) throws Exception{
        return horaDAO.create(horaDTO);
    }

    public boolean update(HoraDTO horaDTO) throws Exception{
        return horaDAO.update(horaDTO);
    }

    public boolean delete(int idHora) throws Exception{
        return horaDAO.delete(idHora);
    }

    public boolean restore(int idHora) throws Exception{
        return horaDAO.restore(idHora);
    }

    public Integer getMaxRow() throws Exception{
        return horaDAO.getMaxRow();
    }
    
}
