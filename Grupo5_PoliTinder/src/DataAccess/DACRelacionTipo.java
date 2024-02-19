package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACRelacionTipo extends SQLiteDataHelper{

    public ResultSet getAllRelacionTipo() throws Exception {
        String query =    " SELECT IdRelacionTipo, Nombre, Estado" 
                        + " FROM RelacionTipo";
        
        
                        // + " WHERE IdRelacionTipo = 1";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            throw e; // new Exception (getClass() + "getMaxIdSexo()", e); 
        }
    }
}
