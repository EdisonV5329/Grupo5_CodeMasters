/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 25.feb.2k24
src: Creacion de la clase EmpleadoHorarioDAO
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

import DataAccess.DTO.EmpleadoHorarioDTO;
import Framework.ASException;

public class EmpleadoHorarioDAO extends SQLiteDataHelper implements IDAO<EmpleadoHorarioDTO> {

    @Override
    public boolean create(EmpleadoHorarioDTO entity) throws Exception {
        String query = "INSERT INTO EmpleadoHorario (IdDiaTrabajo, IdHoraAmEntrada, IdHoraAmSalida, "
                       + "IdHoraPmEntrada, IdHoraPmSalida) VALUES (?, ?, ?, ?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,entity.getIdDiaTrabajo());
            pstmt.setInt(2,entity.getIdHoraAmEntrada());
            pstmt.setInt(3,entity.getIdHoraAmSalida());
            pstmt.setInt(4,entity.getIdHoraPmEntrada());
            pstmt.setInt(5,entity.getIdHoraPmSalida());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw new ASException(e.getMessage(), getClass().getName(), "create()");
            }
    }

    @Override
    public List<EmpleadoHorarioDTO> readAll() throws Exception {
        List <EmpleadoHorarioDTO> lst = new ArrayList<>();
        String query =    " SELECT IdEmpleadoHorario "
                        + ",IdDiaTrabajo        "
                        + ",IdHoraAmEntrada   "
                        + ",IdHoraAmSalida    "
                        + ",IdHoraPmEntrada   "
                        + ",IdHoraPmSalida    "
                        + ",Estado            "
                        + ",FechaCrea         "
                        + ",FechaModifica     "
                        + " FROM EmpleadoHorario";
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EmpleadoHorarioDTO s = new EmpleadoHorarioDTO(rs.getInt(1)
                                                              ,rs.getInt(2)
                                                              ,rs.getInt(3)
                                                              ,rs.getInt(4)
                                                              ,rs.getInt(5)
                                                              ,rs.getInt(6)
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
    public EmpleadoHorarioDTO readBy(Integer id) throws Exception {
        EmpleadoHorarioDTO oS = new EmpleadoHorarioDTO();
        String query =    " SELECT IdEmpleadoHorario "
                        + ",IdDiaTrabajo        "
                        + ",IdHoraAmEntrada   "
                        + ",IdHoraAmSalida    "
                        + ",IdHoraPmEntrada   "
                        + ",IdHoraPmSalida    "
                        + ",Estado            "
                        + ",FechaCrea         "
                        + ",FechaModifica     "
                        + " FROM EmpleadoHorario";
                        // + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new EmpleadoHorarioDTO(rs.getInt(1)
                                            ,rs.getInt(2)
                                            ,rs.getInt(3)
                                            ,rs.getInt(4)
                                            ,rs.getInt(5)
                                            ,rs.getInt(6)
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
    public boolean update(EmpleadoHorarioDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Cargo SET IdDiaTrabajo = ?, IdHoraAmEntrada = ?, IdHoraAmSalida = ?," 
                       + "IdHoraPmEntrada = ?, IdHoraPmSalida = ?, FechaModifica = ? WHERE IdEmpleadoHorario = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdDiaTrabajo());
            pstmt.setInt(2, entity.getIdHoraAmEntrada());
            pstmt.setInt(3, entity.getIdHoraAmSalida());
            pstmt.setInt(4, entity.getIdHoraPmEntrada());
            pstmt.setInt(5, entity.getIdHoraPmSalida());
            pstmt.setString(6, dtf.format(now).toString());
            pstmt.setInt(7, entity.getIdEmpleadoHorario());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw new ASException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE EmpleadoHorario SET Estado = ? WHERE IdEmpleadoHorario = ?";
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
        String  query = "UPDATE EmpleadoHorario SET Estado = ? WHERE IdEmpleadoHorario = ?";
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
    
}
