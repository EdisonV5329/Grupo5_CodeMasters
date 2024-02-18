// public class ESBazuca implements FTIDispara, ESIArma {
//     @Override
//     public void ftDisparar() {
//         System.out.println("Bum! La bazuca ha sido disparada");
//     }

//     @Override
//     public void esObtenerEnergia(SAFuentePoder smFuentePoder) {
//         System.out.println("Bazuca obteniendo energia");
//     }
// }

public class ESBazuca implements FTIDispara, ESIArma {
    @Override
    public void ftDisparar() {
        System.out.println("Bum! La bazuca ha sido disparada");
    }

    @Override
    public void esObtenerEnergia(SAFuentePoder smFuentePoder) {
        System.out.println("Bazuca obteniendo energia");
    }
}