/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 25.feb.2k24
src: Creacion de la clase EmpleadoHorarioDTO
*/
package DataAccess.DTO;

public class EmpleadoHorarioDTO {
    private int    IdEmpleadoHorario;
    private int    IdDiaTrabajo;
    private int    IdHoraAmEntrada;
    private int    IdHoraAmSalida;
    private int    IdHoraPmEntrada;
    private int    IdHoraPmSalida;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public  EmpleadoHorarioDTO() {}

    public EmpleadoHorarioDTO(int idEmpleadoHorario, int idDiaTrabajo, int idHoraAmEntrada, int idHoraAmSalida,
            int idHoraPmEntrada, int idHoraPmSalida, String estado, String fechaCrea, String fechaModifica) {
        this.IdEmpleadoHorario = idEmpleadoHorario;
        this.IdDiaTrabajo = idDiaTrabajo;
        this.IdHoraAmEntrada = idHoraAmEntrada;
        this.IdHoraAmSalida = idHoraAmSalida;
        this.IdHoraPmEntrada = idHoraPmEntrada;
        this.IdHoraPmSalida = idHoraPmSalida;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public int getIdEmpleadoHorario() {
        return IdEmpleadoHorario;
    }
    public void setIdEmpleadoHorario(int idEmpleadoHorario) {
        IdEmpleadoHorario = idEmpleadoHorario;
    }
    public int getIdDiaTrabajo() {
        return IdDiaTrabajo;
    }
    public void setIdDiaTrabajo(int idDiaTrabajo) {
        IdDiaTrabajo = idDiaTrabajo;
    }
    public int getIdHoraAmEntrada() {
        return IdHoraAmEntrada;
    }
    public void setIdHoraAmEntrada(int idHoraAmEntrada) {
        IdHoraAmEntrada = idHoraAmEntrada;
    }
    public int getIdHoraAmSalida() {
        return IdHoraAmSalida;
    }
    public void setIdHoraAmSalida(int idHoraAmSalida) {
        IdHoraAmSalida = idHoraAmSalida;
    }
    public int getIdHoraPmEntrada() {
        return IdHoraPmEntrada;
    }
    public void setIdHoraPmEntrada(int idHoraPmEntrada) {
        IdHoraPmEntrada = idHoraPmEntrada;
    }
    public int getIdHoraPmSalida() {
        return IdHoraPmSalida;
    }
    public void setIdHoraPmSalida(int idHoraPmSalida) {
        IdHoraPmSalida = idHoraPmSalida;
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
    public  String toString() {
        return getClass().getName()
        + "\n IdEmpleadoHorario:    " + getIdEmpleadoHorario()
        + "\n IdDiaTrabajo:         " + getIdDiaTrabajo()
        + "\n IdHoraAmEntrada:      " + getIdHoraAmEntrada()
        + "\n IdHoraAmSalida:       " + getIdHoraAmSalida()
        + "\n IdHoraPmEntrada:      " + getIdHoraPmEntrada()
        + "\n IdHoraPmSalida:       " + getIdHoraPmSalida()
        + "\n Estado:               " + getEstado()
        + "\n FechaCrea:            " + getFechaCrea()
        + "\n FechaModifica:        " + getFechaModifica();
    }

}
