/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase EmpleadoDAO
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
import DataAccess.DTO.EmpleadoDTO;
import Framework.ASException;

public class EmpleadoDAO extends SQLiteDataHelper implements IDAO<EmpleadoDTO> {

    @Override
    public boolean create(EmpleadoDTO entity) throws Exception {
        String query   = "INSERT INTO Empleado (IdCargo, Nombre, Apellido"
                         + ",HuellaDigital, Cedula)"
                         + "VALUES (?, ?, ?, ?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,entity.getIdCargo());
            pstmt.setString(2,entity.getNombre());
            pstmt.setString(3,entity.getApellido());
            pstmt.setString(4,entity.getHuellaDigital());
            pstmt.setString(5,entity.getCedula());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<EmpleadoDTO> readAll() throws Exception {
        List <EmpleadoDTO> lst = new ArrayList<>();
        String query =    " SELECT IdEmpleado "
                        + " ,IdCargo         "
                        + " ,Nombre          "
                        + " ,Apellido        "
                        + " ,Cedula          "
                        + " ,HuellaDigital   "
                        + " ,Estado          "
                        + " ,FechaCrea       "
                        + " ,FechaModifica   "
                        + " FROM   Empleado";
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EmpleadoDTO s = new EmpleadoDTO( rs.getInt(1)
                                                ,rs.getInt(2)
                                                ,rs.getString(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                                ,rs.getString(6)
                                                ,rs.getString(7)
                                                ,rs.getString(8)
                                                ,rs.getString(9));
                lst.add(s);
            }
        } 
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public EmpleadoDTO readBy(Integer id) throws Exception {
        EmpleadoDTO oS = new EmpleadoDTO();
        String query =    " SELECT IdEmpleado "
                        + " ,IdCargo         "
                        + " ,Nombre          "
                        + " ,Apellido        "
                        + " ,Cedula          "
                        + " ,HuellaDigital   "
                        + " ,Estado          "
                        + " ,FechaCrea       "
                        + " ,FechaModifica   "
                        + " FROM   Empleado";
                        // + " WHERE IdEmpleado = " + id.toString();
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new EmpleadoDTO( rs.getInt(1)
                                     ,rs.getInt(2)
                                     ,rs.getString(3)
                                     ,rs.getString(4)
                                     ,rs.getString(5)
                                     ,rs.getString(6)
                                     ,rs.getString(7)
                                     ,rs.getString(8)
                                     ,rs.getString(9));            
            }
        } 
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public boolean update(EmpleadoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Empleado SET Nombre = ?, Apellido = ?, IdCargo = ?, FechaModifica = ?"
                       + "WHERE IdEmpleado = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setInt(3, entity.getIdCargo());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdEmpleado());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE Empleado SET Estado = ? WHERE IdEmpleado = ?";
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
        String  query = "UPDATE Empleado SET Estado = ? WHERE IdEmpleado = ?";
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

    public Integer getMaxIdEmpleado() throws Exception {
        String query =" SELECT COUNT(*) TotalEmpleado FROM Empleado "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } catch (SQLException e) {
            throw new ASException(e.getMessage(), getClass().getName(), "getMaxIdEmpleado()");
            
        }
        return 0;
    }
}