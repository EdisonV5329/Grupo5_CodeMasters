/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase CargoDAO
*/
package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.CargoDTO;
import Framework.ASException;

public class CargoDAO extends SQLiteDataHelper implements IDAO<CargoDTO>{

    @Override
    public boolean create(CargoDTO entity) throws Exception {
        String query   = "INSERT INTO Cargo (IdCargoPadre, IdEmpleadoHorario, Nombre) VALUES (?, ?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,entity.getIdCargoPadre());
            pstmt.setInt(2,entity.getIdEmpleadoHorario());
            pstmt.setString(3,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "create()");
        }    
    }

    @Override
    public List<CargoDTO> readAll() throws Exception {
        List <CargoDTO> lst = new ArrayList<>();
        String query =    " SELECT IdCargo "
                        + ",IdCargoPadre        "
                        + ",IdEmpleadoHorario   "
                        + ",Nombre              "
                        + ",Estado              "
                        + ",FechaCrea           "
                        + ",FechaModifica       "
                        + " FROM   Cargo";
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                CargoDTO s = new CargoDTO( rs.getInt(1)
                                        ,rs.getInt(2)
                                        ,rs.getInt(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7));
                    lst.add(s);
            }
        } 
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public CargoDTO readBy(Integer id) throws Exception {
        CargoDTO oS = new CargoDTO();
        String query =    " SELECT IdCargo "
                        + ",IdCargoPadre        "
                        + ",IdEmpleadoHorario   "
                        + ",Nombre              "
                        + ",Estado              "
                        + ",FechaCrea           "
                        + ",FechaModifica       "
                        + " FROM   Cargo"
                        // + " WHERE  Estado = 'A' " 
                        + " WHERE IdCargo = " + id.toString();
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new CargoDTO(   rs.getInt(1)
                                    ,rs.getInt(2)
                                    ,rs.getInt(3)
                                    ,rs.getString(4)
                                    ,rs.getString(5)
                                    ,rs.getString(6)
                                    ,rs.getString(7));
            }
        } 
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public boolean update(CargoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Cargo SET Nombre = ?, IdCargoPadre = ?, IdEmpleadoHorario = ?," 
                       + "FechaModifica = ? WHERE IdCargo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getIdCargoPadre());
            pstmt.setInt(3, entity.getIdEmpleadoHorario());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdCargo());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE Cargo SET Estado = ? WHERE IdCargo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,"X"); 
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public boolean restore(Integer id) throws Exception {
        String  query = "UPDATE Cargo SET Estado = ? WHERE IdCargo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,"A"); 
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "restore()");
        }
    }
    
    public Integer getMaxRow() throws Exception{
        String query = "SELECT COUNT(*) TotalReg FROM Cargo WHERE Estado ='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
          while (rs.next()) {
                return rs.getInt(1);
          }
        }
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "getMaxRow()");
    }
    return 0;
    }
}
