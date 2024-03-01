/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: MATHEUSX y mateitopro
Fecha: 25.feb.2k24
script: Creacion de la clase HoraDAO
versión: 1.0
---------------------------------------*/
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

import DataAccess.DTO.HoraDTO;
import Framework.ASException;

public class HoraDAO extends SQLiteDataHelper implements IDAO<HoraDTO>{
    
    @Override
    public boolean create(HoraDTO entity) throws Exception {
        String query   = "INSERT INTO Hora (Nombre) VALUES (?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "create()");
            }    
    }

     @Override
    public List<HoraDTO> readAll() throws Exception {
        List <HoraDTO> lst = new ArrayList<>();
        String query =    " SELECT IdHora "
                        + ",Nombre          "
                        + ",Estado          "
                        + ",FechaCrea       "
                        + ",FechaModifica   "
                        + " FROM   Hora";
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                HoraDTO s = new HoraDTO( rs.getInt(1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5));
                lst.add(s);
            }
        }
            catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "readAll()");
        }
            return lst;
        
    }

    @Override
    public HoraDTO readBy (Integer id) throws Exception{
        HoraDTO oS = new HoraDTO();
        String query = " SELECT IdHora"
                        + ",Nombre          "
                        + ",Estado          "
                        + ",FechaCrea       "
                        + ",FechaModifica   "
                        + " FROM   Hora"
                        + " WHERE  IdHora = " + id.toString();
    try{
        Connection conn = openConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            oS = new HoraDTO( rs.getInt(1)
                            ,rs.getString(2)
                            ,rs.getString(3)
                            ,rs.getString(4)
                            ,rs.getString(5));
        }
    }
    catch (SQLException e){ 
        throw new ASException(e.getMessage(), getClass().getName(), "readBy()");

    }
    return oS;
    }

    @Override
    public boolean update(HoraDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Hora SET "
                       +" Nombre = ?" 
                       +", FechaModifica = ?"
                       +" WHERE IdHora = ?;";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.setString(2,dtf.format(now));
            pstmt.setInt(3,entity.getIdHora());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "update()");
            }    
    }
    
    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Hora SET Estado = ? WHERE IdHora = ?;";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "delete()");
            }    
    }

    @Override
    public boolean restore(Integer id) throws Exception {
        String query = "UPDATE Hora SET Estado = ? WHERE IdHora = ?;";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "A");
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "restore()");
            }    
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM Hora "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new ASException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}

