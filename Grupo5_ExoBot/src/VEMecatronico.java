import java.util.ArrayList;
public class VEMecatronico {

    private ArrayList <String> smLstHabilidades;

    public VEMecatronico(){}

    public ArrayList<String> getSmlstHabilidades() {
        return smLstHabilidades;
    }

    public void setSmlstHabilidades(ArrayList<String> smLstHabilidades) {
        this.smLstHabilidades = smLstHabilidades;
    }

    public VEExobot smArmarExobot(int smCodigo, int smSerieUnica, String smHabilidad, SAFuentePoder smFuentePoder){
        SAExtremidadInferior smExtremidadInferior = new SAExtremidadInferior();
        SATurboReactor smTurboReactor = new SATurboReactor();
        VMBrazoDerecho smBrazoDerecho = new VMBrazoDerecho();
        VMBrazoIzquierdo smBrazoIzquierdo = new VMBrazoIzquierdo();
        if (smHabilidad.equals("defender")){
            smBrazoDerecho = new VMBrazoDerecho(new ESLanzaFuego());
            smBrazoIzquierdo = new VMBrazoIzquierdo(new ESMK61());
        }
        else if (smHabilidad.equals("atacar")){
            smBrazoDerecho = new VMBrazoDerecho(new ESLaser());
            smBrazoIzquierdo = new VMBrazoIzquierdo(new ESBazuca());
        }
        else if (smHabilidad.equals("sabotaje")){
            smBrazoDerecho = new VMBrazoDerecho(new ESLaser());
            smBrazoIzquierdo = new VMBrazoIzquierdo(new ESMK61());
        }
        else if (smHabilidad.equals("infiltracion")){
            smBrazoDerecho = new VMBrazoDerecho(new ESLaser());
            smBrazoIzquierdo = new VMBrazoIzquierdo();
        }
        else if (smHabilidad.equals("rescate")){
            smBrazoDerecho = new VMBrazoDerecho(new ESLanzaFuego());
            smBrazoIzquierdo = new VMBrazoIzquierdo(new ESMK61());
        }  
        VEExobot smExobot = new VEExobot(smCodigo, smSerieUnica, smExtremidadInferior, smTurboReactor, smFuentePoder, smBrazoDerecho, smBrazoIzquierdo);
        return smExobot;
    }
}   
