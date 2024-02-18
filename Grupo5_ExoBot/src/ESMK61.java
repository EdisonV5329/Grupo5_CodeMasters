public class ESMK61 implements FTIDispara, ESIArma {
    @Override
    public void ftDisparar() {
        System.out.println("disparando una rafaga de balas");
    }

    @Override
    public void esObtenerEnergia(SAFuentePoder asFuentePoder){
        System.out.println("MK61 obteniendo energia");
    }
}
