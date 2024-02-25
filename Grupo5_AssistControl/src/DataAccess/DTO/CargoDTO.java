/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 23.feb.2k24
Script: Creacion de la clase CargoDTO
*/
package DataAccess.DTO;

public class CargoDTO {
    private int    IdCargo;
    private int    IdCargoPadre;
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;

    public CargoDTO() {}

    public CargoDTO(int idCargo, int idCargoPadre, String nombre, String estado, String fechaCrea,
            String fechaModifica) {
        this.IdCargo = idCargo;
        this.IdCargoPadre = idCargoPadre;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }
    
    public int getIdCargo() {
        return IdCargo;
    }
    public void setIdCargo(int idCargo) {
        IdCargo = idCargo;
    }
    public int getIdCargoPadre() {
        return IdCargoPadre;
    }
    public void setIdCargoPadre(int idCargoPadre) {
        IdCargoPadre = idCargoPadre;
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
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdCargo:          " + getIdCargo()
        + "\n IdCargoPadre:     " + getIdCargoPadre()
        + "\n Nombre:           " + getNombre()
        + "\n Estado:           " + getEstado()
        + "\n FechaCrea:        " + getFechaCrea()
        + "\n FechaModifica:    " + getFechaModifica();
    }
}