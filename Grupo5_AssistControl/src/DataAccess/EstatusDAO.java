/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.         |
| francisco.torres@epn.edu.ec   Francisco Torres |
| mateo.simbana@epn.edu.ec   mateitopro          |
|------------------------------------------------|
Autor: Francisco Torres y mateitopro
Fecha: 24.feb.2k24
script: Creacion de la clase EstatusDAO
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

import DataAccess.DTO.EstatusDTO;
import Framework.ASException;

public class EstatusDAO extends SQLiteDataHelper implements IDAO<EstatusDTO> {

    @Override
    public boolean create(EstatusDTO entity) throws Exception {
        String query = "INSERT INTO Estatus (Nombre) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,entity.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new ASException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<EstatusDTO> readAll() throws Exception {
        List<EstatusDTO> list = new ArrayList<>();
        String query = "SELECT IdEstatus, Nombre, Estado, FechaCrea, FechaModifica FROM Estatus";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                EstatusDTO s = new EstatusDTO(rs.getInt(1)
                                                ,rs.getString(2)
                                                ,rs.getString(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                                );
                list.add(s);
            }
        } catch (Exception e) {
            throw new ASException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return list;
    }

    @Override
    public EstatusDTO readBy(Integer id) throws Exception {
        EstatusDTO oS = new EstatusDTO();
        String query = "SELECT IdEstatus, Nombre, Estado, FechaCrea, FechaModifica FROM Estatus WHERE Estado = 'A' AND IdEstatus = "+ id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                oS = new EstatusDTO(rs.getInt(1)
                                                ,rs.getString(2)
                                                ,rs.getString(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                    );
            }
        } catch (Exception e) {
            throw new ASException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public boolean update(EstatusDTO entity) throws Exception {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Estatus SET Nombre = ?, FechaModifica = ? WHERE IdEstatus = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, date.format(now).toString());
            pstmt.setInt(3, entity.getIdEstatus());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new ASException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Estatus SET Estado = ? WHERE IdEstatus = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new ASException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public boolean restore(Integer id) throws Exception {
        String query = "UPDATE Estatus SET Estado = ? WHERE IdEstatus = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "A");
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new ASException(e.getMessage(), getClass().getName(), "restore()");
        }
    }

    public Integer getMaxRow() throws Exception{
        String query = "SELECT COUNT(*) TotalReg FROM Estatus WHERE Estado ='A'";
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
