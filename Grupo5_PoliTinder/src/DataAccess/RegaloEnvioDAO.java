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

import DataAccess.DTO.RegaloEnvioDTO;

public class RegaloEnvioDAO extends SQLiteDataHelper implements IDAO<RegaloEnvioDTO> {

    @Override
    public boolean create(RegaloEnvioDTO entity) throws Exception {
        String query   = "INSERT INTO RegaloEnvio (IdPersonaEnvia, IdPersonaRecibe, IdRegalo) VALUES(?,?,?)"; 
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,entity.getIdPersonaEnvia());
            pstmt.setInt(2,entity.getIdPersonaRecibe());
            pstmt.setInt(3,entity.getIdRegalo());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw e;// throw new Exception("Error al insertar el sexo en la base de datos");
        }
    }

    @Override
    public List<RegaloEnvioDTO> readAll() throws Exception {
        List <RegaloEnvioDTO> lst = new ArrayList<>();
        String query =    " SELECT IdRegaloEnvio "
                        + ",IdPersonaEnvia      "
                        + ",IdPersonaRecibe     "
                        + ",IdRegalo            "
                        + ",Estado              "
                        + ",FechaCrea           "
                        + ",FechaModifica       "
                        + " FROM   RegaloEnvio"
                        + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                RegaloEnvioDTO s = new RegaloEnvioDTO( rs.getInt(1)
                                                      ,rs.getInt(2)
                                                      ,rs.getInt(3)
                                                      ,rs.getInt(4)
                                                      ,rs.getString(5)
                                                      ,rs.getString(6)
                                                      ,rs.getString(7));
                lst.add(s);
            }
        } 
        catch(SQLException e){
            throw e;
        }
        return lst;
    }

    @Override
    public RegaloEnvioDTO readBy(Integer id) throws Exception {
        RegaloEnvioDTO oS = new RegaloEnvioDTO();
        String query =    " SELECT IdRegaloEnvio "
                        + ",IdPersonaEnvia      "
                        + ",IdPersonaRecibe     "
                        + ",IdRegalo            "
                        + ",Estado              "
                        + ",FechaCrea           "
                        + ",FechaModifica       "
                        + " FROM   RegaloEnvio"
                        + " WHERE  Estado = 'A' AND  IdRegaloEnvio = " + id.toString();
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new RegaloEnvioDTO( rs.getInt(1)
                                        ,rs.getInt(2)
                                        ,rs.getInt(3)
                                        ,rs.getInt(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7));
            }
        } 
        catch(SQLException e){
            throw e;
        }
        return oS;    
    }

    @Override
    public boolean update(RegaloEnvioDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE RegaloEnvio SET IdPersonaEnvia = ?, IdPersonaRecibe = ?, IdRegalo = ?, FechaModifica = ?"
                        + "WHERE IdRegaloEnvio = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonaEnvia());
            pstmt.setInt(2, entity.getIdPersonaRecibe());
            pstmt.setInt(3, entity.getIdRegalo());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdRegaloEnvio());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE RegaloEnvio SET Estado = ? WHERE IdRegaloEnvio = ?";
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
        String  query = "UPDATE RegaloEnvio SET Estado = ? WHERE IdRegaloEnvio = ?";
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
