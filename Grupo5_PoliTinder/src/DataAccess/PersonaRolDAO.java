/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la clase PersonaRolDAO
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

import DataAccess.DTO.PersonaRolDTO;

public class PersonaRolDAO extends SQLiteDataHelper implements IDAO<PersonaRolDTO>{
    @Override
    public boolean create(PersonaRolDTO entity) throws Exception {
        String query = "INSERT INTO PersonaRol (IdPersonaRol_Padre, Nombre) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonaRol_Padre());
            pstmt.setString(2, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<PersonaRolDTO> readAll() throws Exception {
        List <PersonaRolDTO> lst = new ArrayList<>();
        String query = " SELECT IdPersonaRol  "
                     + " , IdPersonaRol_Padre "
                     + " , Nombre             "
                     + " , Estado             "
                     + " , FechaCrea          "
                     + " , FechaModifica      "
                     + " FROM PersonaRol      ";
                    //  + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                PersonaRolDTO s = new PersonaRolDTO(  rs.getInt(1)       // Id
                                        , rs.getInt(2)                   // IdPersonaRol_Padre      
                                        , rs.getString(3)                // Nombre       
                                        , rs.getString(4)                // Estado       
                                        , rs.getString(5)                // FechaCrea    
                                        , rs.getString(6));              // FechaModifica
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public PersonaRolDTO readBy (Integer id) throws Exception {
        PersonaRolDTO oS = new PersonaRolDTO();
        String query = " SELECT IdPersonaRol  "
                     + " , IdPersonaRol_Padre "
                     + " , Nombre             "
                     + " , Estado             "
                     + " , FechaCrea          "
                     + " , FechaModifica      "
                     + " FROM PersonaRol      "
                    //  + " WHERE Estado = 'A'   "
                     + " WHERE IdPersonaRol = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                oS = new PersonaRolDTO(  rs.getInt(1)        // Id
                                        , rs.getInt(2)       // IdPersonaRol_Padre       
                                        , rs.getString(3)    // Nombre       
                                        , rs.getString(4)    // Estado       
                                        , rs.getString(5)    // FechaCrea    
                                        , rs.getString(6));  // FechaModifica
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(PersonaRolDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE PersonaRol SET Nombre = ?, IdPersonaRol_Padre =?, FechaModifica = ? WHERE IdPersonaRol = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getIdPersonaRol_Padre());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(3  , entity.getIdPersonaRol());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE PersonaRol SET Estado = ? WHERE IdPersonaRol = ?";
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
        String  query = "UPDATE PersonaRol SET Estado = ? WHERE IdPersonaRol = ?";
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

    public Integer getMaxIdPersonaRol() throws Exception {
        String query =" SELECT COUNT(*) TotalPersonaRol FROM PersonaRol "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } catch (SQLException e) {
            throw e;
            // throw new e Exception(e.getMessage(), getClass().getName(), "getCountOfEstadoA()");
        }
        return 0;
    }
}
