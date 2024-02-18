public class VMBrazoIzquierdo {
    private ESBazuca esBazuca;
    private ESMK61 esMk61;
 
    public VMBrazoIzquierdo(ESMK61 esMk61) {
        this.esMk61 = esMk61;
    }

    public VMBrazoIzquierdo(ESBazuca esBazuca) {
        this.esBazuca = esBazuca;
    }

    public VMBrazoIzquierdo(){}

    public ESBazuca vmGetEsBazuca() {
        return esBazuca;
    }

    public void vmSetVmBazuca(ESBazuca vmBazuca) {
        this.esBazuca = vmBazuca;
    }

    public ESMK61 vmGetVmMk61() {
        return esMk61;
    }

    public void vmSetVmMk61(ESMK61 esMk61) {
        this.esMk61 = esMk61;
    }
}
