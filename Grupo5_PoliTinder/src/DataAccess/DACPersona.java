package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACPersona extends SQLiteDataHelper {

    public ResultSet getAllPersona() throws Exception {
        String query =    " SELECT IdPersona, IdPersonaRol, IdPersonaSexo, Cedula, Nombre, Estado" 
                        + " FROM Persona";
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
