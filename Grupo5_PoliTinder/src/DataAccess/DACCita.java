package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACCita extends SQLiteDataHelper {
    public ResultSet getAllCita () throws Exception {
        String query = "SELECT IdCita"
                     + ", IdPersona1"
                     + ", IdPerson2"
                     + ", FechaCita "
                     +   "FROM Cita ";
        try {
            Connection conn = openConnection(); 
            Statement stmt = conn.createStatement();  
            return stmt.executeQuery(query);
        } catch (Exception e) {
            throw e;
        }
    } 
}
