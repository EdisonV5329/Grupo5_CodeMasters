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
    private Integer    IdEmpleadoHorario;
    private Integer    IdDiaTrabajo;
    private Integer    IdHoraAmEntrada;
    private Integer    IdHoraAmSalida;
    private Integer    IdHoraPmEntrada;
    private Integer    IdHoraPmSalida;
    private String     Estado;
    private String     FechaCrea;
    private String     FechaModifica;

    public  EmpleadoHorarioDTO() {}

    public EmpleadoHorarioDTO(Integer idDiaTrabajo, Integer idHoraAmEntrada, Integer idHoraAmSalida,
    Integer idHoraPmEntrada, Integer idHoraPmSalida) {
        IdDiaTrabajo = idDiaTrabajo;
        IdHoraAmEntrada = idHoraAmEntrada;
        IdHoraAmSalida = idHoraAmSalida;
        IdHoraPmEntrada = idHoraPmEntrada;
        IdHoraPmSalida = idHoraPmSalida;
    }

    public EmpleadoHorarioDTO(Integer idEmpleadoHorario, Integer idDiaTrabajo, Integer idHoraAmEntrada, Integer idHoraAmSalida,
            Integer idHoraPmEntrada, Integer idHoraPmSalida, String estado, String fechaCrea, String fechaModifica) {
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

    public Integer getIdEmpleadoHorario() {
        return IdEmpleadoHorario;
    }
    public void setIdEmpleadoHorario(Integer idEmpleadoHorario) {
        IdEmpleadoHorario = idEmpleadoHorario;
    }
    public Integer getIdDiaTrabajo() {
        return IdDiaTrabajo;
    }
    public void setIdDiaTrabajo(Integer idDiaTrabajo) {
        IdDiaTrabajo = idDiaTrabajo;
    }
    public Integer getIdHoraAmEntrada() {
        return IdHoraAmEntrada;
    }
    public void setIdHoraAmEntrada(Integer idHoraAmEntrada) {
        IdHoraAmEntrada = idHoraAmEntrada;
    }
    public Integer getIdHoraAmSalida() {
        return IdHoraAmSalida;
    }
    public void setIdHoraAmSalida(Integer idHoraAmSalida) {
        IdHoraAmSalida = idHoraAmSalida;
    }
    public Integer getIdHoraPmEntrada() {
        return IdHoraPmEntrada;
    }
    public void setIdHoraPmEntrada(Integer idHoraPmEntrada) {
        IdHoraPmEntrada = idHoraPmEntrada;
    }
    public Integer getIdHoraPmSalida() {
        return IdHoraPmSalida;
    }
    public void setIdHoraPmSalida(Integer idHoraPmSalida) {
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
