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
    private Integer IdEmpleado;
    private Integer IdCargo;
    private String  Nombre;
    private String  Apellido;
    private String  Cedula;
    private String  CodigoBarras;
    private String  Estado;
    private String  FechaCrea;
    private String  FechaModifica;
    
    public EmpleadoDTO(){}
    
    public EmpleadoDTO(Integer idCargo, String nombre, String apellido, String cedula, String codigoBarras) {
        IdCargo = idCargo;
        Nombre = nombre;
        Apellido = apellido;
        Cedula = cedula;
        CodigoBarras = codigoBarras;
    }
    
    public EmpleadoDTO(Integer idEmpleado, Integer idCargo, String nombre, String apellido, String cedula,
     String codigoBarras, String estado, String fechaCrea, String fechaModifica) {
        this.IdEmpleado = idEmpleado;
        this.IdCargo = idCargo;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cedula = cedula;
        this.CodigoBarras = codigoBarras;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public Integer getIdEmpleado() {
        return IdEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        IdEmpleado = idEmpleado;
    }
    public Integer getIdCargo() {
        return IdCargo;
    }
    public void setIdCargo(Integer idCargo) {
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
    public String getCodigoBarras() {
        return CodigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        CodigoBarras = codigoBarras;
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
        + "\n CodigoBarras:    " + getCodigoBarras()
        + "\n Estado:          " + getEstado()
        + "\n FechaCrea:       " + getFechaCrea()
        + "\n FechaModifica:   " + getFechaModifica();
    }
}
