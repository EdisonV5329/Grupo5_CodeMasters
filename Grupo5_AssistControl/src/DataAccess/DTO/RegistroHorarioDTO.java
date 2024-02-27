/*
|------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.        |
| francisco.torres@epn.edu.ec   Francisco Torres |
|------------------------------------------------|
Autor: Francisco Torres
Fecha: 24.feb.2k24
script: Creacion de la clase RegistroHorarioDTO
*/
package DataAccess.DTO;

public class RegistroHorarioDTO  {
    
    private Integer IdRegistroHorario;
    private String  Nombre;
    private String  HoraAmEntrada;
    private String  HoraAmSalida;
    private String  HoraPmEntrada;
    private String  HoraPmSalida;
    private String  Estatus;
    private String  Fecha;  

    public RegistroHorarioDTO() {}
    public RegistroHorarioDTO(  Integer IdRegistroHorario,
                                String  Nombre,
                                String  HoraAmEntrada,
                                String  HoraAmSalida,
                                String  HoraPmEntrada,
                                String  HoraPmSalida,
                                String  Estatus,
                                String  Fecha
    ){
        this.IdRegistroHorario = IdRegistroHorario;        
        this.Nombre = Nombre;
        this.HoraAmEntrada = HoraAmEntrada;
        this.HoraAmSalida = HoraAmSalida;
        this.HoraPmEntrada = HoraPmEntrada;
        this.HoraPmSalida = HoraPmSalida;
        this.Estatus = Estatus;
        this.Fecha = Fecha;    
    }
    
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
    public String getFecha() {
        return Fecha;
    }
    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String toString() {
        return getClass().getName() 
        +"\nIdRegistroHorario:  " + getIdRegistroHorario()        
        +"\nNombre:             " + getNombre()
        +"\nHoraAmEntrada:      " + getHoraAmEntrada()
        +"\nHoraAmSalida:       " + getHoraAmSalida()
        +"\nHoraPmEntrada:      " + getHoraPmEntrada()
        +"\nHoraPmSalida:       " + getHoraPmSalida()
        +"\nEstatus:            " + getEstatus()
        +"\nFecha:              " + getFecha();    
    }

}
