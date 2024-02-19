import java.sql.ResultSet;

// import DataAccess.DACRegaloTipo;
import DataAccess.*;

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

    }
}
