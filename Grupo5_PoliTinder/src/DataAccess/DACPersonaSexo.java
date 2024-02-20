package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACPersonaSexo extends SQLiteDataHelper {
    public ResultSet getAllPersonaSexo () throws Exception {
        String query =      "SELECT IdPersonaSexo, Nombre "
                        +   "FROM PersonaSexo ";
        try {
            Connection conn = openConnection(); 
            Statement stmt = conn.createStatement();  
            return stmt.executeQuery(query);
        } catch (Exception e) {
            throw e;
        }
    } 
}
