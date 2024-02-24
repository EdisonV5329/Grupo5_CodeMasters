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

    public boolean add(String nombre, int idCargoPadre) throws Exception{
        cargoDTO = new CargoDTO();
        cargoDTO.setNombre(nombre);
        cargoDTO.setIdCargoPadre(idCargoPadre);
        return cargoDAO.create(cargoDTO);
    }

    public boolean update(int idCargo, String nombre, int idCargoPadre) throws Exception{
        cargoDTO = new CargoDTO();
        cargoDTO.setNombre(nombre);
        cargoDTO.setIdCargoPadre(idCargoPadre);
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
