package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DACPersonaSexo extends SQLiteDataHelper {
    public ResultSet getAllSexo () throws Exception {
        String query =      "SELECT IdPersonaSexo, Nombre "
                        +   "FROM Sexo ";
                        // +   "WHERE IdPersonaSexo = 1"; 
        try {
            Connection conn = openConnection(); // jdbc:sqlite:data\\basedeDatos.db
            Statement stmt = conn.createStatement();  // CRUD: Select *
            return stmt.executeQuery(query); // Resultado
        } catch (Exception e) {
            throw e;
        }
    } 
}
