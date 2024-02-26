/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase CargoBL
*/
package BusinessLogic;

import java.util.List;

import DataAccess.CargoDAO;
import DataAccess.DTO.CargoDTO;

public class CargoBL {
    private CargoDTO  cargoDTO;
    private CargoDAO  cargoDAO = new CargoDAO();

    public CargoBL(){}

    public List<CargoDTO> getAll() throws Exception{
        return cargoDAO.readAll();
    }
    
    public CargoDTO getBy(int idCargo) throws Exception{
        cargoDTO = cargoDAO.readBy(idCargo);
        return cargoDTO;
    }

    public boolean add(String nombre, int idCargoPadre, int idEmpleadoHorario) throws Exception{
        cargoDTO = new CargoDTO();
        cargoDTO.setNombre(nombre);
        cargoDTO.setIdCargoPadre(idCargoPadre);
        cargoDTO.setIdEmpleadoHorario(idEmpleadoHorario);
        return cargoDAO.create(cargoDTO);
    }

    public boolean update(int idCargo, String nombre, int idCargoPadre, int idEmpleadoHorario) throws Exception{
        cargoDTO = new CargoDTO();
        cargoDTO.setNombre(nombre);
        cargoDTO.setIdCargoPadre(idCargoPadre);
        cargoDTO.setIdEmpleadoHorario(idEmpleadoHorario);
        cargoDTO.setIdCargo(idCargo);
        return cargoDAO.update(cargoDTO);
    }

    public boolean delete(int idCargo) throws Exception{
        return cargoDAO.delete(idCargo);
    }
    
    public boolean restore(int idCargo) throws Exception{
        return cargoDAO.restore(idCargo);
    }
}
