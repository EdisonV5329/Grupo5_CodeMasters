public class SMColor {
    public final String SMRESET;
    public final String SMRED;
    public final String SMGREEN;
    public final String SMYELLOW;
    public final String SMBLUE;
    public final String SMPURPLE;
    public final String SMCYAN;
    public final String SMWHITE;
    
    public SMColor() {
        SMRESET = "\u001B[0m";
        SMRED =  "\u001B[31m";
        SMGREEN = "\u001B[32m";
        SMYELLOW = "\u001B[33m";
        SMBLUE = "\u001B[34m";
        SMPURPLE = "\u001B[35m";
        SMCYAN = "\u001B[36m";
        SMWHITE = "\u001B[37m";
    }

}
