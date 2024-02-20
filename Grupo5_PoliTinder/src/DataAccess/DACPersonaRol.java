package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACPersonaRol extends SQLiteDataHelper {
        public ResultSet getAllPersonaRol () throws Exception {
        String query =      "SELECT IdPersonaRol, Nombre "
                        +   "FROM PersonaRol ";
        try {
            Connection conn = openConnection(); 
            Statement stmt = conn.createStatement();  
            return stmt.executeQuery(query); 
        } catch (Exception e) {
            throw e;
        }
    } 
}
