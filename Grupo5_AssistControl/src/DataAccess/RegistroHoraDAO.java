/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.        |
| francisco.torres@epn.edu.ec   Francisco Torres |
|------------------------------------------------|
Autor: Francisco Torres
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

import DataAccess.DTO.RegistroHoraDTO;

public class RegistroHoraDAO extends SQLiteDataHelper{

    public List<RegistroHoraDTO> readAll() throws Exception{
        List<RegistroHoraDTO> lst = new ArrayList<>();
        String query =  "SELECT rh.IdRegistroHorario IdRegistroHorario"
                        +", em.Nombre          Nombre"
                        +", rh.HoraAmEntrada   HoraAmEntrada"
                        +", rh.HoraAmSalida    HoraAmSalida"
                        +", rh.HoraPmEntrada   HoraPmEntrada"
                        +", rh.HoraPmSalida    HoraPmSalida"
                        +", es.Nombre          Estatus"
                        +", rh.FechaCrea       Fecha"
                        +" FROM RegistroHorario rh "
                        +" JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado"
                        +" JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus"
                        +" WHERE   rh.Estado = 'A'"
                        +" AND     em.Estado = 'A'"
                        +" AND     es.Estado = 'A'";
        try {
            Connection conn = openConnection();        
            Statement  stmt = conn.createStatement();      
            ResultSet rs   = stmt.executeQuery(query); 
            while (rs.next()) {
                RegistroHoraDTO s = new RegistroHoraDTO(rs.getInt(1)          
                                                            ,rs.getString(2)                  
                                                            ,rs.getString(3)         
                                                            ,rs.getString(4)         
                                                            ,rs.getString(5)         
                                                            ,rs.getString(6)        
                                                            ,rs.getString(7)        
                                                            ,rs.getString(8) );      
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    
        }
        return lst;
    }

    public RegistroHoraDTO readBy(Integer id) throws Exception{
        RegistroHoraDTO rhDTO = new RegistroHoraDTO();
        String query =  "SELECT rh.IdRegistroHorario IdRegistroHorario"
                        +", em.Nombre          Nombre"
                        +", rh.HoraAmEntrada   HoraAmEntrada"
                        +", rh.HoraAmSalida    HoraAmSalida"
                        +", rh.HoraPmEntrada   HoraPmEntrada"
                        +", rh.HoraPmSalida    HoraPmSalida"
                        +", es.Nombre          Estatus"
                        +", rh.FechaCrea       Fecha"
                        +" FROM RegistroHorario rh "
                        +" JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado"
                        +" JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus"
                        +" WHERE   rh.Estado = 'A'"
                        +" AND     em.Estado = 'A'"
                        +" AND     es.Estado = 'A'"
                        +"AND rh.IdRegistroHorario = "+id.toString();
        try {
            Connection conn = openConnection();        
            Statement  stmt = conn.createStatement();      
            ResultSet rs   = stmt.executeQuery(query); 
            while (rs.next()) {
                rhDTO = new RegistroHoraDTO(rs.getInt(1)          
                                                            ,rs.getString(2)                  
                                                            ,rs.getString(3)         
                                                            ,rs.getString(4)         
                                                            ,rs.getString(5)         
                                                            ,rs.getString(6)        
                                                            ,rs.getString(7)        
                                                            ,rs.getString(8) );      
            }
        } 
        catch (SQLException e) {
            throw e;    
        }
        return rhDTO;
    }

    public List<RegistroHoraDTO> readAllEstructura(String estatus) throws Exception {
        List<RegistroHoraDTO> lst = new ArrayList<>();
        String query =  "SELECT rh.IdRegistroHorario IdRegistroHorario"
                        +", em.Nombre          Nombre"
                        +", rh.HoraAmEntrada   HoraAmEntrada"
                        +", rh.HoraAmSalida    HoraAmSalida"
                        +", rh.HoraPmEntrada   HoraPmEntrada"
                        +", rh.HoraPmSalida    HoraPmSalida"
                        +", es.Nombre          Estatus"
                        +", rh.FechaCrea       Fecha"
                        +" FROM RegistroHorario rh "
                        +" JOIN Empleado     em ON em.IdEmpleado = rh.IdEmpleado"
                        +" JOIN Estatus      es ON es.IdEstatus  = rh.IdEstatus"
                        +" WHERE   rh.Estado = 'A'"
                        +" AND     em.Estado = 'A'"
                        +" AND     es.Estado = 'A'"
                        +"AND      lower(es.Nombre) = "+ ((estatus.equalsIgnoreCase("A Tiempo"))
                                                        ?"'A Tiempo'".toLowerCase()
                                                        :(estatus.equalsIgnoreCase("Atrasado"))
                                                        ?"'Atrasado'".toLowerCase()
                                                        :(estatus.equalsIgnoreCase("Enfermedad"))
                                                        ?"'Enfermedad'".toLowerCase()
                                                        :(estatus.equalsIgnoreCase("Vacaciones"))
                                                        ?"'Vacaciones'".toLowerCase()
                                                        :"'Inasistencia'".toLowerCase());
        System.out.println(query);
        try {
            Connection conn = openConnection();        
            Statement  stmt = conn.createStatement();      
            ResultSet rs   = stmt.executeQuery(query); 
            while (rs.next()) {
                RegistroHoraDTO s = new RegistroHoraDTO(rs.getInt(1)          
                                                            ,rs.getString(2)                  
                                                            ,rs.getString(3)         
                                                            ,rs.getString(4)         
                                                            ,rs.getString(5)         
                                                            ,rs.getString(6)        
                                                            ,rs.getString(7)        
                                                            ,rs.getString(8) );      
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    
        }
        return lst;
    }

   
    

}

