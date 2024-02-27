/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
Script: Creacion de la clase abstracta SQLiteDataHelper
*/
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database//ASSIST_CONTROL.sqlite"; // no tocar es direccion
    private static Connection conn = null;
    
    protected SQLiteDataHelper(){}

    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(conn  == null) 
                conn = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            throw e; //new Exception(e, "SQLiteDataHelper", "Fallo la conexion a la base de datos");
        }
        return conn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if(conn != null)
            conn.close();conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
}

