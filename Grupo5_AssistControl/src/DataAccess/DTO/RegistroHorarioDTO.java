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
    private Integer IdEmpleado;
    private Integer IdEstatus;
    private String  HoraAmEntrada;
    private String  HoraAmSalida;
    private String  HoraPmEntrada;
    private String  HoraPmSalida;
<<<<<<< HEAD
    private String  Estatus; 
=======
    private String  Estado; 
>>>>>>> d71aa054db976342a72192d7c87c72115c75172a
    private String  FechaCrea;
    private String  FechaModifica;

<<<<<<< HEAD
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
=======
    public RegistroHorarioDTO() {
    }

    public RegistroHorarioDTO(Integer idRegistroHorario, Integer idEmpleado, Integer idEstatus, String horaAmEntrada,
            String horaAmSalida, String horaPmEntrada, String horaPmSalida, String estado, String fechaCrea,
            String fechaModifica) {
        IdRegistroHorario = idRegistroHorario;
        IdEmpleado = idEmpleado;
        IdEstatus = idEstatus;
        HoraAmEntrada = horaAmEntrada;
        HoraAmSalida = horaAmSalida;
        HoraPmEntrada = horaPmEntrada;
        HoraPmSalida = horaPmSalida;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
>>>>>>> d71aa054db976342a72192d7c87c72115c75172a
    }

    public Integer getIdRegistroHorario() {
        return IdRegistroHorario;
    }

    public void setIdRegistroHorario(Integer idRegistroHorario) {
        IdRegistroHorario = idRegistroHorario;
    }

    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public Integer getIdEstatus() {
        return IdEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        IdEstatus = idEstatus;
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdRegistroHorario: "+ getIdRegistroHorario()       
        + "\n IdEmpleado:        "+ getIdEmpleado()       
        + "\n IdEstatus:         "+ getIdEstatus()       
        + "\n HoraAmEntrada:     "+ getHoraAmEntrada()       
        + "\n HoraAmSalida:      "+ getHoraPmEntrada()       
        + "\n HoraPmEntrada:     "+ getHoraPmEntrada()       
        + "\n HoraPmSalida:      "+ getHoraPmSalida()       
        + "\n Estado:            "+ getEstado()     
        + "\n FechaCrea:         "+ getFechaCrea()    
        + "\n FechaModifica:     "+ getFechaModifica();    
    }

}
