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

import DataAccess.DTO.RegaloDTO;

public class RegaloDAO extends SQLiteDataHelper implements IDAO<RegaloDTO> {

    @Override
    public boolean create(RegaloDTO entity) throws Exception {
        String query   = "INSERT INTO Regalo (Nombre, IdRegaloTipo, Stock, Precio) VALUES (?, ?, ?, ?);";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNombre());
            pstmt.setInt(2,entity.getIdRegaloTipo());
            pstmt.setInt(3, entity.getStock());
            pstmt.setDouble(4, entity.getPrecio());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e){ 
                throw e;
            }
    }

    @Override
    public List<RegaloDTO> readAll() throws Exception {
        List <RegaloDTO> lst = new ArrayList<>();
        String query =    " SELECT IdRegalo "
                        + " ,IdRegaloTipo "
                        + " ,Nombre       "
                        + " ,Estado       "
                        + " ,Stock        "
                        + " ,Precio       "
                        + " ,FechaCrea    "
                        + " ,FechaModifica"
                        + " FROM   Regalo"
                        + " WHERE  Estado = 'A' ";
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                RegaloDTO s = new RegaloDTO( rs.getInt(1)
                                            ,rs.getInt(2)
                                            ,rs.getString(3)
                                            ,rs.getString(4)
                                            ,rs.getInt(5)
                                            ,rs.getDouble(6)
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
    public RegaloDTO readBy(Integer id) throws Exception {
        RegaloDTO oS = new RegaloDTO();
        String query =    " SELECT IdRegalo "
                        + " ,IdRegaloTipo "
                        + " ,Nombre       "
                        + " ,Estado       "
                        + " ,Stock        "
                        + " ,Precio       "
                        + " ,FechaCrea    "
                        + " ,FechaModifica"
                        + " FROM   Regalo"
                        + " WHERE  Estado = 'A' AND IdRegalo = " + id.toString();
        try{
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                oS = new RegaloDTO( rs.getInt(1)
                                    ,rs.getInt(2)
                                    ,rs.getString(3)
                                    ,rs.getString(4)
                                    ,rs.getInt(5)
                                    ,rs.getDouble(6)
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
    public boolean update(RegaloDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Regalo SET Nombre = ?, IdRegaloTipo = ?, Stock = ?, Precio = ?, FechaModifica = ?"
                        + " WHERE IdRegalo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getIdRegaloTipo());
            pstmt.setInt(3, entity.getStock());
            pstmt.setDouble(4, entity.getPrecio());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getIdRegalo());
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException e){
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String  query = "UPDATE Regalo SET Estado = ? WHERE IdRegalo = ?";
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
    public boolean restore(Integer id) throws Exception{
        String  query = "UPDATE Regalo SET Estado = ? WHERE IdRegalo = ?";
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

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalRegalo FROM Regalo "
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
            throw e;
        }
        return 0;
    }    

}
