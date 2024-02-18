import java.util.ArrayList;
import java.util.Hashtable;

public class SMPatBattle {
    private final int SMNROSOLDADOS;
    private ArrayList <SMSoldado> smPelotonAtaque;
    private ArrayList <SMSoldado> vePelotonDefensa;
    private ArrayList <SMSoldado> vePelotonSabotaje;
    private ArrayList <SMSoldado> vePelotonInfiltracion;
    private ArrayList <SMSoldado> vePelotonRescate;
    private Hashtable <Integer,String> smMisiones;
    private SMExpertoEspanol smExpertoEspanol;
    private SMExpertoIngles smExpertoIngles;
    private VEMecatronico smMecatronico;
    private VEIabot smIabot;
    private VEExobot smExobot;
    private SMSoldado smSoldado;
    private SMColor smColor;
    int smNroSoldado;

    public SMPatBattle() {
        SMNROSOLDADOS = 5;
        this.smPelotonAtaque = new ArrayList<>();
        this.vePelotonDefensa = new ArrayList<>();
        this.vePelotonSabotaje = new ArrayList<>();
        this.vePelotonInfiltracion = new ArrayList<>();
        this.vePelotonRescate = new ArrayList<>();
        this.smMisiones = new Hashtable<>();
        smMisiones.put(1234,"atacar");
        smMisiones.put(5678,"defender");
        smMisiones.put(9101,"sabotear");
        smMisiones.put(1213,"infiltrarse");
        smMisiones.put(1415,"rescatar");
        smIabot = new VEIabot(smMisiones);
        smMecatronico = new VEMecatronico();
        smExpertoEspanol = new SMExpertoEspanol();
        smExpertoIngles = new SMExpertoIngles();

        smColor = new SMColor();
    }

    
    public void veMostrarPelotonSabotaje(){
        smNroSoldado = 1;
        veCrearPelotonSabotaje();
        System.out.println(smColor.SMGREEN + "PELOTON DE SABOTAJE:" + smColor.SMRESET);
        System.out.println("------------------------------------------------");
        for (SMSoldado VESoldadoSabotaje : vePelotonSabotaje) {
            System.out.println(smColor.SMGREEN + "SOLDADO " + smNroSoldado + smColor.SMRESET);
            smNroSoldado++;
            smExpertoEspanol.smEnsenarEspanol(VESoldadoSabotaje.smGetSmExobot());
            smExpertoIngles.smEnsenarIngles(VESoldadoSabotaje.smGetSmExobot());
            VESoldadoSabotaje.smGetSmExobot().veRealizarMision(VESoldadoSabotaje.smGetSmExobot().veGetVeCodigoSeguridad(), smMisiones);
            VESoldadoSabotaje.smGetSmExobot().vePotencializarFuerza(VESoldadoSabotaje.veGetVeFuerza());
            VESoldadoSabotaje.smGetSmExobot().vePotencializarHabilidad(VESoldadoSabotaje.veGetVeHabilidad());
            VESoldadoSabotaje.smGetSmExobot().vePotencializarMovimiento(VESoldadoSabotaje.veGetVeMovimientoFisico());     
            VESoldadoSabotaje.smGetSmExobot().smGetSmExtremidadInferior().ftSaltar(50);
            VESoldadoSabotaje.smGetSmExobot().smGetSmExtremidadInferior().ftCorrer(200);
            VESoldadoSabotaje.smGetSmExobot().smGetSmTurboReactor().ftVolar(smExobot.smGetSmFuentePoder());
            VESoldadoSabotaje.smRecargarFuentePoder(smIabot);
            VESoldadoSabotaje.smReemplazarFuentePoder(smIabot);
            System.out.println("------------------------------------------------");  
        }
    }

