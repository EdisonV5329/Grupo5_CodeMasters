/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
script: Creacion de la clase DiaTrabajoDAO
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
import DataAccess.DTO.DiaTrabajoDTO;

public class DiaTrabajoDAO extends SQLiteDataHelper implements IDAO<DiaTrabajoDTO>{
    
    @Override
    public boolean create(DiaTrabajoDTO entity) throws Exception {
        String query   = "INSERT INTO DiaTrabajo (Nombre) VALUES (?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw e;
            }    
    }

    @Override
    public List<DiaTrabajoDTO> readAll() throws Exception {
        List <DiaTrabajoDTO> lst = new ArrayList<>();
        String query =    " SELECT IdDiaTrabajo "
                        + ",Nombre          "
                        + ",Estado          "
                        + ",FechaCrea       "
                        + ",FechaModifica   "
                        + " FROM   DiaTrabajo";
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DiaTrabajoDTO s = new DiaTrabajoDTO( rs.getInt(1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5));
                lst.add(s);
            }
        }
            catch (SQLException e){ 
                throw e;
        }
            return lst;
        
    }

    @Override
    public DiaTrabajoDTO readBy (Integer id) throws Exception{
        DiaTrabajoDTO oS = new DiaTrabajoDTO();
        String query = " SELECT IdDiaTrabajo "
                     + ",Nombre          "
                     + ",Estado          "
                     + ",FechaCrea       "
                     + ",FechaModifica   "
                     + " FROM   DiaTrabajo"
                     + " WHERE  IdDiaTrabajo = " + id.toString();
    try{
        Connection conn = openConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            oS = new DiaTrabajoDTO( rs.getInt(1)
                                ,rs.getString(2)
                                ,rs.getString(3)
                                ,rs.getString(4)
                                ,rs.getString(5));
        }
    }
    catch (SQLException e){ 
        throw e;
    }
    return oS;
    }

    @Override
    public boolean update (DiaTrabajoDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
       
        String query = "UPDATE DiaTrabajo SET "
                     + "Nombre = ? "
                     + ",FechaModifica = ? "
                     + " WHERE IdDiaTrabajo = ? ";
        try{
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.setString(2,dtf.format(now).toString());
            pstmt.setInt(3,entity.getIdDiaTrabajo());
            pstmt.executeUpdate();
            return true;
    
    }
    catch (SQLException e){ 
        throw e;
    }

}

@Override
public boolean delete(Integer id) throws Exception {
    String  query = "UPDATE DiaTrabajo SET Estado = ? WHERE IdDiaTrabajo = ?";
    try {
        Connection conn = openConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1,"X"); 
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        return true;
    }
    catch(SQLException e){
        throw e;
    }
}

@Override
public boolean restore(Integer id) throws Exception {
    String  query = "UPDATE DiaTrabajo SET Estado = ? WHERE IdDiaTrabajo = ?";
    try {
        Connection conn = openConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1,"A"); 
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        return true;
    }
    catch(SQLException e){
        throw e;
    }
}

}
