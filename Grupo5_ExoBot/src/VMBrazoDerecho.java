public class VMBrazoDerecho {
    private ESLaser esLaser;
    private ESLanzaFuego esLanzaFuego;

    // Getter y setter
    
    public ESLaser vmGetEsLaser() {
        return esLaser;
    }

    public void vmSetEsLaser(ESLaser esLaser) {
        this.esLaser = esLaser;
    }

    public ESLanzaFuego vmGetEsLanzaFuego() {
        return esLanzaFuego;
    }

    public void vmSetEsLanzaFuego(ESLanzaFuego esLanzaFuego) {
        this.esLanzaFuego = esLanzaFuego;
    }

    public VMBrazoDerecho() {
    }

    public VMBrazoDerecho(ESLaser esLaser) {
        this.esLaser = esLaser;
    }

    public VMBrazoDerecho(ESLanzaFuego esLanzaFuego) {
        this.esLanzaFuego = esLanzaFuego;
    }   
}
