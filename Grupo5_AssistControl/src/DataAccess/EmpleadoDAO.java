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

public class EmpleadoDAO extends SQLiteDataHelper implements IDAO<EmpleadoDTO> {

    @Override
    public boolean create(EmpleadoDTO entity) throws Exception {
        String query   = "INSERT INTO Empleado (IdCargo, Nombre, Apellido, HoraAmEntrada"
                         + ", HoraAmSalida, HoraPmEntrada, HoraPmSalida, HuellaDigital, Cedula)"
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,entity.getIdCargo());
            pstmt.setString(2,entity.getNombre());
            pstmt.setString(3,entity.getApellido());
            pstmt.setString(4,entity.getHoraAmEntrada());
            pstmt.setString(5,entity.getHoraAmSalida());
            pstmt.setString(6,entity.getHoraPmEntrada());
            pstmt.setString(7,entity.getHoraPmSalida());
            pstmt.setString(8,entity.getHuellaDigital());
            pstmt.setString(9,entity.getCedula());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw e;// throw new Exception("Error al insertar el sexo en la base de datos");
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
                        + " ,HoraAmEntrada   "
                        + " ,HoraAmSalida    "
                        + " ,HoraPmEntrada   "
                        + " ,HoraPmSalida    "
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
                                                ,rs.getString(9)
                                                ,rs.getString(10)
                                                ,rs.getString(11)
                                                ,rs.getString(12)
                                                ,rs.getString(13));
                    lst.add(s);
            }
        } 
        catch(SQLException e){
            throw e;
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
                        + " ,HoraAmEntrada   "
                        + " ,HoraAmSalida    "
                        + " ,HoraPmEntrada   "
                        + " ,HoraPmSalida    "
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
                                     ,rs.getString(9)
                                     ,rs.getString(10)
                                     ,rs.getString(11)
                                     ,rs.getString(12)
                                     ,rs.getString(13));            
            }
        } 
        catch(SQLException e){
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(EmpleadoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Empleado SET Nombre = ?, Apellido = ?, IdCargo = ?, HoraAmEntrada = ?"
                       + ", HoraAmSalida = ?, HoraPmEntrada = ?, HoraPmSalida = ?, FechaModifica = ?"
                       + "WHERE IdEmpleado = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setInt(3, entity.getIdCargo());
            pstmt.setString(4, entity.getHoraAmEntrada());
            pstmt.setString(5, entity.getHoraAmSalida());
            pstmt.setString(6, entity.getHoraPmEntrada());
            pstmt.setString(7, entity.getHoraPmSalida());
            pstmt.setString(8, dtf.format(now).toString());
            pstmt.setInt(9, entity.getIdEmpleado());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw e;
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
            throw e;
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
            throw e;
        }
    }    
}