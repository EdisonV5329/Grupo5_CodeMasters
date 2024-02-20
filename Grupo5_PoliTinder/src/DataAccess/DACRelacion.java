package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACRelacion extends SQLiteDataHelper {
        public ResultSet getAllRelacion () throws Exception {
        String query = "SELECT IdRelacionTipo"
                     + ", IdPersona1"
                     + ", IdPersona2"
                     + ", FechaInicioRelacion "
                     + "FROM Relacion ";
        try {
            Connection conn = openConnection(); 
            Statement stmt = conn.createStatement();  
            return stmt.executeQuery(query);
        } catch (Exception e) {
            throw e;
        }
    } 
}

