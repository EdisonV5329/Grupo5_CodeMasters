/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 24.feb.2k24
scr: Creacion de la clase EmpleadoDTO
*/
package DataAccess.DTO;

public class EmpleadoDTO {
    private int    IdEmpleado;
    private int    IdCargo;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String HuellaDigital;
    private String HoraAmEntrada;
    private String HoraAmSalida;
    private String HoraPmEntrada;
    private String HoraPmSalida;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public EmpleadoDTO(){}
    
    public EmpleadoDTO(int idEmpleado, int idCargo, String nombre, String apellido, String cedula,
     String huellaDigital,String horaAmEntrada, String horaAmSalida, String horaPmEntrada,
     String horaPmSalida, String estado, String fechaCrea, String fechaModifica) {
        this.IdEmpleado = idEmpleado;
        this.IdCargo = idCargo;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cedula = cedula;
        this.HuellaDigital = huellaDigital;
        this.HoraAmEntrada = horaAmEntrada;
        this.HoraAmSalida = horaAmSalida;
        this.HoraPmEntrada = horaPmEntrada;
        this.HoraPmSalida = horaPmSalida;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public int getIdEmpleado() {
        return IdEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        IdEmpleado = idEmpleado;
    }
    public int getIdCargo() {
        return IdCargo;
    }
    public void setIdCargo(int idCargo) {
        IdCargo = idCargo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public String getHuellaDigital() {
        return HuellaDigital;
    }
    public void setHuellaDigital(String huellaDigital) {
        HuellaDigital = huellaDigital;
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
        + "\n IdEmpleado:      " + getIdEmpleado()    
        + "\n IdCargo:         " + getIdCargo()
        + "\n Nombre:          " + getNombre()
        + "\n Apellido:        " + getApellido()
        + "\n Cedula:          " + getCedula()
        + "\n HuellaDigital:   " + getHuellaDigital()
        + "\n HoraAmEntrada:   " + getHoraAmEntrada()
        + "\n HoraAmSalida:    " + getHoraAmSalida()
        + "\n HoraPmEntrada:   " + getHoraPmEntrada()
        + "\n HoraPmSalida:    " + getHoraPmSalida()
        + "\n Estado:          " + getEstado()
        + "\n FechaCrea:       " + getFechaCrea()
        + "\n FechaModifica:   " + getFechaModifica();
    }
}
