/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la clase PersonaSexoDTO
*/
package DataAccess.DTO;

public class PersonaSexoDTO {
    private int    IdPersonaSexo;       
    private String Nombre;       
    private String Estado;       
    private String FechaCrea;    
    private String FechaModifica;

    public PersonaSexoDTO() {
    }

    public PersonaSexoDTO(int idPersonaSexo, String nombre, String estado, String fechaCrea, String fechaModifica) {
        IdPersonaSexo = idPersonaSexo;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public int getIdPersonaSexo() {
        return IdPersonaSexo;
    }
    public void setIdPersonaSexo(int idPersonaSexo) {
        IdPersonaSexo = idPersonaSexo;
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
        + "\nIdSexo:        " + getIdPersonaSexo()             
        + "\nNombre:        " + getNombre()             
        + "\nEstado:        " + getEstado()             
        + "\nFechaCrea:     " + getFechaCrea()       
        + "\nFechaModifica: " + getFechaModifica();   
    }
}
