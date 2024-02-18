public class SMApp {
    private static SMPatBattle smPatBattle;
    public static void main(String[] args) throws Exception {
        smPatBattle = new SMPatBattle();
        smPatBattle.veMostrarPelotonAtaque();
        smPatBattle.veMostrarPelotonDefensa();
        smPatBattle.veMostrarPelotonSabotaje();
        smPatBattle.veMostrarPelotonInfiltracion();
        smPatBattle.veMostrarPelotonRescate();
    }
}
