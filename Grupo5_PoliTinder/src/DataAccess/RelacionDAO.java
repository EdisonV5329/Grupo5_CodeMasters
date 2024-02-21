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

import DataAccess.DTO.RelacionDTO;

public class RelacionDAO extends SQLiteDataHelper implements IDAO<RelacionDTO> {
    @Override
    public boolean create(RelacionDTO entity) throws Exception {
        String query = "INSERT INTO PersonaSexo (IdRelacionTipo, IdPersona1, IdPersona2, FechaInicioRelacion) VALUES (?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdRelacionTipo());
            pstmt.setInt(2, entity.getIdPersona1());
            pstmt.setInt(3, entity.getIdPersona2());
            pstmt.setString(4, entity.getFechaInicioRelacion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<RelacionDTO> readAll() throws Exception {
        List <RelacionDTO> lst = new ArrayList<>();
        String query = " SELECT IdRelacion     "
                     + " , IdRelacionTipo      "
                     + " , IdPersona1          "
                     + " , IdPersona2          "
                     + " , FechaInicioRelacion "
                     + " , Estado              "
                     + " , FechaCrea           "
                     + " , FechaModifica       "
                     + " FROM Relacion         "
                     + " WHERE Estado = 'A'    ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                RelacionDTO s = new RelacionDTO(  rs.getInt(1)   // Id
                                        , rs.getInt(2)          // IdRelacionTipo       
                                        , rs.getInt(3)          // IdPersona1       
                                        , rs.getInt(4)          // IdPersona2       
                                        , rs.getString(5)       // FechaInicioRelacion       
                                        , rs.getString(6)       // Estado    
                                        , rs.getString(7)       // FechaCrea    
                                        , rs.getString(8));     // FechaModifica
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public RelacionDTO readBy (Integer id) throws Exception {
        RelacionDTO oS = new RelacionDTO();
        String query = " SELECT IdRelacion     "
                     + " , IdRelacionTipo      "
                     + " , IdPersona1          "
                     + " , IdPersona2          "
                     + " , FechaInicioRelacion "
                     + " , Estado              "
                     + " , FechaCrea           "
                     + " , FechaModifica       "
                     + " FROM Relacion         "
                     + " WHERE Estado = 'A' AND IdRelacion = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                 oS = new RelacionDTO(  rs.getInt(1) // Id
                            , rs.getInt(2)           // IdRelacionTipo       
                            , rs.getInt(3)           // IdPersona1       
                            , rs.getInt(4)           // IdPersona2       
                            , rs.getString(5)        // FechaInicioRelacion       
                            , rs.getString(6)        // Estado    
                            , rs.getString(7)        // FechaCrea    
                            , rs.getString(8));      // FechaModifica
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(RelacionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Relacion SET IdRelacionTipo = ?, FechaInicioRelacion = ?, FechaModifica = ? WHERE IdPersonaSexo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdRelacionTipo());
            pstmt.setString(2, entity.getFechaInicioRelacion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdRelacion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Relacion SET Estado = ? WHERE IdRelacion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean restore(Integer id) throws Exception{
        String  query = "UPDATE Relacion SET Estado = ? WHERE IdRelacion = ?";
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