    public void veMostrarPelotonInfiltracion(){
        smNroSoldado = 1;
        veCrearPelotonInfiltracion();
        System.out.println(smColor.SMBLUE + "PELOTON DE INFILTRACION:" + smColor.SMRESET);
        System.out.println("------------------------------------------------");
        for (SMSoldado VESoldadoInfiltracion : vePelotonInfiltracion) {
            System.out.println(smColor.SMBLUE + "SOLDADO " + smNroSoldado + smColor.SMRESET);
            smNroSoldado++;
            smExpertoEspanol.smEnsenarEspanol(VESoldadoInfiltracion.smGetSmExobot());
            smExpertoIngles.smEnsenarIngles(VESoldadoInfiltracion.smGetSmExobot());
            VESoldadoInfiltracion.smGetSmExobot().veRealizarMision(VESoldadoInfiltracion.smGetSmExobot().veGetVeCodigoSeguridad(), smMisiones);
            VESoldadoInfiltracion.smGetSmExobot().vePotencializarFuerza(VESoldadoInfiltracion.veGetVeFuerza());
            VESoldadoInfiltracion.smGetSmExobot().vePotencializarHabilidad(VESoldadoInfiltracion.veGetVeHabilidad());
            VESoldadoInfiltracion.smGetSmExobot().vePotencializarMovimiento(VESoldadoInfiltracion.veGetVeMovimientoFisico());     
            VESoldadoInfiltracion.smGetSmExobot().smGetSmExtremidadInferior().ftSaltar(50);
            VESoldadoInfiltracion.smGetSmExobot().smGetSmExtremidadInferior().ftCorrer(200);
            VESoldadoInfiltracion.smGetSmExobot().smGetSmTurboReactor().ftVolar(smExobot.smGetSmFuentePoder());
            VESoldadoInfiltracion.smGetSmExobot().smGetSmBrazoDerecho().vmGetEsLaser().ftDisparar();
            VESoldadoInfiltracion.smGetSmExobot().smGetSmBrazoIzquierdo();
            VESoldadoInfiltracion.smRecargarFuentePoder(smIabot);
            VESoldadoInfiltracion.smReemplazarFuentePoder(smIabot);
            System.out.println("------------------------------------------------");  
        }
        
    }
    
    public void veMostrarPelotonRescate(){
        smNroSoldado = 1;
        veCrearPelotonRescate();
        System.out.println(smColor.SMCYAN + "PELOTON DE RESCATE:" + smColor.SMRESET);
        System.out.println("------------------------------------------------");
        for (SMSoldado VESoldadoRescate : vePelotonRescate) {
            System.out.println(smColor.SMCYAN + "SOLDADO " + smNroSoldado + smColor.SMRESET);
            smNroSoldado++;
            smExpertoEspanol.smEnsenarEspanol(VESoldadoRescate.smGetSmExobot());
            smExpertoIngles.smEnsenarIngles(VESoldadoRescate.smGetSmExobot());
            VESoldadoRescate.smGetSmExobot().veRealizarMision(VESoldadoRescate.smGetSmExobot().veGetVeCodigoSeguridad(), smMisiones);
            VESoldadoRescate.smGetSmExobot().vePotencializarFuerza(VESoldadoRescate.veGetVeFuerza());
            VESoldadoRescate.smGetSmExobot().vePotencializarHabilidad(VESoldadoRescate.veGetVeHabilidad());
            VESoldadoRescate.smGetSmExobot().vePotencializarMovimiento(VESoldadoRescate.veGetVeMovimientoFisico());     
            VESoldadoRescate.smGetSmExobot().smGetSmExtremidadInferior().ftSaltar(50);
            VESoldadoRescate.smGetSmExobot().smGetSmExtremidadInferior().ftCorrer(200);
            VESoldadoRescate.smGetSmExobot().smGetSmTurboReactor().ftVolar(smExobot.smGetSmFuentePoder());
            VESoldadoRescate.smGetSmExobot().smGetSmBrazoDerecho().vmGetEsLanzaFuego().ftDisparar();
            VESoldadoRescate.smGetSmExobot().smGetSmBrazoIzquierdo().vmGetVmMk61().esObtenerEnergia(VESoldadoRescate.smGetSmExobot().smGetSmFuentePoder());
            VESoldadoRescate.smRecargarFuentePoder(smIabot);
            VESoldadoRescate.smReemplazarFuentePoder(smIabot);
            System.out.println("------------------------------------------------");  
        }
    }

