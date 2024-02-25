/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
src: Creacion de la clase abstracta Usuario
*/
public abstract class Usuario {
    private String Nombre;
    private String Apellido;
    private String HoraAmEntradaFijo;
    private String HoraAmSalidaFijo;
    private String HoraPmEntradaFijo;
    private String HoraPmSalidaFijo;
    
    public Usuario(){}
    
    public Usuario(String Nombre, String Apellido) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public Usuario(String Nombre, String Apellido, String HoraAmEntradaFijo, String HoraAmSalidaFijo,
            String HoraPmEntradaFijo, String HoraPmSalidaFijo) {
        this.Nombre =            Nombre;
        this.Apellido =          Apellido;
        this.HoraAmEntradaFijo = HoraAmEntradaFijo;
        this.HoraAmSalidaFijo =  HoraAmSalidaFijo;
        this.HoraPmEntradaFijo = HoraPmEntradaFijo;
        this.HoraPmSalidaFijo =  HoraPmSalidaFijo;
    }
            
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    public String getHoraAmEntradaFijo() {
        return HoraAmEntradaFijo;
    }

    public void setHoraAmEntradaFijo(String horaAmEntradaFijo) {
        HoraAmEntradaFijo = horaAmEntradaFijo;
    }

    public String getHoraAmSalidaFijo() {
        return HoraAmSalidaFijo;
    }

    public void setHoraAmSalidaFijo(String horaAmSalidaFijo) {
        HoraAmSalidaFijo = horaAmSalidaFijo;
    }

    public String getHoraPmEntradaFijo() {
        return HoraPmEntradaFijo;
    }

    public void setHoraPmEntradaFijo(String horaPmEntradaFijo) {
        HoraPmEntradaFijo = horaPmEntradaFijo;
    }

    public String getHoraPmSalidaFijo() {
        return HoraPmSalidaFijo;
    }

    public void setHoraPmSalidaFijo(String horaPmSalidaFijo) {
        HoraPmSalidaFijo = horaPmSalidaFijo;
    }
}
