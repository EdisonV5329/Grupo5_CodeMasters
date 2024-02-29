/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 19.feb.2k24
Script: Creacion de la clase PersonaRolDTO
*/
package DataAccess.DTO;
public class PersonaRolDTO {
    private Integer    IdPersonaRol;       
    private Integer    IdPersonaRol_Padre; 
    private String Nombre;
    private String Estado;       
    private String FechaCrea;    
    private String FechaModifica;
    
    
    public PersonaRolDTO() {}
    
    public PersonaRolDTO(Integer idPersonaRol_Padre, String nombre) {
        this.IdPersonaRol_Padre = idPersonaRol_Padre;
        this.Nombre = nombre;
    }
    
    public PersonaRolDTO(Integer idPersonaRol, Integer idPersonaRol_Padre, String nombre, String estado, String fechaCrea,
            String fechaModifica) {
        IdPersonaRol = idPersonaRol;
        IdPersonaRol_Padre = idPersonaRol_Padre;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdPersonaRol() {
        return IdPersonaRol;
    }

    public void setIdPersonaRol(Integer idPersonaRol) {
        IdPersonaRol = idPersonaRol;
    }

    public Integer getIdPersonaRol_Padre() {
        return IdPersonaRol_Padre;
    }

    public void setIdPersonaRol_Padre(Integer idPersonaRol_Padre) {
        IdPersonaRol_Padre = idPersonaRol_Padre;
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
        + "\nIdPersonaRol:       " + getIdPersonaRol()             
        + "\nIdPersonaRol_Padre: " + getIdPersonaRol_Padre()             
        + "\nNombre:             " + getNombre()             
        + "\nEstado:             " + getEstado()             
        + "\nFechaCrea:          " + getFechaCrea()       
        + "\nFechaModifica:      " + getFechaModifica();   
    }
}