    public void veMostrarPelotonDefensa(){
        smNroSoldado = 1;
        veCrearPelotonDefensa();
        System.out.println(smColor.SMYELLOW + "PELOTON DE DEFENSA:" + smColor.SMRESET);
        System.out.println("------------------------------------------------");
        for (SMSoldado VESoldadoDefensa : vePelotonDefensa) {
            System.out.println(smColor.SMYELLOW + "SOLDADO " + smNroSoldado + smColor.SMRESET);
            smNroSoldado++;
            smExpertoEspanol.smEnsenarEspanol(VESoldadoDefensa.smGetSmExobot());
            smExpertoIngles.smEnsenarIngles(VESoldadoDefensa.smGetSmExobot());
            VESoldadoDefensa.smGetSmExobot().veRealizarMision(VESoldadoDefensa.smGetSmExobot().veGetVeCodigoSeguridad(), smMisiones);
            VESoldadoDefensa.smGetSmExobot().vePotencializarFuerza(VESoldadoDefensa.veGetVeFuerza());
            VESoldadoDefensa.smGetSmExobot().vePotencializarHabilidad(VESoldadoDefensa.veGetVeHabilidad());
            VESoldadoDefensa.smGetSmExobot().vePotencializarMovimiento(VESoldadoDefensa.veGetVeMovimientoFisico());     
            VESoldadoDefensa.smGetSmExobot().smGetSmExtremidadInferior().ftSaltar(50);
            VESoldadoDefensa.smGetSmExobot().smGetSmExtremidadInferior().ftCorrer(200);
            VESoldadoDefensa.smGetSmExobot().smGetSmTurboReactor().ftVolar(smExobot.smGetSmFuentePoder());
            VESoldadoDefensa.smGetSmExobot().smGetSmBrazoDerecho().vmGetEsLanzaFuego().ftDisparar();
            VESoldadoDefensa.smGetSmExobot().smGetSmBrazoIzquierdo().vmGetVmMk61().esObtenerEnergia(VESoldadoDefensa.smGetSmExobot().smGetSmFuentePoder());
            VESoldadoDefensa.smRecargarFuentePoder(smIabot);
            VESoldadoDefensa.smReemplazarFuentePoder(smIabot);
            System.out.println("------------------------------------------------");  
        }
    }

    public void veMostrarPelotonAtaque(){
        System.out.println(smColor.SMWHITE +"\nPELOTONES RUSOS" + smColor.SMBLUE + " LISTOS PARA" + smColor.SMRED + " LA BATALLA" + smColor.SMRESET);
        smNroSoldado = 1;
        smCrearPelotonAtaque();
        System.out.println(smColor.SMRED +"\nPELOTON DE ATAQUE:" + smColor.SMRESET);
        System.out.println("------------------------------------------------");
        for (SMSoldado smSoldadoAtaque : smPelotonAtaque) {
            System.out.println(smColor.SMRED + "SOLDADO " + smNroSoldado + smColor.SMRESET);
            smNroSoldado++;
            smExpertoEspanol.smEnsenarEspanol(smSoldadoAtaque.smGetSmExobot());
            smExpertoIngles.smEnsenarIngles(smSoldadoAtaque.smGetSmExobot());
            smSoldadoAtaque.smGetSmExobot().veRealizarMision(smSoldadoAtaque.smGetSmExobot().veGetVeCodigoSeguridad(), smMisiones);
            smSoldadoAtaque.smGetSmExobot().vePotencializarFuerza(smSoldadoAtaque.veGetVeFuerza());
            smSoldadoAtaque.smGetSmExobot().vePotencializarHabilidad(smSoldadoAtaque.veGetVeHabilidad());
            smSoldadoAtaque.smGetSmExobot().vePotencializarMovimiento(smSoldadoAtaque.veGetVeMovimientoFisico());     
            smSoldadoAtaque.smGetSmExobot().smGetSmExtremidadInferior().ftSaltar(50);
            smSoldadoAtaque.smGetSmExobot().smGetSmExtremidadInferior().ftCorrer(200);
            smSoldadoAtaque.smGetSmExobot().smGetSmTurboReactor().ftVolar(smExobot.smGetSmFuentePoder());
            smSoldadoAtaque.smGetSmExobot().smGetSmBrazoDerecho().vmGetEsLaser().ftDisparar();
            smSoldadoAtaque.smGetSmExobot().smGetSmBrazoIzquierdo().vmGetEsBazuca().esObtenerEnergia(smSoldadoAtaque.smGetSmExobot().smGetSmFuentePoder());
            smSoldadoAtaque.smRecargarFuentePoder(smIabot);
            smSoldadoAtaque.smReemplazarFuentePoder(smIabot);
            System.out.println("------------------------------------------------");  
        }
    }
    

