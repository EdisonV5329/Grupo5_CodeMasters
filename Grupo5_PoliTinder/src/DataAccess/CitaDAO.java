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

import DataAccess.DTO.CitaDTO;

public class CitaDAO extends SQLiteDataHelper implements IDAO<CitaDTO> {
    @Override
    public boolean create(CitaDTO entity) throws Exception {
        String query = "INSERT INTO Cita (IdPersona1, IdPersona2, FechaCita) VALUES (?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersona1());
            pstmt.setInt(2, entity.getIdPersona2());
            pstmt.setString(3, entity.getFechaCita());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CitaDTO> readAll() throws Exception {
        List <CitaDTO> lst = new ArrayList<>();
        String query = " SELECT IdCita      "
                     + " , IdPersona1       "
                     + " , IdPersona2       "
                     + " , FechaCita        "
                     + " , Estado           "
                     + " , FechaCrea        "
                     + " , FechaModifica    "
                     + " FROM Cita          "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                CitaDTO s = new CitaDTO(  rs.getInt(1)       // Id
                                        , rs.getInt(2)       // Persona1       
                                        , rs.getInt(3)       // Persona2       
                                        , rs.getString(4)    // FechaCita       
                                        , rs.getString(5)    // Estado       
                                        , rs.getString(6)    // FechaCrea    
                                        , rs.getString(7));  // FechaModifica
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public CitaDTO readBy (Integer id) throws Exception {
        CitaDTO oS = new CitaDTO();
        String query = " SELECT IdCita     "
                    + " , IdPersona1       "
                    + " , IdPersona2       "
                    + " , FechaCita        "
                    + " , Estado           "
                    + " , FechaCrea        "
                    + " , FechaModifica    "
                    + " FROM Cita          "
                     + " WHERE Estado = 'A' AND IdCita = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                oS = new CitaDTO(  rs.getInt(1)       // Id
                                 , rs.getInt(2)       // Persona1       
                                 , rs.getInt(3)       // Persona2       
                                 , rs.getString(4)    // FechaCita       
                                 , rs.getString(5)    // Estado       
                                 , rs.getString(6)    // FechaCrea    
                                 , rs.getString(7));  // FechaModifica
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(CitaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Cita SET FechaCita = ?, FechaModifica = ? WHERE IdCita = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getFechaCita());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3  , entity.getIdCita());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Cita SET Estado = ? WHERE IdCita = ?";
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
}
