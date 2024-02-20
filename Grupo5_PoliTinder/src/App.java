import java.sql.ResultSet;

// import DataAccess.DACRegaloTipo;
import DataAccess.*;
import DataAccess.DTO.CitaDTO;
import DataAccess.DTO.PersonaRolDTO;
import DataAccess.DTO.PersonaSexoDTO;
import DataAccess.DTO.RelacionDTO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("info de la base RegaloTipo");
        DACRegaloTipo RegaloTipo = new DACRegaloTipo();
        ResultSet rs_RegaloTipo = RegaloTipo.getAllRegaloTipo();
        while(rs_RegaloTipo.next()){
            System.out.println( rs_RegaloTipo.getString(1) + " " + 
                                rs_RegaloTipo.getString(2) + " " + 
                                rs_RegaloTipo.getString(3));
        }
        System.out.println();
        
        System.out.println("info de la base RelacionTipo");
        DACRelacionTipo RelacionTipo = new DACRelacionTipo();
        ResultSet rs_RelacionTipo = RelacionTipo.getAllRelacionTipo();
        while(rs_RelacionTipo.next()){
            System.out.println( rs_RelacionTipo.getString(1) + " " + 
                                rs_RelacionTipo.getString(2) + " " + 
                                rs_RelacionTipo.getString(3));
        }
        System.out.println();

        System.out.println("info de la base Regalo");
        DACRegalo Regalo = new DACRegalo();
        ResultSet rs_Regalo = Regalo.getAllRegalo();
        while(rs_Regalo.next()){
            System.out.println( rs_Regalo.getString(1) + " " + 
                                rs_Regalo.getString(2) + " " +
                                rs_Regalo.getString(3) + " " +
                                rs_Regalo.getString(4) + " " +
                                rs_Regalo.getString(5) + " " +
                                rs_Regalo.getString(6));
        }
        System.out.println();
        
        System.out.println("info de la base Persona");
        DACPersona Persona = new DACPersona();
        ResultSet rs_Persona = Persona.getAllPersona();
        while(rs_Persona.next()){
            System.out.println( rs_Persona.getString(1) + " " + 
                                rs_Persona.getString(2) + " " +
                                rs_Persona.getString(3) + " " +
                                rs_Persona.getString(4) + " " +
                                rs_Persona.getString(5) + " " +
                                rs_Persona.getString(6));
        }
        System.out.println();
        
        System.out.println("info de la base RegaloEnvio");
        DACRegaloEnvio RegaloEnvio = new DACRegaloEnvio();
        ResultSet rs_RegaloEnvio = RegaloEnvio.getAllRegaloEnvio();
        while(rs_RegaloEnvio.next()){
            System.out.println( rs_RegaloEnvio.getString(1) + " " + 
                                rs_RegaloEnvio.getString(2) + " " +
                                rs_RegaloEnvio.getString(3) + " " +
                                rs_RegaloEnvio.getString(4) + " " +
                                rs_RegaloEnvio.getString(5));
        }
        System.out.println();
        
//////////////////////////////////////////////////////////////////////////////////

        System.out.println("info de la base PersonaSexo");
        // SexoDTO s = new SexoDTO();
        // s.setIdSexo(3);
        // s.setNombre("Hibrido");
        PersonaSexoDAO oS = new PersonaSexoDAO();
        // oS.create(s);   
        // oS.update(s);   
        // System.out.println(oS.readBy(3).toString());
        for (PersonaSexoDTO s : oS.readAll()) {
            System.out.println(s.toString());
        }
        System.out.println();

        System.out.println("info de la base PersonaRol");

        PersonaRolDAO oPR = new PersonaRolDAO();


        for (PersonaRolDTO r : oPR.readAll()) {
            System.out.println(r.toString());
        }
        System.out.println();

        System.out.println("info de la base Relacion");

        RelacionDAO rD = new RelacionDAO();


        for (RelacionDTO r : rD.readAll()) {
            System.out.println(r.toString());
        }
        System.out.println();

        System.out.println("info de la base Cita");

        CitaDAO c = new CitaDAO();

        for (CitaDTO cD : c.readAll()) {
            System.out.println(cD.toString());
        }



    }
}
