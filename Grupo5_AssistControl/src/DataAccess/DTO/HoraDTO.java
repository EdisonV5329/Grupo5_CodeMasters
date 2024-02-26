/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| matheus.velasco@epn.edu.ec   MATHEUSX  |
|----------------------------------------|
Autor: MATHEUSX
Fecha: 25.feb.2k24
script: Creacion de la clase HoraDTO
versión: 1.0
---------------------------------------*/
package DataAccess.DTO;

public class HoraDTO {
    private int   IdHora;
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    
    public HoraDTO() {}

    public HoraDTO(int idHora, String nombre, String estado, String fechaCrea, String fechaModifica) {
        this.IdHora = idHora;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    public int getIdHora() {
        return IdHora;
    }
    public void setIdHora(int idHora) {
        IdHora = idHora;
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
        + "\nIdHora:       " + getIdHora() 
        + "\nNombre:       " + getNombre() 
        + "\nEstado:       " + getEstado()
        + "\nFechacrea:    " + getFechaCrea()
        + "\nFechaModifica:" + getFechaModifica();
    }
}
