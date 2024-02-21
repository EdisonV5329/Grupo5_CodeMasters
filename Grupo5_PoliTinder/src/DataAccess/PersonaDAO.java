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

import DataAccess.DTO.PersonaDTO;

public class PersonaDAO extends SQLiteDataHelper implements IDAO<PersonaDTO> {

    @Override
    public boolean create(PersonaDTO entity) throws Exception {
        String query   = "INSERT INTO Persona (Nombre, IdPersonaRol, IdPersonaSexo, Cedula) VALUES (?, ?, ?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.setInt(2,entity.getIdPersonaRol());
            pstmt.setInt(3,entity.getIdPersonaSexo());
            pstmt.setString(4,entity.getCedula());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw e;
        }
    }

    @Override
    public List<PersonaDTO> readAll() throws Exception {
        List <PersonaDTO> lst = new ArrayList<>();
        String query =    " SELECT IdPersona"
                        + " ,IdPersonaRol     "
                        + " ,IdPersonaSexo    "
                        + " ,Cedula           "
                        + " ,Nombre           "
                        + " ,Estado           "
                        + " ,FechaCrea        "
                        + " ,FechaModifica    "
                        + " FROM   Persona"
                        + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                PersonaDTO s = new PersonaDTO(  rs.getInt(1)
                                                ,rs.getInt(2)
                                                ,rs.getInt(3)
                                                ,rs.getString(4)
                                                ,rs.getString(5)
                                                ,rs.getString(6)
                                                ,rs.getString(7)
                                                ,rs.getString(8));
                lst.add(s);
            }
        } 
        catch(SQLException e){
            throw e;
        }
        return lst;
    }

    @Override
    public PersonaDTO readBy(Integer id) throws Exception {
        PersonaDTO oS = new PersonaDTO();
        String query =    " SELECT IdPersona"
                        + " ,IdPersonaRol     "
                        + " ,IdPersonaSexo    "
                        + " ,Cedula           "
                        + " ,Nombre           "
                        + " ,Estado           "
                        + " ,FechaCrea        "
                        + " ,FechaModifica    "
                        + " FROM   Persona"
                        + " WHERE  Estado = 'A' AND  IdPersona = " + id.toString();
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new PersonaDTO( rs.getInt(1)
                                    ,rs.getInt(2)
                                    ,rs.getInt(3)
                                    ,rs.getString(4)
                                    ,rs.getString(5)
                                    ,rs.getString(6)
                                    ,rs.getString(7)
                                    ,rs.getString(8));
            }
        } 
        catch(SQLException e){
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(PersonaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Persona SET Nombre = ?, FechaModifica = ?, IdPersonaRol = ?, IdPersonaSexo = ?" 
                        + "WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdPersonaRol());
            pstmt.setInt(4, entity.getIdPersonaSexo());
            pstmt.setInt(5, entity.getIdPersona());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE Persona SET Estado = ? WHERE IdPersona = ?";
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
        String  query = "UPDATE Persona SET Estado = ? WHERE IdPersona = ?";
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
