public class SAExtremidadInferior implements FTICorre, FTISalta{
    private int saCapacidadSalto;
    private int saCapacidadCorrrida;

    public SAExtremidadInferior() {
        this.saCapacidadSalto = 50;
        this.saCapacidadCorrrida = 200;
    }

    public int getSaCapacidadSalto() {
        return saCapacidadSalto;
    }

    public void setSaCapacidadSalto(int saCapacidadSalto) {
        this.saCapacidadSalto = saCapacidadSalto;
    }

    public int getSaCapacidadCorrrida() {
        return saCapacidadCorrrida;
    }

    public void setSaCapacidadCorrrida(int saCapacidadCorrrida) {
        this.saCapacidadCorrrida = saCapacidadCorrrida;
    }

    @Override
    public void ftSaltar(int smSaltoRequerido) {
        if (smSaltoRequerido > smSaltoRequerido)
            System.out.println("Me es imposible saltar " + smSaltoRequerido + " m");
        else
            System.out.println("Estoy saltando " + smSaltoRequerido + " m");
    }

    @Override
    public void ftCorrer(int smVelocidadRequerida) {
        if (smVelocidadRequerida > saCapacidadCorrrida)
            System.out.println("Me es imposible correr a " + smVelocidadRequerida + " km/h");
        else
            System.out.println("Estoy corriendo a " + smVelocidadRequerida + " km/h");
    }
}
