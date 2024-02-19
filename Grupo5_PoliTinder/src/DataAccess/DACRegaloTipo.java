package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACRegaloTipo extends SQLiteDataHelper{

    public ResultSet getAllRegaloTipo() throws Exception {
        String query =    " SELECT IdRegaloTipo, Nombre, Estado" 
                        + " FROM RegaloTipo";
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
