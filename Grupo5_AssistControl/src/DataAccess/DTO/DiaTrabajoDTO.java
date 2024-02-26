/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
script: Creacion de la clase DiaTrabajoDTO
versión: 1.0
---------------------------------------*/
package DataAccess.DTO;

public class DiaTrabajoDTO {
    private int    IdDiaTrabajo;
	private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public DiaTrabajoDTO(){}

    public DiaTrabajoDTO(int idDiaTrabajo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdDiaTrabajo = idDiaTrabajo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public int getIdDiaTrabajo() {
        return IdDiaTrabajo;
    }
    public void setIdDiaTrabajo(int idDiaTrabajo) {
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
