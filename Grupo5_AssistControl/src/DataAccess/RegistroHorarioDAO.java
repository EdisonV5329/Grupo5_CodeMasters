/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 24.feb.2k24
script: Creacion de la clase RegistroHorarioDAO
*/
package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.RegistroHorarioDTO;

public class RegistroHorarioDAO extends SQLiteDataHelper {

    public RegistroHorarioDTO readByIdEmpleado(Integer idEmpleado) throws Exception {
        RegistroHorarioDTO oR = new RegistroHorarioDTO();
        String query =
        " SELECT rh.IdRegistroHorario IdRegistroHorario"
            + ", em.Nombre Nombre"
            + ", rh.HoraAmEntrada HoraAmEntrada" 
            + ", rh.HoraAmSalida HoraAmSalida" 
            + ", rh.HoraPmEntrada HoraPmEntrada" 
            + ", rh.HoraPmSalida HoraPmSalida" 
            + ", es.Nombre Estatus"
            + ", rh.FechaCrea Fecha"
        +" FROM RegistroHorario               rh "
        +" JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado "
        +" JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus "
        +" WHERE   rh.Estado = 'A' "
        +" AND     em.Estado = 'A' "
        +" AND     es.Estado = 'A' "
        +" AND     em.IdEmpleado = " + idEmpleado.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oR = new RegistroHorarioDTO(rs.getInt(1)              // IdRegistroHorario
                                           ,rs.getString(2)            // Nombre     
                                           ,rs.getString(3)            // HoraAmEntrada             
                                           ,rs.getString(4)            // HoraAmSalida         
                                           ,rs.getString(5)            // HoraPmEntrada             
                                           ,rs.getString(6)            // HoraPmSalida            
                                           ,rs.getString(7)            // Estatus           
                                           ,rs.getString(8) );         // Fecha        
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return oR;
    }

    public List<RegistroHorarioDTO> readAll() throws Exception {
        List <RegistroHorarioDTO> lst = new ArrayList<>();
        String query =
        " SELECT rh.IdRegistroHorario IdRegistroHorario"
            + ", em.Nombre Nombre"
            + ", rh.HoraAmEntrada HoraAmEntrada" 
            + ", rh.HoraAmSalida HoraAmSalida" 
            + ", rh.HoraPmEntrada HoraPmEntrada" 
            + ", rh.HoraPmSalida HoraPmSalida" 
            + ", es.Nombre Estatus"
            + ", rh.FechaCrea Fecha"
       +" FROM RegistroHorario               rh "
       +" JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado "
       +" JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus "
       +" WHERE   rh.Estado = 'A' "
       +" AND     em.Estado = 'A' "
       +" AND     es.Estado = 'A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                RegistroHorarioDTO r = new RegistroHorarioDTO(rs.getInt(1)              // IdRegistroHorario
                                                            ,rs.getString(2)            // Nombre     
                                                            ,rs.getString(3)            // HoraAmEntrada             
                                                            ,rs.getString(4)            // HoraAmSalida         
                                                            ,rs.getString(5)            // HoraPmEntrada             
                                                            ,rs.getString(6)            // HoraPmSalida            
                                                            ,rs.getString(7)            // Estatus           
                                                            ,rs.getString(8) );         // Fecha
                lst.add(r);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }

    public List<RegistroHorarioDTO> readAllEstructura(String tipo)  throws Exception {
        List <RegistroHorarioDTO> lst = new ArrayList<>();
        String query =
        " SELECT rh.IdRegistroHorario IdRegistroHorario"
            + ", em.Nombre Nombre"
            + ", rh.HoraAmEntrada HoraAmEntrada" 
            + ", rh.HoraAmSalida HoraAmSalida" 
            + ", rh.HoraPmEntrada HoraPmEntrada" 
            + ", rh.HoraPmSalida HoraPmSalida" 
            + ", es.Nombre Estatus"
            + ", rh.FechaCrea Fecha"
       +" FROM RegistroHorario               rh "
       +" JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado "
       +" JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus "
       +" WHERE   rh.Estado = 'A' "
       +" AND     em.Estado = 'A' "
       +" AND     es.Estado = 'A' "
       +" AND     lower(es.Nombre) = " + ((tipo.equals("A tiempo"))
                                        ? "'A tiempo'".toLowerCase() 
                                        : "'Atrasado'".toLowerCase());
        System.out.println(query);                                    
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                RegistroHorarioDTO r = new RegistroHorarioDTO(rs.getInt(1)              // IdRegistroHorario
                                                            ,rs.getString(2)            // Nombre     
                                                            ,rs.getString(3)            // HoraAmEntrada             
                                                            ,rs.getString(4)            // HoraAmSalida         
                                                            ,rs.getString(5)            // HoraPmEntrada             
                                                            ,rs.getString(6)            // HoraPmSalida            
                                                            ,rs.getString(7)            // Estatus           
                                                            ,rs.getString(8) );         // Fecha
                lst.add(r);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT (*) TotalRegistroHorario "
                     +" FROM RegistroHorario "
                     +" WHERE   Estado = 'A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalRegistroHorario
            }
        } 
        catch (SQLException e) {
            throw e; // throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

}
