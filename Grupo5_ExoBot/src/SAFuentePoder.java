public class SAFuentePoder {
    private String saNivelEnergia;

    public SAFuentePoder(String smNivelEnergia) {
        this.saNivelEnergia = smNivelEnergia;
    }

    public String smGetSmNivelEnergia() {
        return saNivelEnergia;
    }

    public void smSetSmNivelEnergia(String smNivelEnergia) {
        this.saNivelEnergia = smNivelEnergia;
    }

    public void smOtogarEnergiaArma(ESIArma smArma){
        System.out.println("Otorgando energia al arma");
    }
    public void smOtorgarEnergiaSistema(){
        System.out.println("Otorgando energia al sistema electrico del exoesqueleto");
    }
}