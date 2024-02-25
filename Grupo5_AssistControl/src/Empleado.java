/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase Empleado
*/
public class Empleado extends Usuario {
    private String Cargo;
    private String HoraAmEntrada;
    private String HoraAmSalida;
    private String HoraPmEntrada;
    private String HoraPmSalida;
    private String HuellaDigital;
    
    public Empleado(){}

    public Empleado(String Cargo, String nombre, String apellido, String horaAmEntradaFijo, String HoraAmSalidaFijo,
            String HoraPmEntradaFijo, String HoraPmSalidaFijo) {
        super(nombre, apellido, horaAmEntradaFijo, HoraAmSalidaFijo, HoraPmEntradaFijo, HoraPmSalidaFijo);
        this.Cargo = Cargo;
    }

    public String getCargo() {
        return Cargo;
    }
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    public String getHoraAmEntrada() {
        return HoraAmEntrada;
    }
    public void setHoraAmEntrada(String HoraAmEntrada) {
        this.HoraAmEntrada = HoraAmEntrada;
    }
    public String getHoraAmSalida() {
        return HoraAmSalida;
    }
    public void setHoraAmSalida(String HoraAmSalida) {
        this.HoraAmSalida = HoraAmSalida;
    }
    public String getHoraPmEntrada() {
        return HoraPmEntrada;
    }
    public void setHoraPmEntrada(String HoraPmEntrada) {
        this.HoraPmEntrada = HoraPmEntrada;
    }
    public String getHoraPmSalida() {
        return HoraPmSalida;
    }
    public void setHoraPmSalida(String HoraPmSalida) {
        this.HoraPmSalida = HoraPmSalida;
    }

    @Override
    public String toString(){
        return 
          " Nombre:               " + getNombre()
        + "\n Apellido:             " + getApellido()
        + "\n Cargo:                " +getCargo()
        + "\n HoraAmEntradaFijo:    " + getHoraAmEntradaFijo()
        + "\n HoraAmSalidaFijo:     " + getHoraAmSalidaFijo()
        + "\n HoraPmEntradaFijo:    " + getHoraPmEntradaFijo()
        + "\n HoraPmSalidaFijo:     " + getHoraPmSalidaFijo();
    }
}
