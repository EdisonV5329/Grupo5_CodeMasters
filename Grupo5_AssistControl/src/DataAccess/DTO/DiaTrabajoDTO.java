/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: MATHEUSX y mateitopro
Fecha: 25.feb.2k24
script: Creacion de la clase DiaTrabajoDTO
versión: 1.0
---------------------------------------*/
package DataAccess.DTO;

public class DiaTrabajoDTO {
    private Integer    IdDiaTrabajo;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public DiaTrabajoDTO(){}

    private String Nombre;
    public DiaTrabajoDTO(String nombre) {
        Nombre = nombre;
    }

    public DiaTrabajoDTO(Integer idDiaTrabajo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdDiaTrabajo = idDiaTrabajo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public Integer getIdDiaTrabajo() {
        return IdDiaTrabajo;
    }
    public void setIdDiaTrabajo(Integer idDiaTrabajo) {
        IdDiaTrabajo = idDiaTrabajo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
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
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    
    @Override
    public String toString(){
        return getClass().getName()
        + "\nIdDiaTrabajo:       " + getIdDiaTrabajo()
        + "\nNombre:             " + getNombre()
        + "\nEstado:             " + getEstado()
        + "\nFechacrea:          " + getFechaCrea()
        + "\nFechaModifica:      " + getFechaModifica();

    }
}