    public void smCrearPelotonAtaque(){
        for (int smCantidadSoldados = 0; smCantidadSoldados < SMNROSOLDADOS; smCantidadSoldados++) {
            smSoldado = new SMSoldado("fuerte","atacar","agilidad");
            smIabot.smSetSmCodigoSeguridad(1234);
            smIabot.smSetSmSerieUnica(smIabot.smGenerarCodigoAleatorio());
            smIabot.smSetSmFuentePoder(new SAFuentePoder("alto"));
            smExobot = smMecatronico.smArmarExobot(smIabot.smGetSmCodigoSeguridad(),smIabot.smGetSmSerieUnica(), smSoldado.veGetVeHabilidad(), smIabot.smGetSmFuentePoder());
            smSoldado.smSetSmExobot(smExobot);
            smPelotonAtaque.add(smSoldado);
        }
    }

    public void veCrearPelotonDefensa(){
        for (int smCantidadSoldados = 0; smCantidadSoldados < SMNROSOLDADOS; smCantidadSoldados++) {
            smSoldado = new SMSoldado("fuerte","defender","agilidad");
            smIabot.smSetSmCodigoSeguridad(5678);
            smIabot.smSetSmSerieUnica(smIabot.smGenerarCodigoAleatorio());
            smIabot.smSetSmFuentePoder(new SAFuentePoder("alto"));
            smExobot = smMecatronico.smArmarExobot(smIabot.smGetSmCodigoSeguridad(),smIabot.smGetSmSerieUnica(), smSoldado.veGetVeHabilidad(), smIabot.smGetSmFuentePoder());
            smSoldado.smSetSmExobot(smExobot);
            vePelotonDefensa.add(smSoldado);
        }
    }

    public void veCrearPelotonSabotaje(){
        for (int smCantidadSoldados = 0; smCantidadSoldados < SMNROSOLDADOS; smCantidadSoldados++) {
            smSoldado = new SMSoldado("fuerte","sabotaje","agilidad");
            smIabot.smSetSmCodigoSeguridad(9101);
            smIabot.smSetSmSerieUnica(smIabot.smGenerarCodigoAleatorio());
            smIabot.smSetSmFuentePoder(new SAFuentePoder("alto"));
            smExobot = smMecatronico.smArmarExobot(smIabot.smGetSmCodigoSeguridad(),smIabot.smGetSmSerieUnica(), smSoldado.veGetVeHabilidad(), smIabot.smGetSmFuentePoder());
            smSoldado.smSetSmExobot(smExobot);
            vePelotonSabotaje.add(smSoldado);
        }
    }

    public void veCrearPelotonInfiltracion(){
        for (int smCantidadSoldados = 0; smCantidadSoldados < SMNROSOLDADOS; smCantidadSoldados++) {
            smSoldado = new SMSoldado("fuerte","infiltracion","agilidad");
            smIabot.smSetSmCodigoSeguridad(1213);
            smIabot.smSetSmSerieUnica(smIabot.smGenerarCodigoAleatorio());
            smIabot.smSetSmFuentePoder(new SAFuentePoder("alto"));
            smExobot = smMecatronico.smArmarExobot(smIabot.smGetSmCodigoSeguridad(),smIabot.smGetSmSerieUnica(), smSoldado.veGetVeHabilidad(), smIabot.smGetSmFuentePoder());
            smSoldado.smSetSmExobot(smExobot);
            vePelotonInfiltracion.add(smSoldado);
        }
    }

    public void veCrearPelotonRescate(){
        for (int smCantidadSoldados = 0; smCantidadSoldados < SMNROSOLDADOS; smCantidadSoldados++) {
            smSoldado = new SMSoldado("fuerte","rescate","agilidad");
            smIabot.smSetSmCodigoSeguridad(1415);
            smIabot.smSetSmSerieUnica(smIabot.smGenerarCodigoAleatorio());
            smIabot.smSetSmFuentePoder(new SAFuentePoder("alto"));
            smExobot = smMecatronico.smArmarExobot(smIabot.smGetSmCodigoSeguridad(),smIabot.smGetSmSerieUnica(), smSoldado.veGetVeHabilidad(), smIabot.smGetSmFuentePoder());
            smSoldado.smSetSmExobot(smExobot);
            vePelotonRescate.add(smSoldado);
        }
    }
}
