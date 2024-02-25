/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 24.feb.2k24
script: Creacion de la clase RegistroHorarioDTO
*/
package DataAccess.DTO;

public class RegistroHorarioDTO  {
    private Integer IdRegistroHorario;
    private String Nombre;
    private String  HoraAmEntrada;
    private String  HoraAmSalida;
    private String  HoraPmEntrada;
    private String  HoraPmSalida;
    private String  Estatus; 
    private String  FechaCrea;

    public RegistroHorarioDTO(Integer idRegistroHorario, String nombre, String horaAmEntrada, String horaAmSalida,
            String horaPmEntrada, String horaPmSalida, String estatus, String fechaCrea) {
        this.IdRegistroHorario = idRegistroHorario;
        this.Nombre = nombre;
        this.HoraAmEntrada = horaAmEntrada;
        this.HoraAmSalida = horaAmSalida;
        this.HoraPmEntrada = horaPmEntrada;
        this.HoraPmSalida = horaPmSalida;
        this.Estatus = estatus;
        this.FechaCrea = fechaCrea;
    }

    public RegistroHorarioDTO() {}

    public Integer getIdRegistroHorario() {
        return IdRegistroHorario;
    }

    public void setIdRegistroHorario(Integer idRegistroHorario) {
        IdRegistroHorario = idRegistroHorario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getHoraAmEntrada() {
        return HoraAmEntrada;
    }

    public void setHoraAmEntrada(String horaAmEntrada) {
        HoraAmEntrada = horaAmEntrada;
    }

    public String getHoraAmSalida() {
        return HoraAmSalida;
    }

    public void setHoraAmSalida(String horaAmSalida) {
        HoraAmSalida = horaAmSalida;
    }

    public String getHoraPmEntrada() {
        return HoraPmEntrada;
    }

    public void setHoraPmEntrada(String horaPmEntrada) {
        HoraPmEntrada = horaPmEntrada;
    }

    public String getHoraPmSalida() {
        return HoraPmSalida;
    }

    public void setHoraPmSalida(String horaPmSalida) {
        HoraPmSalida = horaPmSalida;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdRegistroHorario: "+ getIdRegistroHorario()       
        + "\n Nombre:            "+ getNombre()       
        + "\n HoraAmEntrada:     "+ getHoraAmEntrada()       
        + "\n HoraAmSalida:      "+ getHoraPmEntrada()       
        + "\n HoraPmEntrada:     "+ getHoraPmEntrada()       
        + "\n HoraPmSalida:      "+ getHoraPmSalida()       
        + "\n Estatus:           "+ getEstatus()       
        + "\n Fecha:             "+ getFechaCrea();    
    }

}
