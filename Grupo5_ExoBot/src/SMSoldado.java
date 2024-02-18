public class SMSoldado {
    private String veFuerza; 
    private String veHabilidad; 
    private String veMovimientoFisico;
    private VEExobot smExobot; 

    public SMSoldado(String veFuerza, String veHabilidad, String veMovimientoFisico) {
        this.veFuerza = veFuerza;
        this.veHabilidad = veHabilidad;
        this.veMovimientoFisico = veMovimientoFisico;
    }

    public String veGetVeFuerza() {
        return veFuerza;
    }

    public void veSetVeFuerza(String veFuerza) {
        this.veFuerza = veFuerza;
    }

    public String veGetVeHabilidad() {
        return veHabilidad;
    }

    public void veSetVeHabilidad(String veHabilidad) {
        this.veHabilidad = veHabilidad;
    }

    public String veGetVeMovimientoFisico() {
        return veMovimientoFisico;
    }

    public void veSetVeMovimientoFisico(String veMovimientoFisico) {
        this.veMovimientoFisico = veMovimientoFisico;
    }

    public VEExobot smGetSmExobot() {
        return smExobot;
    }

    public void smSetSmExobot(VEExobot smExobot) {
        this.smExobot = smExobot;
    }
    
    public void smRecargarFuentePoder(VEIabot veIabot){
        System.out.println("recargando fuente de poder agotada de exobot");
    }

    public void smReemplazarFuentePoder(VEIabot veIabot){
        System.out.println("reemplazando fuente de poder deteriorada de exobot");
    }

    public void veSacrificarExtremidad(){
        System.out.println("sacrificar extremidades inferiores ");
    }
}
