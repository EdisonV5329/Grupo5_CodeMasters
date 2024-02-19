package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACRegalo extends SQLiteDataHelper{
    
    public ResultSet getAllRegalo() throws Exception {
        String query =    " SELECT IdRegalo, IdRegaloTipo, Nombre, Estado, Stock, Precio" 
                        + " FROM Regalo";
                        // + " WHERE IdRegaloTipo = 1";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            throw e; // new Exception (getClass() + "getMaxIdSexo()", e); 
        }
    }
}
