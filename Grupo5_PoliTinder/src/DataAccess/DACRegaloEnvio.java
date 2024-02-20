package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACRegaloEnvio extends SQLiteDataHelper {
    
    public ResultSet getAllRegaloEnvio() throws Exception {
        String query =    " SELECT IdRegaloEnvio, IdPersonaEnvia, IdPersonaRecibe, IdRegalo, Estado" 
                        + " FROM RegaloEnvio";
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
